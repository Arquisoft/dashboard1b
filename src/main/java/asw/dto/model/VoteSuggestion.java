package asw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import asw.model.key.VoteSuggestionKey;



@Entity
@IdClass(VoteSuggestionKey.class)
@Table(name="VotoSugerencia")
public class VoteSuggestion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private CitizenDB citizenDB;
	@ManyToOne
	private Suggestion suggestion;
	
	public VoteSuggestion() {
	}
	
	public VoteSuggestion(long id ,CitizenDB citizenDB , Suggestion suggestion){
		Association.votarSugerencia.link(citizenDB, suggestion, this);
		this.id = id;
	}
	
	public VoteSuggestion(CitizenDB citizenDB , Suggestion suggestion){
		Association.votarSugerencia.link(citizenDB, suggestion, this);
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CitizenDB getCitizenDB() {
		return citizenDB;
	}

	void _setCitizenDB(CitizenDB citizenDB) {
		this.citizenDB = citizenDB;
	}

	public Suggestion getSuggestion() {
		return suggestion;
	}

	void _setSuggestion(Suggestion suggestion) {
		this.suggestion = suggestion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((citizenDB == null) ? 0 : citizenDB.hashCode());
		result = prime * result + ((suggestion == null) ? 0 : suggestion.hashCode());
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
		VoteSuggestion other = (VoteSuggestion) obj;
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
		return true;
	}
}
