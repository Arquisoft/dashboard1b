package es.uniovi.asw.letters;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import es.uniovi.asw.CitizenDB;


public class DefaultLetter extends AbstractWriteLetter{
	
	public DefaultLetter(List<CitizenDB> citizens,String message){
		super(citizens,message);
		for(CitizenDB citizen : this.citizens)
			this.write(citizen);
	}

	
	@Override
	public void write(CitizenDB citizenDB){
			PrintWriter printWriter;
			try {
				printWriter = new PrintWriter(new FileWriter(
						this.getPath()+"plainText/"+citizenDB.getName()+".txt"));
				printWriter.println("Estimado "+citizenDB.getName());
				printWriter.println(this.message);
				printWriter.println("Usuario: "+citizenDB.getMail());
				printWriter.println("Contraseña: "+citizenDB.getPassword());
				printWriter.close();
			} catch (IOException e) {
				System.err.println("Error al generar el email para el usuario con DNI: "+citizenDB.getDNI());
				e.printStackTrace();
			}
	}
}
