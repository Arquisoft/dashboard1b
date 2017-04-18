package asw.services;

import java.util.List;

import asw.model.CitizenDB;
import asw.model.Comment;
import asw.model.VoteComment;
import asw.model.key.VoteCommentKey;


public interface VoteCommentService {

	List<VoteComment> findByComment (Comment comment);
	List<VoteComment> findByCitizenDB(CitizenDB citizen);
	VoteComment findByVoteCommentKey(VoteCommentKey voteCommentKey);
	
	VoteComment createVoteComment (VoteComment voteComment);
	void deleteVoteComment (VoteComment voteComment);
}
