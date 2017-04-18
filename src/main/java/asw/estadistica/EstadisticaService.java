package asw.estadistica;

import java.util.List;

import asw.dto.DBManagement.model.Comentario;
import asw.dto.DBManagement.model.Estadistica;
import asw.dto.DBManagement.model.Sugerencia;



public interface EstadisticaService {

	public Estadistica nuevaSugerencia(Sugerencia sugerencia);
	
	public List<Estadistica> listaPopularidadSugerencia(List<Sugerencia> sugerencia);
	
	public Estadistica nuevoComentario(Comentario comentario, Estadistica estsdistica);

}
