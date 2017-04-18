package asw.participants.acceso;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter.SseEventBuilder;

import asw.dto.DBManagement.model.Ciudadano;
import asw.dto.DBManagement.model.Comentario;
import asw.dto.DBManagement.model.Estadistica;
import asw.dto.DBManagement.model.Sugerencia;
import asw.dto.DBManagement.persistence.CiudadanoRepository;
import asw.dto.DBManagement.persistence.SugerenciaRepository;
import asw.estadistica.EstadisticaService;
import asw.listeners.MessageListener.UpvoteEvent;

@Controller
public class ControladorHTML {

	 private List<SseEmitter> sseEmitters = Collections.synchronizedList(new ArrayList<>()); 

	
	@Autowired
	private CiudadanoRepository repositorio;
	
	@Autowired
	private SugerenciaRepository sugRepos;
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHTML(Model modelo){
		return "login";
	}


	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String postHTML(@RequestBody String parametros, Model modelo){
		//parametros = email=nombre&password=contraseña
		String[] p = parametros.split("&");

		//Usuario en blanco
		if(p[0].length() <= 8){
			modelo.addAttribute("error", "Usuario en blanco.");
			return "error";
		}

		//Contraseña en blanco
		if(p[1].length() <= 9){
			modelo.addAttribute("error", "Contraseña en blanco.");
			return "error";
		}

		String email = p[0].split("=")[1];
		email = email.replace("%40", "@");
		String password = p[1].split("=")[1];

		//Comprobar los datos

		try{
			Ciudadano ciudadano = repositorio.findByEmail(email);
			if (ciudadano!= null)
			{
				if(!ciudadano.getEmail().equals(email))
				{
					modelo.addAttribute("error", "Email no coincide.");
					return "error";
				}

				if(!ciudadano.getPassword().equals(password))
				{
					modelo.addAttribute("error", "La contraseña no coincide con la del usuario.");
					return "error";
				}

				if(ciudadano != null){
					if(ciudadano.isPrivilegios())
						return this.popularidadSugerencia(parametros, modelo);
					else
						return "user";
				}
			}

			modelo.addAttribute("error", "Usuario no registrado.");
			return "error";

		}catch(Exception e){
			modelo.addAttribute("error", "Ha ocurrido en error al conseguir los datos del usuario.");
			return "error";

		}
	}

	@Autowired
	private EstadisticaService estatService;
	


	public List<Estadistica> popularidadSugerencia(List<Sugerencia> sugerencia) {
		return estatService.listaPopularidadSugerencia(sugerencia);
	}


	@RequestMapping(path="/userPriv", method=RequestMethod.GET)
	public String popularidadSugerencia(@RequestBody String parametros, Model modelo) {
		List<Sugerencia> sugerencias = (List<Sugerencia>) sugRepos.findAll();
		List<Estadistica> estadisticas = estatService.listaPopularidadSugerencia(sugerencias);
		modelo.addAttribute("estadisticas",estadisticas);
		return "userPriv";
	}
	
	@RequestMapping( value = "/newSugerence")
	@EventListener
	public void newSugerence(Sugerencia data){
		
		System.out.println("Evento escuchado!");
		SseEventBuilder newSugerenceEvent = SseEmitter.event().name("evento").data("{ \"tipo\": \"newSugerence\" , \"title\":\"" + data.getTitulo() + "\"}");
		sendEvent(newSugerenceEvent);
	}
	
	@RequestMapping( value = "/newComentary")
	@EventListener
	public void newComentary(Comentario data){


		SseEventBuilder newComentaryEvent = SseEmitter.event().name("evento").data("{ \"tipo\": \"newComentary\" ,  \"title\":\"" + data.getSugerencia().getTitulo() +"\" }");
		sendEvent(newComentaryEvent);
	}
	
	@RequestMapping( value = "/upvoteSugerence")
	@EventListener
	public void upvoteSugerence(UpvoteEvent data){
		SseEventBuilder upvoteSugerenceEvent = SseEmitter.event().name("evento").data("{ \"tipo\": \"upvote\" , \"title\":\"" + data.getTitulo() + "\" , \"votes\": \""+ (data.getVotos()+1)+ "\" }");
		sendEvent(upvoteSugerenceEvent);
	}
	
	private void sendEvent(SseEventBuilder event){
		synchronized (sseEmitters) {
			for(SseEmitter emitter: sseEmitters){
				try {
					System.out.println("Enviando el evento");
					emitter.send(event);
				} catch (IOException e) {
					e.printStackTrace();
					
				}
			}
		}
	}
	
	@RequestMapping("/userPriv/updates")
	SseEmitter updateHTML() {
		SseEmitter sseEmitter = new SseEmitter();
		synchronized (this.sseEmitters) {
			this.sseEmitters.add(sseEmitter);
			sseEmitter.onCompletion(() -> {
				synchronized (this.sseEmitters) {
					this.sseEmitters.remove(sseEmitter);
				}
			});
		}
		return sseEmitter;
	}
	
}
