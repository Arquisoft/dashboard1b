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

    @ManyToOne
    private Sugerencia sugerencia;

    public Comentario(String texto, Ciudadano ciudadano) {
        super();
        this.texto = texto;
        this.ciudadano = ciudadano;
    }

    public Comentario() {
    }

    ;

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    void _setCiudadano(Ciudadano ciudadano) {
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

    public Sugerencia getSugerencia() {
        return sugerencia;
    }

    public void setSugerencia(Sugerencia sugerencia) {
        this.sugerencia = sugerencia;
    }

    @Override
    public String toString() {
        return "Comentario [id=" + id + ", texto=" + texto + ", ciudadano=" + ciudadano + "]";
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Comentario other = (Comentario) obj;
		if (id != other.id)
			return false;
		return true;
	}
    
    
}
