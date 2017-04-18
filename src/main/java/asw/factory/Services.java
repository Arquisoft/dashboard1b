package asw.factory;


import asw.services.CitizenDBService;
import asw.services.CommentsService;
import asw.services.SuggestionService;
import asw.services.VoteCommentService;
import asw.services.VoteSuggestionService;
import asw.services.impl.CitizenDBServiceImpl;
import asw.services.impl.CommentServiceImpl;
import asw.services.impl.SuggestionServiceImpl;
import asw.services.impl.VoteCommentServiceImpl;
import asw.services.impl.VoteSuggestionServiceImpl;

public class Services {
	
	public static CitizenDBService getCitizenDBService(){
		return new CitizenDBServiceImpl();
	}
	
	public static SuggestionService getSuggestionService(){
		return new SuggestionServiceImpl();
	}
	
	public static CommentsService getCommentsService(){
		return new CommentServiceImpl();
	}
	
	public static VoteCommentService getVoteCommentService(){
		return new VoteCommentServiceImpl();
	}
	
	public static VoteSuggestionService getVoteSuggestionService(){
		return new VoteSuggestionServiceImpl();
	}

}
