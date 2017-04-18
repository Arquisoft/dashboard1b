package asw.model;

import java.util.Set;

public class Association {
	public static class Comentar {
		
		public static void link(CitizenDB citizenDB, Suggestion suggestion, Comment comment) {
			comment._setCitizenDB(citizenDB);
			comment._setSuggestion(suggestion);
			
			citizenDB._getComments().add(comment);
			suggestion._getComments().add(comment);
		}

		public static void unlink(CitizenDB citizenDB, Suggestion suggestion, Comment comment) {
			citizenDB._getComments().remove(comment);
			suggestion._getComments().remove(comment);
			
			comment._setCitizenDB(null);
			comment._setSuggestion(null);
		}
	}
	
public static class votarComentario {
		
		public static void link(CitizenDB citizenDB, Comment comment ,VoteComment voteComment) {
			voteComment._setCitizenDB(citizenDB);
			voteComment._setComment(comment);
			
			citizenDB._getVotesComments().add(voteComment);
			comment._getVoteComments().add(voteComment);
		}

		public static void unlink(CitizenDB citizenDB, Comment comment ,VoteComment voteComment) {
			citizenDB._getVotesComments().remove(voteComment);
			comment._getVoteComments().remove(voteComment);
			
			voteComment._setCitizenDB(null);
			voteComment._setComment(null);
		}
	}

public static class votarSugerencia {
	
	public static void link(CitizenDB citizenDB, Suggestion suggestion ,VoteSuggestion voteSuggestion) {
		voteSuggestion._setCitizenDB(citizenDB);
		voteSuggestion._setSuggestion(suggestion);
		
		citizenDB._getVotesSugerencias().add(voteSuggestion);
		suggestion._getVoteSuggestions().add(voteSuggestion);
	}

	public static void unlink(CitizenDB citizenDB, Suggestion suggestion ,VoteSuggestion voteSuggestion) {
		citizenDB._getVotesSugerencias().remove(voteSuggestion);
		suggestion._getVoteSuggestions().remove(voteSuggestion);
		
		voteSuggestion._setCitizenDB(null);
		voteSuggestion._setSuggestion(null);
	}
}

public static class Sugerir {
	
	public static void link(CitizenDB citizenDB, Suggestion suggestion) {
		suggestion._setCitizenDB(citizenDB);
		
		Set<Suggestion> lista = citizenDB._getSugerencias();
		lista.add(suggestion);
;
	}

	public static void unlink(CitizenDB citizenDB, Suggestion suggestion ) {
		citizenDB._getSugerencias().remove(suggestion);
		
		
		suggestion._setCitizenDB(null);
	}
}
}
