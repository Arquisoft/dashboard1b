package es.uniovi.asw;

import java.util.Date;

import javax.persistence.*;

/**
 * Clase que adapta los ciudadanos creados para su posterior insercion en la
 * base de datos
 * @author Sergio
 */
@Entity
@Table(name="Persona")
public class CitizenDB {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; //Id autogenerado cuando se inserta el ciudadano a la BD
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String surname;
	@Column(unique = true, nullable = false)
	private String mail;
	@Column(nullable = false)
	private Date birthday;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private String nationality;
	@Column(unique = true, nullable = false)
	private String DNI;
	@Column(nullable = true)
	private String password; //La password que se va a poner al ciudadano
	

	/**Constructor de la clase CitizenDB
	 * 
	 * @param name: nombre del citizen
	 * @param surname: apellidos del citizen
	 * @param mail: email del citizen
	 * @param bithday: cumpleaños del citizen
	 * @param address: direccion del citizen
	 * @param nationality: naciolidad del citizen
	 * @param DNI: DNI del citizen
	 */
	public CitizenDB(String name,String surname,String mail,Date bithday,
			String address,String nationality,String DNI){
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.birthday = bithday;
		this.address = address;
		this.nationality = nationality;
		this.DNI = DNI;
	}
	
	
	/**Metodo de modificacion del atributo id
	 * @param id : id del citizen
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**Metodo de modificacion del atributo name
	 * @param name : name del citizen
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**Metodo de modificacion del atributo surname
	 * @param surname : surname del citizen
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**Metodo de modificacion del atributo mail
	 * @param mail : mail del citizen
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**Metodo de modificacion del atributo birthday
	 * @param birthday : birthday del citizen
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**Metodo de modificacion del atributo address
	 * @param address : address del citizen
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**Metodo de modificacion del atributo nationality
	 * @param nationality : nationality del citizen
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**Metodo de modificacion del atributo DNI
	 * @param DNI : DNI del citizen
	 */
	public void setDNI(String DNI) {
		this.DNI = DNI;
	}
	
	/**Metodo de modificacion del atributo password
	 * @param password : password del citizen
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**Constructor sin parametros
	*/
	public CitizenDB(){
		
	}
	
	/**Metodo de acceso al atributo id
	 * @return devuelve el atributo id
	 */
	public Long getId() {
		return id;
	}
	
	/**Metodo de acceso al atributo name
	 * @return devuelve el atributo name
	 */
	public String getName() {
		return name;
	}

	/**Metodo de acceso al atributo surname
	 * @return devuelve el atributo surname
	 */
	public String getSurname() {
		return surname;
	}

	/**Metodo de acceso al atributo mail
	 * @return devuelve el atributo mail
	 */
	public String getMail() {
		return mail;
	}

	/**Metodo de acceso al atributo birthday
	 * @return devuelve el atributo birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**Metodo de acceso al atributo address
	 * @return devuelve el atributo address
	 */
	public String getAddress() {
		return address;
	}

	/**Metodo de acceso al atributo nationality
	 * @return devuelve el atributo nationality
	 */
	public String getNationality() {
		return nationality;
	}

	/**Metodo de acceso al atributo password
	 * @return devuelve el atributo password
	 */
	public String getPassword() {
		return password;
	}

	/**Metodo de acceso al atributo DNI
	 * @return devuelve el atributo DNI
	 */
	public String getDNI() {
		return DNI;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override 
	public String toString(){
		return "[Nombre: " +name+"] [Apellido: "+surname+"] [E-Mail: "+mail
				+"] [Cumpleaños: "+birthday+"] [Direccion: "+address
				+"] [Nacionalidad: "+nationality+"] [DNI: "+DNI+"]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DNI == null) ? 0 : DNI.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CitizenDB other = (CitizenDB) obj;
		if (DNI == null) {
			if (other.DNI != null)
				return false;
		} else if (!DNI.equals(other.DNI))
			return false;
		return true;
	}
	
	
}
