package asw.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import asw.model.CitizenDB;
import asw.model.Comment;
import asw.model.Suggestion;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>{

	List<Comment> fingBySuggestion(Suggestion suggestion);

	List<Comment> findByCitizenDB(CitizenDB citizenDB);

}
