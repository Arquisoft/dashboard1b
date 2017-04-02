package asw.DBManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ciudadano {
	
	@Id
	@GeneratedValue
	private Long id;		
	public void setPrivilegios(boolean privilegios) {
		this.privilegios = privilegios;
	}

	private String nombre;
	private String apellidos;
	private String email;
	private Date fechaNacimiento;
	private String residencia;
	private String nacionalidad;
	private String dni;
	private String password;
	private boolean privilegios;

	@JsonIgnore
	@OneToMany(mappedBy = "ciudadano")
	private Set<Sugerencia> sugerencia = new HashSet<Sugerencia>();
	@JsonIgnore
	@OneToMany(mappedBy = "ciudadano")
	private Set<Comentario> comentario = new HashSet<Comentario>();
	
	public Ciudadano(String nombre, String apellidos, String email, Date fechaNacimiento, String residencia,
			String nacionalidad, String dni, String password, boolean privilegios) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.residencia = residencia;
		this.nacionalidad = nacionalidad;
		this.dni = dni;
		this.password = password;
		this.privilegios = privilegios;
	}
	
	public Ciudadano(){}

	public Set<Sugerencia> getSugerencia(){
		return new HashSet<Sugerencia>(sugerencia);
	}
	
	Set<Sugerencia> _getSugerencia(){
		return sugerencia;
	}
	
	public Set<Comentario> getComentario(){
		return new HashSet<Comentario>(comentario);
	}
	
	Set<Comentario> _getComentario(){
		return comentario;
	}
	
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

	public boolean isPrivilegios() {
		return privilegios;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ciudadano other = (Ciudadano) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ciudadano [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
				+ ", fechaNacimiento=" + fechaNacimiento + ", residencia=" + residencia + ", nacionalidad="
				+ nacionalidad + ", dni=" + dni + ", password=" + password + ", privilegios=" + privilegios + "]";
	}
	
	

}
