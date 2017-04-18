package asw.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import asw.model.CitizenDB;
import asw.model.Suggestion;
import asw.model.VoteSuggestion;
import asw.model.key.VoteSuggestionKey;

public interface VoteSuggestionRepository  extends CrudRepository<VoteSuggestion, Long>{

	List<VoteSuggestion> findBySuggestion(Suggestion suggestion);

	List<VoteSuggestion> findByCitizenDB(CitizenDB citizen);

	VoteSuggestion findByVoteCommentKey(VoteSuggestionKey voteSuggestionKey);

}
