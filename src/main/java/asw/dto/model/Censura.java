package asw.model;

import java.util.ArrayList;

public class Censura {

	private static ArrayList<String> palabrasCensuradas = new ArrayList<String>();
	private static Comment comment;
	
	public Censura (Comment comment){
		this.comment = comment;
	}

	public static void cargarCensuras() {
		palabrasCensuradas = new ArrayList<String>();
		//Faltaria encontrar una lista de palabras "prohibidas"
	}

	/*
	 * Metodo para censurar palabras no permitidas
	 */
	public static void censurar(Suggestion suggestion) {
		String contenido = suggestion.getContent();
		for (int i = 0; i < palabrasCensuradas.size(); i++) {
			if (contenido.contains(palabrasCensuradas.get(i))) {
				contenido.replace(palabrasCensuradas.get(i), "****");
			}
		}

	}

}
