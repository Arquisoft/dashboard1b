package asw.services;

import java.util.List;

import asw.model.CitizenDB;
import asw.model.Comment;
import asw.model.Suggestion;

public interface CommentsService {
	
	List<Comment> findBySuggestion(Suggestion suggestion);
	List<Comment> findByCitizenDB(CitizenDB citizenDB);
	List<Comment> findAll();
	Comment fingById(long id);
	Comment createComment(Comment comment);
	void deleteComment(Comment comment);
}
