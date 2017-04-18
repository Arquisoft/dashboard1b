package asw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import asw.model.CitizenDB;
import asw.model.Suggestion;

@Repository("suggestionRepository")
public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {

	List<Suggestion> findByCitizenDB(CitizenDB citizenDB);
	List<Suggestion> findAll();
	
	Suggestion findByTitle(String title);

}
