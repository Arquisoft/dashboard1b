package asw.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import asw.model.CitizenDB;


@Repository
public interface CitizenDBRepository extends CrudRepository<CitizenDB, Long>{
	CitizenDB findByEmail(String email);
	CitizenDB findByLogin(String login);
}
