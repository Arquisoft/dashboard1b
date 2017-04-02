package asw.DBManagement.persistence;

import asw.DBManagement.model.Comentario;
import org.springframework.data.repository.CrudRepository;

public interface ComentarioRepository extends CrudRepository<Comentario, Long> {

}
