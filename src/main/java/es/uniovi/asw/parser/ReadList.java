package es.uniovi.asw.parser;

import java.sql.SQLException;
import java.util.List;

import es.uniovi.asw.CitizenDB;

public interface ReadList {
	
	/**
	 * Lee el fichero de excel y hasta la creación de la BD inserta los usuarios
	 * leídos en una lista
	 * @return Lista de los ciudadanos obtenidos en la lectura 
	 */
	List<CitizenDB> read();
}
