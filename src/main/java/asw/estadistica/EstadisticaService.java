package asw.estadistica;

import java.util.List;

import asw.DBManagement.model.Estadistica;
import asw.DBManagement.model.Sugerencia;

public interface EstadisticaService {

	public Estadistica popularidadSugerencia(Sugerencia sugerencia);
	
	public List<Estadistica> listaPopularidadSugerencia(List<Sugerencia> sugerencia);

}
