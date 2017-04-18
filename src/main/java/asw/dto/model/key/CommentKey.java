package asw.dto.model.key;

import java.io.Serializable;

public class CommentKey implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	Long citizenDB;
	Long suggestion;
	
	public CommentKey(Long id, Long id2) {
		this.citizenDB = id2;
		this.suggestion = id;
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
		CommentKey other = (CommentKey) obj;
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
	
	public Long getCitizenDB() {
		return citizenDB;
	}
	public void setCitizenDB(Long citizenDB) {
		this.citizenDB = citizenDB;
	}
	public Long getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(Long suggestion) {
		this.suggestion = suggestion;
	}
}
