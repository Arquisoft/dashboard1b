package asw.DBManagement.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "sugerencia")
public class Sugerencia {

	private String nombre;
	private int numeroComentarios;
	private int numeroApoyos;
	private int numeroContra;

	public Sugerencia(String nombre, int numeroComentarios, int numeroApoyos, int numeroContra) {
		super();
		this.nombre = nombre;
		this.numeroComentarios = numeroComentarios;
		this.numeroApoyos = numeroApoyos;
		this.numeroContra = numeroContra;
	}

	public String getNombre() {
		return nombre;
	}
	@XmlElement
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumeroComentarios() {
		return numeroComentarios;
	}
	@XmlElement
	public void setNumeroComentarios(int numeroComentarios) {
		this.numeroComentarios = numeroComentarios;
	}
	public int getNumeroApoyos() {
		return numeroApoyos;
	}
	@XmlElement
	public void setNumeroApoyos(int numeroApoyos) {
		this.numeroApoyos = numeroApoyos;
	}
	public int getNumeroContra() {
		return numeroContra;
	}
	@XmlElement
	public void setNumeroContra(int numeroContra) {
		this.numeroContra = numeroContra;
	}



}
