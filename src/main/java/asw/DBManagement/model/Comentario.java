package asw.DBManagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Comentario {

	@Id
	@GeneratedValue
	private long idComentario;
	private long idSugerencia;
	private long idCiudadano;
	private String texto;
	
	public Comentario(long idSugerencia, long idCiudadano, String texto) {
		super();
		this.idSugerencia = idSugerencia;
		this.idCiudadano = idCiudadano;
		this.texto = texto;
	}
	
	Comentario(){};
	
	public long getIdSugerencia() {
		return idSugerencia;
	}
	public void setIdSugerencia(long idSugerencia) {
		this.idSugerencia = idSugerencia;
	}
	public long getIdCiudadano() {
		return idCiudadano;
	}
	public void setIdCiudadano(long idCiudadano) {
		this.idCiudadano = idCiudadano;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public long getIdComentario() {
		return idComentario;
	}

	@Override
	public String toString() {
		return "Comentario [idComentario=" + idComentario + ", idSugerencia=" + idSugerencia + ", idCiudadano="
				+ idCiudadano + ", texto=" + texto + "]";
	}
	
}
