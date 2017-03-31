package asw.DBManagement.model;

import java.util.List;

public class Estadistica {
	
	private String titulo;
	private List<String> Campos;
	private List<Double> Valores;
	
	public Estadistica(String titulo, List<String> campos, List<Double> valores) {
		super();
		this.titulo = titulo;
		Campos = campos;
		Valores = valores;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public List<String> getCampos() {
		return Campos;
	}
	public void setCampos(List<String> campos) {
		Campos = campos;
	}
	public List<Double> getValores() {
		return Valores;
	}
	public void setValores(List<Double> valores) {
		Valores = valores;
	}
	
	
	

}
