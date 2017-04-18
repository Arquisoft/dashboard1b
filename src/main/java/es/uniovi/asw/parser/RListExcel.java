package es.uniovi.asw.parser;

import java.io.FileNotFoundException;
import java.util.List;

import es.uniovi.asw.CitizenDB;

public class RListExcel extends RList {
	
	private final String DEFAULT_PATH = "src/test/resources/test.xlsx";
	private AdapterPoi adapter; //adaptador de la librería ApachePoi
	
	/**
	 * Inicializamos la referencia al libro excel con la ruta recibida como
	 * parámetro
	 * @param letterType tipo del fichero
	 * @param path Dirección del fichero a cargar
	 */
	public RListExcel(String letterType,String path){
		super(letterType);
		try {
			this.adapter = new AdapterPoi(path);
		} catch (FileNotFoundException e) {
			System.err.println("Error, la ruta \""+this.DEFAULT_PATH+"\" no contiene un fichero válido");
		} 
	}
	/**
	 * En el constructor por defecto cargamos la hoja de excel "test.xlsx"
	 * de ejemplo
	 * @param letterType tipo del fichero
	 */
	public RListExcel(String letterType){
		super(letterType);
		try {
			this.adapter = new AdapterPoi(DEFAULT_PATH);
		} catch (FileNotFoundException e) {
			System.err.println("Error, la ruta \""+this.DEFAULT_PATH+"\" no contiene un fichero válido");
		}
	}
	
	public List<CitizenDB> readFile(){
		return this.adapter.readExcelFile();
	}
}
