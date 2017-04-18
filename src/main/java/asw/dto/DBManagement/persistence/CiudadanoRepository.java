package asw.dto.DBManagement.persistence;

import org.springframework.data.repository.CrudRepository;

import asw.dto.DBManagement.model.Ciudadano;

public interface CiudadanoRepository extends CrudRepository<Ciudadano, Long> {

	Ciudadano findByEmail(String email);
}
