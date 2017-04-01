package asw.DBManagement.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name= "opinion")
public class Opinion {
	
	private String idUser;
	private String idSugerencua;
	private Date fecha;
	private boolean apoyo;
	private boolean texto;
	
	public Opinion() {}

	public Opinion(String idUser, String idSugerencua, Date fecha) {
		super();
		this.idUser = idUser;
		this.idSugerencua = idSugerencua;
		this.fecha = fecha;
	}

	public String getIdUser() {
		return idUser;
	}
	@XmlElement
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getIdSugerencua() {
		return idSugerencua;
	}
	@XmlElement
	public void setIdSugerencua(String idSugerencua) {
		this.idSugerencua = idSugerencua;
	}

	public Date getFecha() {
		return fecha;
	}
	@XmlElement
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isApoyo() {
		return apoyo;
	}
	@XmlElement
	public void setApoyo(boolean apoyo) {
		this.apoyo = apoyo;
	}

	public boolean isTexto() {
		return texto;
	}
	@XmlElement
	public void setTexto(boolean texto) {
		this.texto = texto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (apoyo ? 1231 : 1237);
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((idSugerencua == null) ? 0 : idSugerencua.hashCode());
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
		result = prime * result + (texto ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Opinion other = (Opinion) obj;
		if (apoyo != other.apoyo)
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (idSugerencua == null) {
			if (other.idSugerencua != null)
				return false;
		} else if (!idSugerencua.equals(other.idSugerencua))
			return false;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		if (texto != other.texto)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Opinion [idUser=" + idUser + ", idSugerencua=" + idSugerencua + ", fecha=" + fecha + ", apoyo=" + apoyo
				+ ", texto=" + texto + "]";
	}
}
