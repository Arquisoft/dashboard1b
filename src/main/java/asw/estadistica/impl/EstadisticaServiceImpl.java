package asw.estadistica.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import asw.dto.DBManagement.model.Comentario;
import asw.dto.DBManagement.model.Estadistica;
import asw.dto.DBManagement.model.Sugerencia;
import asw.estadistica.EstadisticaService;

@Service("estadisticaService")
public class EstadisticaServiceImpl implements EstadisticaService {

	@Override
	public Estadistica nuevaSugerencia(Sugerencia sugerencia) {
		Map<String, Integer> campos = new HashMap<>();
		
		campos.put("Comentarios",0);
		campos.put("Apoyos",sugerencia.getVotos()*1);
		
		return new Estadistica(sugerencia.getTitulo(),campos);

	}
	
	
	

	@Override
	public List<Estadistica> listaPopularidadSugerencia(List<Sugerencia> sugerencia) {
		
		List<Estadistica> devuelto = new ArrayList<Estadistica>();
		
		for(Sugerencia su : sugerencia)
		{
			devuelto.add(this.nuevaSugerencia(su));
		}
		
		return devuelto;
	}




	@Override
	public Estadistica nuevoComentario(Comentario comentario, Estadistica estadistica) {
		
		estadistica.getCampos().put("Comentarios", estadistica.getCampos().get("Comentarios")+1);
		
		return estadistica;
	}

}
