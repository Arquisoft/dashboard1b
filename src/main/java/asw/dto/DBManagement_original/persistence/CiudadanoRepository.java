package asw.DBManagement_original.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import asw.DBManagement_original.model.Ciudadano;


public interface CiudadanoRepository extends CrudRepository<Ciudadano, Long> {

	Ciudadano findByEmail(String email);
}
