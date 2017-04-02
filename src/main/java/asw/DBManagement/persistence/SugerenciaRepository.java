package asw.DBManagement.persistence;

import org.springframework.data.repository.CrudRepository;

import asw.DBManagement.model.Ciudadano;
import asw.DBManagement.model.Sugerencia;

public interface SugerenciaRepository extends CrudRepository<Sugerencia, Long> {

}
