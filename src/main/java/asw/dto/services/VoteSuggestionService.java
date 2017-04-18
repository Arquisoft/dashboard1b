package asw.services;

import java.util.List;

import asw.model.CitizenDB;
import asw.model.Suggestion;
import asw.model.VoteSuggestion;
import asw.model.key.VoteSuggestionKey;

public interface VoteSuggestionService {

	List<VoteSuggestion> findBySuggestion (Suggestion suggestion);
	List<VoteSuggestion> findByCitizenDB(CitizenDB citizen);
	VoteSuggestion findByVoteCommentKey(VoteSuggestionKey voteSuggestionKey);
	
	VoteSuggestion createVoteSuggestion(VoteSuggestion voteSuggestion);
	void deleteVoteSuggestion (VoteSuggestion voteSuggestion);
}
