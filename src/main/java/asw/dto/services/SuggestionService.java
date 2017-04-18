package asw.services;

import java.util.List;

import asw.model.CitizenDB;
import asw.model.Suggestion;

public interface SuggestionService {

	List<Suggestion> findByCitizenDB(CitizenDB citizenDB);
	Suggestion findByTitle(String title);
	Suggestion findById(Long id);
	List<Suggestion> findAll();
	
    Suggestion createSuggestion(Suggestion suggestion);
    void deleteSuggestion(Suggestion suggestion);
}
