package asw.listeners;

import asw.DBManagement.model.Comentario;
import asw.DBManagement.persistence.ComentarioRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import asw.DBManagement.model.Sugerencia;
import asw.DBManagement.persistence.SugerenciaRepository;
import asw.participants.acceso.ControladorHTML;

import java.io.IOException;

import javax.annotation.ManagedBean;

/**
 * Created by herminio on 28/12/16.
 */
@ManagedBean
public class MessageListener implements ApplicationEventPublisherAware{



    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private SugerenciaRepository sugRep;

    @Autowired
    private ComentarioRepository comRep;

    private static final Logger logger = Logger.getLogger(MessageListener.class);
    private ApplicationEventPublisher publisher;

    @KafkaListener(topics = KafkaTopics.NEW_SUGERENCE)
    public void listenSugerencias(String data) {
    	
    	try {
			Sugerencia sugerencia = mapper.readValue(data, Sugerencia.class);
			logger.info("*****************\n"+"Sugerencia: "+sugerencia.getTitulo());
			sugRep.save(sugerencia);
			ControladorHTML.getSugerencias().add(sugerencia);
			publisher.publishEvent(sugerencia);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

    @KafkaListener( topics = KafkaTopics.NEW_COMENTARY)
    public void listenComentarios(String data) {
    	
    	try {
			Comentario comentario = mapper.readValue(data, Comentario.class);
			logger.info("*****************\n"+"Comentario: "+comentario.getTexto());
			Comentario com =comentario;
//			com.setSugerencia(null);
//			comRep.save(com);
			publisher.publishEvent(comentario);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	
        logger.info("New message received: \"" + data + "\"");
    }
    
    @KafkaListener( topics = KafkaTopics.UPVOTE_SUGERENCE)
    public void listenApoyo(String data) {
    	try {
			Comentario comentario = mapper.readValue(data, Comentario.class);
			logger.info("*****************\n"+"Apoyo: "+comentario.getSugerencia().getTitulo());
			//Sugerencia sug = sugRep.findOne(comentario.getSugerencia().getId());
			//sug.setVotos(sug.getVotos()+1);
			//sugRep.save(sug);
			publisher.publishEvent(comentario.getSugerencia().getTitulo());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        logger.info("New message received: \"" + data + "\"");
    }
    
    
    
    
    @Override
	public void setApplicationEventPublisher(ApplicationEventPublisher eventPublisher) {
		this.publisher = eventPublisher;
		
	}

}
