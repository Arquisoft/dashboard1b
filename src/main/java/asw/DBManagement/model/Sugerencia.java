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
	private long Id;
	private String titulo;
	private Date fecha;
	private boolean aprobacion;
	private int votos;
	
	@ManyToOne private Ciudadano ciudadano;
	
	public Sugerencia(String titulo, Date fecha, boolean aprobacion, int votos) {
		super();
		this.titulo = titulo;
		this.fecha = fecha;
		this.aprobacion = aprobacion;
		this.votos = votos;
	}
	
	public Sugerencia(String titulo, Date fecha, boolean aprobacion, int votos , Ciudadano proveedor) {
		super();
		this.titulo = titulo;
		this.fecha = fecha;
		this.aprobacion = aprobacion;
		this.votos = votos;
		this.ciudadano=proveedor;
	}
	
	public Sugerencia(){}
	public Ciudadano getProveedor(){
		return ciudadano;
	}
	
	public void _setCiudadano(Ciudadano ciudadano){
		this.ciudadano = ciudadano;
	}
	
	public long getId() {
		return Id;
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
