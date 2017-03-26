package DBManagement.persistence;

import org.springframework.data.repository.CrudRepository;

import DBManagement.model.Ciudadano;

public interface CiudadanoRepository extends CrudRepository<Ciudadano, Long> {

	Ciudadano findByEmail(String email);
}
