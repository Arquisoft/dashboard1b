package asw.DBManagement.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sugerencia {

	@Id
	@GeneratedValue
	private long IdSugerencia;
	private long idCiudadano;
	private String titulo;
	private Date fecha;
	private boolean aprobacion;
	private int votos;
	
	public Sugerencia(long idCiudadano, String titulo, Date fecha, boolean aprobacion, int votos) {
		super();
		this.idCiudadano = idCiudadano;
		this.titulo = titulo;
		this.fecha = fecha;
		this.aprobacion = aprobacion;
		this.votos = votos;
	}

	public long getIdSugerencia() {
		return IdSugerencia;
	}

	public void setIdSugerencia(long idSugerencia) {
		IdSugerencia = idSugerencia;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isAprobacion() {
		return aprobacion;
	}

	public void setAprobacion(boolean aprobacion) {
		this.aprobacion = aprobacion;
	}

	public int getVotos() {
		return votos;
	}

	public void setVotos(int votos) {
		this.votos = votos;
	}

	public Long getIdCiudadano() {
		return idCiudadano;
	}

	@Override
	public String toString() {
		return "Sugerencia [IdSugerencia=" + IdSugerencia + ", idCiudadano=" + idCiudadano + ", titulo=" + titulo
				+ ", fecha=" + fecha + ", aprobacion=" + aprobacion + ", votos=" + votos + "]";
	}

}
