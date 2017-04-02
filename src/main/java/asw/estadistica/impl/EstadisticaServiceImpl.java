package asw.estadistica.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import asw.DBManagement.model.Estadistica;
import asw.DBManagement.model.Sugerencia;
import asw.estadistica.EstadisticaService;

@Service("estadisticaService")
public class EstadisticaServiceImpl implements EstadisticaService {

	@Override
	public Estadistica popularidadSugerencia(Sugerencia sugerencia) {
		List<String> campos = new ArrayList<>();
		
		List<Double> valores = new ArrayList<>();

		
		
		//campos.add("Comentarios");
		//valores.add(sugerencia.getNumeroComentarios()*1.0);
		

		campos.add("Apoyos");
		valores.add(sugerencia.getVotos()*1.0);

		campos.add("Repulsas");
		//valores.add(sugerencia.getNumeroContra()*1.0);
		
		return new Estadistica("Popularidad de "+sugerencia.getTitulo(),campos, valores);

	}

	@Override
	public List<Estadistica> listaPopularidadSugerencia(List<Sugerencia> sugerencia) {
		
		List<Estadistica> devuelto = new ArrayList<Estadistica>();
		
		for(Sugerencia su : sugerencia)
		{
			devuelto.add(this.popularidadSugerencia(su));
		}
		
		return devuelto;
	}

}
