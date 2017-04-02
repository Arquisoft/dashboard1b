package asw.DBManagement.model;

import java.util.Map;

public class Estadistica {
	
	private String titulo;
	private long idSugerencia;
	private Map<String,Double> campos;
	
	public Estadistica(String titulo, Map<String,Double> campos) {
		super();
		this.titulo = titulo;
		this.campos = campos;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Map<String, Double> getCampos() {
		return campos;
	}

	public void setCampos(Map<String, Double> campos) {
		this.campos = campos;
	}

	public long getIdSugerencia() {
		return idSugerencia;
	}

	public void setIdSugerencia(long idSugerencia) {
		this.idSugerencia = idSugerencia;
	}
	
	

}
