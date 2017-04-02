package asw.DBManagement.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Sugerencia {

	@Id
	@GeneratedValue
	private Long IdSugerencia;
	private Long idCiudadano;
	private String titulo;
	private Date fecha;
	private boolean aprobacion;
	private int votos;
	
	
	Sugerencia(){}
	
	public Sugerencia(long idCiudadano, String titulo, Date fecha, boolean aprobacion, int votos) {
		super();
		this.titulo = titulo;
		this.fecha = fecha;
		this.aprobacion = aprobacion;
		this.votos = votos;
	}

	public Long getIdSugerencia() {
		return IdSugerencia;
	}

	public void setIdSugerencia(Long idSugerencia) {
		IdSugerencia = idSugerencia;
	}
	
	public long getId() {
		return Id;
	}

	public void setIdCiudadano(Long idCiudadano) {
		this.idCiudadano = idCiudadano;
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


	@Override
	public String toString() {
		return "Sugerencia [IdSugerencia=" + Id + ", titulo=" + titulo
				+ ", fecha=" + fecha + ", aprobacion=" + aprobacion + ", votos=" + votos + "]";
	}
}
