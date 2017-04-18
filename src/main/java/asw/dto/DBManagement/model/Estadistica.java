package asw.dto.DBManagement.model;

import java.util.Map;

public class Estadistica {
	
	private String titulo;
	private long idSugerencia;
	private Map<String,Integer> campos;
	
	public Estadistica(String titulo, Map<String, Integer> campos) {
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

	public Map<String, Integer> getCampos() {
		return campos;
	}

	public void setCampos(Map<String, Integer> campos) {
		this.campos = campos;
	}

	public long getIdSugerencia() {
		return idSugerencia;
	}

	public void setIdSugerencia(long idSugerencia) {
		this.idSugerencia = idSugerencia;
	}

}
