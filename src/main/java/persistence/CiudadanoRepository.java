package persistence;

import org.springframework.data.repository.CrudRepository;

import model.Ciudadano;

public interface CiudadanoRepository extends CrudRepository<Ciudadano, Long> {

	Ciudadano findByEmail(String email);
}
