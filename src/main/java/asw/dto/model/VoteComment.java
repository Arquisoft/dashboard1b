package asw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import asw.model.key.VoteCommentKey;

@Entity
@IdClass(VoteCommentKey.class)
@Table(name="VotoComentario")
public class VoteComment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Comment comment;
	@ManyToOne
	private CitizenDB citizenDB;
	
	public VoteComment() {
	}
	
	public VoteComment(long id ,Comment comment , CitizenDB citizenDB){
		Association.votarComentario.link(citizenDB, comment, this);
		this.id = id;
	}
	
	public VoteComment(Comment comment , CitizenDB citizenDB){
		Association.votarComentario.link(citizenDB, comment, this);
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Comment getComment() {
		return comment;
	}

	void _setComment(Comment comment) {
		this.comment = comment;
	}

	public CitizenDB getCitizenDB() {
		return citizenDB;
	}

	void _setCitizenDB(CitizenDB citizenDB) {
		this.citizenDB = citizenDB;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((citizenDB == null) ? 0 : citizenDB.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
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
		VoteComment other = (VoteComment) obj;
		if (citizenDB == null) {
			if (other.citizenDB != null)
				return false;
		} else if (!citizenDB.equals(other.citizenDB))
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		return true;
	}

	
	

}