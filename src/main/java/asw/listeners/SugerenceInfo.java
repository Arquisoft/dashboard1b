package asw.listeners;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "sugerenciaInfo")
public class SugerenceInfo {
	
	private long Id;
	private String titulo;
	private Date fecha;
	private boolean aprobacion;
	private int votos;
	private String proveedor;
	
	public SugerenceInfo(){}

	public SugerenceInfo(long id, String titulo, Date fecha, boolean aprobacion, int votos, String proveedor) {
		super();
		Id = id;
		this.titulo = titulo;
		this.fecha = fecha;
		this.aprobacion = aprobacion;
		this.votos = votos;
		this.proveedor = proveedor;
	}
	@XmlElement
	public long getId() {
		return Id;
	}
	@XmlElement
	public String getTitulo() {
		return titulo;
	}
	@XmlElement
	public Date getFecha() {
		return fecha;
	}
	@XmlElement
	public boolean isAprobacion() {
		return aprobacion;
	}
	@XmlElement
	public int getVotos() {
		return votos;
	}
	@XmlElement
	public String getProveedor() {
		return proveedor;
	}

	@Override
	public String toString() {
		return "SugerenceInfo [Id=" + Id + ", titulo=" + titulo + ", fecha=" + fecha + ", aprobacion=" + aprobacion
				+ ", votos=" + votos + ", proveedor=" + proveedor + "]";
	}
	
}
