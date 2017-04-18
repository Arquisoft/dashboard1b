package es.uniovi.asw;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import es.uniovi.asw.parser.CheckCitizen;


/**
 * @author oliver
 *
 */
public class CheckCitizenTest {

	CheckCitizen checkCitizen = new CheckCitizen();
	
	@Test
	public void checkCitizen() throws ParseException {
		SimpleDateFormat d = new SimpleDateFormat("dd-MM-yy");
		Date date =  d.parse("01-03-1996");
		CitizenDB citizenDBOk  = new CitizenDB("Nombre","Apellidos","email@gmail.com",date,
				"Calle","España","12345678A");
		CitizenDB citizenDBOkFieldEmpty  = new CitizenDB("","Apellidos","email@gmail.com",date,
				"Calle","España","12345678A");
		CitizenDB citizenDBErrorEmail  = new CitizenDB("Nombre","Apellidos","emailgmail.com",date,
				"Calle","España","12345678A");
		CitizenDB citizenDBNullBirtday  = new CitizenDB("Nombre","Apellidos","email@gmail.com",null,
				"Calle","España","12345678A");
		CitizenDB citizenDBErrorDNI  = new CitizenDB("Nombre","Apellidos","email@gmail.com",date,
				"Calle","España","1234578A");
		CitizenDB citizenDBApellidosVacio  = new CitizenDB("Nombre","","email@gmail.com",date,
				"Calle","España","12345678A");
		CitizenDB citizenDBDireccionVacia  = new CitizenDB("Nombre","Apellidos","email@gmail.com",date,
				"","España","12345678A");
		CitizenDB citizenDBNacionalidadVacia  = new CitizenDB("Nombre","Apellidos","email@gmail.com",date,
				"Calle","","12345678A");
		
		
		assertTrue(checkCitizen.checkCitizenInformation(citizenDBOk));
		assertFalse(checkCitizen.checkCitizenInformation(citizenDBOkFieldEmpty));
		assertFalse(checkCitizen.checkCitizenInformation(citizenDBErrorEmail));
		assertFalse(checkCitizen.checkCitizenInformation(citizenDBNullBirtday));
		assertFalse(checkCitizen.checkCitizenInformation(citizenDBErrorDNI));
		assertFalse(checkCitizen.checkCitizenInformation(citizenDBApellidosVacio));
		assertFalse(checkCitizen.checkCitizenInformation(citizenDBDireccionVacia));
		assertFalse(checkCitizen.checkCitizenInformation(citizenDBNacionalidadVacia));
	}
	
	@Test
	public void checkDNI() {
		String dniValido = "12345678A";
		String dniVacio = "";
		String dniCorto = "1234567A";
		String dniNumeros = "123456789";
		String dniLetras = "ABCDEFGHI";
		String dniLetraMedio = "1234A5678";
		
		assertTrue(checkCitizen.checkDNI(dniValido));
		assertFalse(checkCitizen.checkDNI(dniVacio));
		assertFalse(checkCitizen.checkDNI(dniCorto));
		assertFalse(checkCitizen.checkDNI(dniNumeros));
		assertFalse(checkCitizen.checkDNI(dniLetras));
		assertFalse(checkCitizen.checkDNI(dniLetraMedio));
	}
	
	@Test
	public void checkBirthday() throws ParseException{
		SimpleDateFormat d = new SimpleDateFormat("dd-MM-yy");
		Date dateValida =  d.parse("01-03-1996");
		Date dateNull = null;
		
		assertTrue(checkCitizen.checkBirthday(dateValida));
		assertFalse(checkCitizen.checkBirthday(dateNull));
		
	}
	
