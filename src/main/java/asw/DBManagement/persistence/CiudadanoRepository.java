package asw.DBManagement.persistence;

import org.springframework.data.repository.CrudRepository;

import asw.DBManagement.model.Ciudadano;

public interface CiudadanoRepository extends CrudRepository<Ciudadano, Long> {

	Ciudadano findByEmail(String email);
}
