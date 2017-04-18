package asw.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import asw.model.CitizenDB;
import asw.model.Comment;
import asw.model.VoteComment;
import asw.model.key.VoteCommentKey;

public interface VoteCommentRepository extends CrudRepository<VoteComment, Long>{

	List<VoteComment> findByComment(Comment comment);

	List<VoteComment> findByCitizenDB(CitizenDB citizen);

	VoteComment findByVoteCommentKey(VoteCommentKey voteCommentKey);

}
