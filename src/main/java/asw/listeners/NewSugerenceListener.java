package asw.listeners;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.http.MediaType;
import org.springframework.kafka.annotation.KafkaListener;

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
public class NewSugerenceListener implements ApplicationEventPublisherAware{
	
	@Autowired
    private ObjectMapper mapper;
  
  @Autowired
  private SugerenciaRepository sugRep;

    private static final Logger logger = Logger.getLogger(NewSugerenceListener.class);
    
    private ApplicationEventPublisher publisher;

    @KafkaListener(topics = KafkaTopics.NEW_SUGERENCE)
    public void listen(String data) {

    	logger.info("New message received: \"" + data + "\"");
//        try {
//			Sugerencia sugerencia = mapper.readValue(data, Sugerencia.class);
//			logger.info("*****************\n"+"Sugerencia: "+sugerencia.getTitulo());
//			sugRep.save(sugerencia);
//			ControladorHTML.getSugerencias().add(sugerencia);
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
    	
    	System.out.println("Escuche!");
    	publisher.publishEvent(data);
    }
    
    

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher eventPublisher) {
		this.publisher = eventPublisher;
		
	}
}
