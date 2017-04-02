package asw.DBManagement.persistence;

import org.springframework.data.repository.CrudRepository;

import asw.DBManagement.model.Ciudadano;

public interface ComentarioRepository extends CrudRepository<Ciudadano, Long> {

}
