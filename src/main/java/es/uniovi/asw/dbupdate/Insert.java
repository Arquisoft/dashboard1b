package es.uniovi.asw.dbupdate;

import java.sql.SQLException;
import java.util.List;

import es.uniovi.asw.CitizenDB;

public interface Insert {

	/**
	 * /**
	 * Método que inserta el objeto creado previamente en la base de datos
	 * @param citizen Lista de ciudadanos que van a ser insertados en la base de datos.
	 * @return La lista de ciudadanos insertados
	 * @throws SQLException En caso de que haya algun tipo cualquiera de excepcion SQL
	 */
	List<CitizenDB> insert(List<CitizenDB> citizen) throws SQLException;
	
}
