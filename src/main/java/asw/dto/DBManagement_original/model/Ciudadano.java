package asw.DBManagement_original.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Ciudadano {
	
	@Id
	@GeneratedValue
	private Long id;

	private String nombre;
	private String apellidos;
	private String email;
	private Date fechaNacimiento;
	private String residencia;
	private String nacionalidad;
	private String dni;

	private String password;
	
	
	
	
	public Ciudadano(String nombre, String apellidos, String email, Date fechaNacimiento, String residencia,
			String nacionalidad, String dni, String password) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.residencia = residencia;
		this.nacionalidad = nacionalidad;
		this.dni = dni;
		this.password = password;
	}

	Ciudadano(){}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getResidencia() {
		return residencia;
	}

	public void setResidencia(String residencia) {
		this.residencia = residencia;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Ciudadano [nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", fechaNacimiento="
				+ fechaNacimiento + ", residencia=" + residencia + ", nacionalidad=" + nacionalidad + ", dni=" + dni
				+ ", password=" + password + "]";
	}


}
