package es.uniovi.asw.parser;

import java.sql.SQLException;
import java.util.List;

import es.uniovi.asw.CitizenDB;
import es.uniovi.asw.dbupdate.Insert;
import es.uniovi.asw.dbupdate.InsertP;

public class InsertR implements Insert{
	
	@Override
	public List<CitizenDB> insert(List<CitizenDB> citizen) throws SQLException {
		//Obtenemos el ciudadano que vamos a insertar y lo enviamos al método
		//insertar de la clase InsertarP perteneciente al elemento DBUpdater
		//que se encargará de insertar el ciudadano en la base de datos.
		// (falta por hacer dicho elemento/paquete asi como sus clases)
		return new InsertP().insert(citizen);
	}

}