	@Test
	public void checkMail(){
		String mailValido = "email@gmail.com";
		String mailVacio = "";
		String mailSinPunto = "email@gmailcom";
		String mailSinArroba = "emailgmail.com";
		String mailCArroba = "@email@gmail.com";
		String mailCPunto = ".email@gmail.com";
		String mailFPunto = "email@gmailcom.";
		String mailFArroba = "emailgmail.com@";
		
		assertTrue(checkCitizen.checkMail(mailValido));
		assertFalse(checkCitizen.checkMail(mailVacio));
		assertFalse(checkCitizen.checkMail(mailSinPunto));
		assertFalse(checkCitizen.checkMail(mailSinArroba));
		assertFalse(checkCitizen.checkMail(mailCArroba));
		assertFalse(checkCitizen.checkMail(mailCPunto));
		assertFalse(checkCitizen.checkMail(mailFPunto));
		assertFalse(checkCitizen.checkMail(mailFArroba));
	}
	
	@Test
	public void checkFieldString(){
		String vacio = "";
		String s = "prueba";
		
		assertFalse(checkCitizen.checkFieldString(vacio, "Prueba"));
		assertTrue(checkCitizen.checkFieldString(s, "Prueba"));
	}
	
	@Test
	public void areDigits(){
		String cadenaDigitos = "123456789";
		String cadenaMixta = "123ABC456";
		String cadenaCaracteres = "ABCDEFGHI";
		String cadenaEspecial = "1-A/t_2:3";
		
		assertTrue(checkCitizen.areDigits(cadenaDigitos));
		assertFalse(checkCitizen.areDigits(cadenaMixta));
		assertFalse(checkCitizen.areDigits(cadenaCaracteres));
		assertFalse(checkCitizen.areDigits(cadenaEspecial));
	}
	
	@Test
	public void toStringTest() throws ParseException{
		SimpleDateFormat d = new SimpleDateFormat("dd-MM-yy");
		Date date =  d.parse("01-03-1996");
		CitizenDB citizenDBOk  = new CitizenDB("Nombre","Apellidos","email@gmail.com",date,
				"Calle","España","12345678A");
		String correctToString = "[Nombre: " +"Nombre"+"] [Apellido: "+"Apellidos"+"] [E-Mail: "+"email@gmail.com"
				+"] [Cumpleaños: "+date+"] [Direccion: "+"Calle"
				+"] [Nacionalidad: "+"España"+"] [DNI: "+"12345678A"+"]";
		
		String incorrecto = "{Nombre: " +"Nombre"+"] [Apellido: "+"Apellidos"+"] [E-Mail: "+"email@gmail.com"
				+"] [Cumpleaños: "+date+"] [Direccion: "+"Calle"
				+"] [Nacionalidad: "+"España"+"] [DNI: "+"12345678A"+"}";
		
		assertEquals(citizenDBOk.toString(), correctToString);
		assertFalse(citizenDBOk.toString().equals(incorrecto));
	}
	
	@Test
	public void hashCodeTest() throws ParseException{
		SimpleDateFormat d = new SimpleDateFormat("dd-MM-yy");
		Date date =  d.parse("01-03-1996");
		CitizenDB citizenDBOk  = new CitizenDB("Nombre","Apellidos","email@gmail.com",date,
				"Calle","España","12345678A");
		
		assertEquals(-1867378596, citizenDBOk.hashCode());
	}
	
	@Test
	public void equalsTest() throws ParseException{
		SimpleDateFormat d = new SimpleDateFormat("dd-MM-yy");
		Date date =  d.parse("01-03-1996");
		CitizenDB citizenDBOk  = new CitizenDB("Nombre","Apellidos","email@gmail.com",date,
				"Calle","España","12345678A");
		CitizenDB citizenDBOk1  = new CitizenDB("Nombre","Apellidos","email@gmail.com",date,
				"Calle","España","12345678A");
		CitizenDB citizenDBOk2  = new CitizenDB("Nombre","Apellidos","email@gmail.com",date,
				"Calle","España","12345679A");
		
		assertTrue(citizenDBOk.equals(citizenDBOk1));
		assertFalse(citizenDBOk.equals(citizenDBOk2));
	}

}
