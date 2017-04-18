package asw.dto.DBManagement.persistence;

import asw.dto.DBManagement.model.Comentario;
import org.springframework.data.repository.CrudRepository;

public interface ComentarioRepository extends CrudRepository<Comentario, Long> {

}
