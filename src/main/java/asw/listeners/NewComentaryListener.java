package asw.listeners;

import java.io.IOException;

import javax.annotation.ManagedBean;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.kafka.annotation.KafkaListener;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import asw.DBManagement.model.Comentario;
import asw.DBManagement.model.Sugerencia;
import asw.DBManagement.persistence.SugerenciaRepository;

@ManagedBean
public class NewComentaryListener implements ApplicationEventPublisherAware{
	
private static final Logger logger = Logger.getLogger(NewSugerenceListener.class);
    
	@Autowired
	private ObjectMapper mapper;
	
	@Autowired
	private SugerenciaRepository sugRep;

    private ApplicationEventPublisher publisher;

    @KafkaListener(topics = KafkaTopics.NEW_COMENTARY)
    public void listen(String data) {
    	
//    	try {
//			Sugerencia sugerencia = mapper.readValue(data, Sugerencia.class);
//			logger.info("*****************\n"+"Sugerencia: "+sugerencia.getTitulo());
//			sugRep.save(sugerencia);
//			
//		} catch (JsonParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	publisher.publishEvent(data);
    	
        logger.info("New message received: \"" + data + "\"");
    }
    

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher eventPublisher) {
		this.publisher = eventPublisher;
		
	}
	
}
