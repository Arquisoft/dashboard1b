package asw.model.key;

import java.io.Serializable;

public class VoteCommentKey implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Long comment;
	Long citizenDB;

	public VoteCommentKey(Long id, Long id2) {
		this.citizenDB = id2;
		this.comment = id;
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
		VoteCommentKey other = (VoteCommentKey) obj;
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
	
	public Long getComment() {
		return comment;
	}
	
	public void setComment(Long comment) {
		this.comment = comment;
	}
	
	public Long getCitizenDB() {
		return citizenDB;
	}
	
	public void setCitizenDB(Long citizenDB) {
		this.citizenDB = citizenDB;
	}
}
