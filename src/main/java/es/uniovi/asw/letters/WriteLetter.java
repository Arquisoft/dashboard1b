package es.uniovi.asw.letters;

import java.io.IOException;

import es.uniovi.asw.CitizenDB;

/**
 * Interfaz que implementarán los distintos algoritmos para escribir una las diferentes cartas 
 * (patrón de diseño Strategy)
 * @author david
 *
 */
public interface WriteLetter {
	/**
	 * @param citizenDB TODO
	 * @throws IOException TODO
	 */
	void write(CitizenDB citizenDB) throws IOException;  
}
