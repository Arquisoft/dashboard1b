package asw.model;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import asw.model.key.CommentKey;

@Entity
@IdClass(CommentKey.class)
@Table(name = "Comentario")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private CitizenDB citizenDB;
	@ManyToOne
	private Suggestion suggestion;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	private String text;
	private int numero_votos;
	@OneToMany(mappedBy = "comment")
	private Set<VoteComment> voteComments = new HashSet<VoteComment>();
	
	public Comment(){
		
	}
	
	public Comment(Long id ,CitizenDB citizenDB , Suggestion suggestion , String text ){
		Association.Comentar.link(citizenDB, suggestion, this);
		this.date = Calendar.getInstance().getTime();
		this.text = text;
		this.numero_votos = 0;
		this.id = id;
	}

	
	
	public Long getId() {
		return id;
	}

	public int getNumero_votos() {
		return numero_votos;
	}

	public void setNumero_votos(int numero_votos) {
		this.numero_votos = numero_votos;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Set<VoteComment> getVoteComments() {
		return voteComments;
	}
	
	Set<VoteComment> _getVoteComments() {
		return voteComments;
	}

	public void setVoteComments(Set<VoteComment> voteComments) {
		this.voteComments = voteComments;
	}

	public CitizenDB getCitizenDB() {
		return citizenDB;
	}
	
	void _setCitizenDB(CitizenDB citizenDB) {
		this.citizenDB = citizenDB ;
	}

	public Suggestion getSuggestion() {
		return suggestion;
	}
	
	void _setSuggestion(Suggestion suggestion) {
		this.suggestion = suggestion;
	}

	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((citizenDB == null) ? 0 : citizenDB.hashCode());
		result = prime * result + ((suggestion == null) ? 0 : suggestion.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
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
		Comment other = (Comment) obj;
		if (citizenDB == null) {
			if (other.citizenDB != null)
				return false;
		} else if (!citizenDB.equals(other.citizenDB))
			return false;
		if (suggestion == null) {
			if (other.suggestion != null)
				return false;
		} else if (!suggestion.equals(other.suggestion))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}
	
 
	
}
