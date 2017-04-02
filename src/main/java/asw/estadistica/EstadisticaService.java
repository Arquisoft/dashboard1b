package asw.estadistica;

import java.util.List;

import asw.DBManagement.model.Comentario;
import asw.DBManagement.model.Estadistica;
import asw.DBManagement.model.Sugerencia;

public interface EstadisticaService {

	public Estadistica nuevaSugerencia(Sugerencia sugerencia);
	
	public List<Estadistica> listaPopularidadSugerencia(List<Sugerencia> sugerencia);
	
	public Estadistica nuevoComentario(Comentario comentario, Estadistica estsdistica);

}
