package es.uniovi.asw.parser;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import es.uniovi.asw.CitizenDB;
import es.uniovi.asw.letters.DefaultLetter;
import es.uniovi.asw.letters.PDFLetter;
import es.uniovi.asw.letters.WordLetter;
import es.uniovi.asw.letters.WriteLetter;

/**
 * Clase para la carga de un fichero excel mediante la libreria APache Poi
 * @author david
 */
public abstract class RList implements ReadList{
	
	private String letterType;
	private final String MESSAGE = "mediante el presente mail le adjuntamos su usuario y contraseña de inicio de sesión"
						+ " para nuestra aplicación";
	
	public RList(String letterType){
		this.letterType = letterType;
	}
	
	private WriteLetter getLetterType(String arg,List<CitizenDB> citizens){
		if(arg.compareToIgnoreCase("-w") == 0)
			return new WordLetter(citizens,this.MESSAGE);
		else
			if(arg.compareToIgnoreCase("-p") == 0)
				return new PDFLetter(citizens,this.MESSAGE);
			else
				if(arg.compareToIgnoreCase("-d") == 0) //por defecto
					return new DefaultLetter(citizens,this.MESSAGE);
				else
					throw new IllegalArgumentException(arg+" no es una opción válida.Teclee -help para obtener ayuda");
	}
	
	@Override
	public List<CitizenDB> read() {
		try {
			List<CitizenDB> citizens = new InsertR().insert(this.readFile());
			this.generateLetters(citizens);
		} catch (SQLException e) {
			System.err.println("Error al cargar el fichero de ciudadanos");
			e.printStackTrace();
		}
		 List<CitizenDB> citizens = this.readFile();
		 this.generateLetters(citizens);
		 return citizens;
	}
	
	protected abstract List<CitizenDB> readFile();
	
	/**
	 * Método que se encarga de generar las cartas (con usuario y pass) para cada
	 * uno de los ciudadanos cargados del fichero de entrada
	 * @param citizens La lista de ciudadanos
	 */
	private void generateLetters(List<CitizenDB> citizens){
		try {
			for (CitizenDB citizen : citizens) {
				WriteLetter writer = this.getLetterType(this.letterType, citizens);
				try {
					writer.write(citizen);
				} catch (IOException e) {
					System.err.println("Error al crear la carta para el ciudadano con DNI: " + citizen.getDNI());
				}
			}
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
			return;
		}
		catch(NullPointerException e){
			System.err.println("Error al obtener la lista de ciudadanos");
			return;
		}
	}
	
}
