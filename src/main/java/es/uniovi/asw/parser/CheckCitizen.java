package es.uniovi.asw.parser;

import java.util.Date;
import es.uniovi.asw.ReportWriter.WriteReport;
import es.uniovi.asw.dbupdate.WReportR;
import es.uniovi.asw.CitizenDB;


/**
 * @author oliver
 *
 */
public class CheckCitizen {
	
	private  WriteReport report = new WReportR();

	/**
	 * @param citizen Usuario del que se quiere a comprobar los datos
	 * @return trtue en caso de que todas las comprobaciones a realizar sean correctas,
	 * false en caso contrario.
	 */
	public boolean checkCitizenInformation(CitizenDB citizen){
		return checkFieldString(citizen.getName(),"name") 
				&& checkFieldString(citizen.getSurname(),"surname") 
				&& checkMail(citizen.getMail()) 
				&& checkBirthday(citizen.getBirthday()) 
				&& checkFieldString(citizen.getAddress(),"Address")
				&& checkFieldString(citizen.getNationality(),"Nationality") 
				&& checkDNI(citizen.getDNI());
	}

	
	/**Metodo que se encarga de comprobar si el campo dni esta vacio 
	 * @param dni: campo a comprobar
	 * @return devuelve true en caso de que no este vacio y false en caso de que si, ademas
	 * en este caso escribiria el error en el log
	 */
	public boolean checkDNI(String dni) {
		if(!checkFieldString(dni, "dni")){
			report.log("El dni esta vacio.");
			return false;
		}
		else if (dni.length() != 9 || Character.isDigit(dni.toString().charAt(dni.length()-1))
				|| !areDigits(dni.substring(0, 7))){
			report.log("El dni no tiene el formato correcto.");
			return false;
		}
		
		return true;
	}

	/**Metodo que se encarga de comprobar si una cadena son numeros
	 * @param substring: cadena a comprobar
	 * @return devueve true si la cadena son numeros y false si no
	 */
	public boolean areDigits(String substring) {
		for(int i = 0; i<substring.length() ; i++)
			if(Character.isLetter(substring.toString().charAt(i)))
				return false;
		return true;
	}


	/**Metodo que se encarga de comprobar si el campo birthday es nulo
	 * @param birthday: campo a comprobar
	 * @return devuelve true en caso de que no sea null y false en caso de que si, ademas
	 * en este caso escribiria el error en el log
	 */
	public boolean checkBirthday(Date birthday) {
		if(birthday == null){
			report.log("El campo birthday esta vacio.");
			return false;
		}
		return true;
	}

	/**Metodo que se encarga de comprobar si el campo Mail esta vacio y si tiene el formato correcto
	 * @param mail: mail que queremos comprobar
	 * @return devuelve true en caso de que el campo no este vacio y tenga el formato correcto y 
	 * falso en el caso de que esto no se cierto, ademas en este caso se escribiria un error en el log
	 */
	public boolean checkMail(String mail) {
		if(!checkFieldString(mail, "mail")){
			report.log("El mail esta vacio.");
			return false;
		}
		else if (!mail.toString().contains(".") ||!mail.toString().contains("@")
				|| mail.toString().startsWith("@") ||  mail.toString().startsWith(".") 
				|| mail.toString().charAt(mail.length()-1) == '.' 
				|| mail.toString().charAt(mail.length()-1) == '@'){
			report.log("El mail no tiene el formato correcto.");
			return false;	
		}
			
		return true;
	}

	
	/**Metodo que se encarga de comprobar si algun un campo esta vacio
	 * @param field: campo que queremos comprobar
	 * @param attribute: nombre del campo
	 * @return devuelve true en caso de que el campo no este vacio y falso en el caso de que si
	 * ademas en este caso se escribiria un error en el log
	 */
	public boolean checkFieldString(String field , String attribute) {
		if(field.isEmpty()){
			return false;
		}
		return true;
	}
}
