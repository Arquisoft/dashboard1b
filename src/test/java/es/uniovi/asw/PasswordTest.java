package es.uniovi.asw;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import es.uniovi.asw.parser.GenerationPassword;


/**
 * @author oliver
 *
 */
public class PasswordTest {
	
	GenerationPassword generationPassword = new GenerationPassword();

	@Test
	public void test() throws ParseException {
	
		SimpleDateFormat d = new SimpleDateFormat("dd-MM-yy");
		Date date =  d.parse("01-03-1996");
		CitizenDB citizenDB  = new CitizenDB("Nombre","Apellidos","email@gmail.com",date,
					"Calle","España","12345678A");
		
		assertNull(citizenDB.getPassword());
		
		citizenDB.setPassword(generationPassword.passwordGenerator());
		
		assertTrue(!citizenDB.getPassword().toString().equals(""));
	}

}
