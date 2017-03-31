package asw.DBManagement.model;

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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumeroComentarios() {
		return numeroComentarios;
	}
	public void setNumeroComentarios(int numeroComentarios) {
		this.numeroComentarios = numeroComentarios;
	}
	public int getNumeroApoyos() {
		return numeroApoyos;
	}
	public void setNumeroApoyos(int numeroApoyos) {
		this.numeroApoyos = numeroApoyos;
	}
	public int getNumeroContra() {
		return numeroContra;
	}
	public void setNumeroContra(int numeroContra) {
		this.numeroContra = numeroContra;
	}



}
