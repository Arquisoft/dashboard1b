package asw.DBManagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comentario {

	@Id
	@GeneratedValue
	private long id;
	private String texto;
	@ManyToOne
	private Ciudadano ciudadano;
	
	public Comentario(String texto, Ciudadano ciudadano) {
		super();
		this.texto = texto;
		this.ciudadano = ciudadano;
	}

	Comentario(){};

	public Ciudadano getCiudadano(){
		return ciudadano;
	}
	
	void _setCiudadano(Ciudadano ciudadano){
		this.ciudadano = ciudadano;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTexto() {
		return texto;
	}


	public void setTexto(String texto) {
		this.texto = texto;
	}


	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}
	
	@Override
	public String toString() {
		return "Comentario [id=" + id + ", texto=" + texto + ", ciudadano=" + ciudadano + "]";
	}
}
