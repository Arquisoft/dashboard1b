package asw.listeners;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.http.MediaType;
import org.springframework.kafka.annotation.KafkaListener;

import asw.DBManagement.model.Sugerencia;

import javax.annotation.ManagedBean;

/**
 * Created by herminio on 28/12/16.
 */
@ManagedBean
public class NewSugerenceListener implements ApplicationEventPublisherAware{

    private static final Logger logger = Logger.getLogger(NewSugerenceListener.class);
    
    private ApplicationEventPublisher publisher;

    @KafkaListener(topics = KafkaTopics.NEW_SUGERENCE)
    public void listen(String data) {
    	System.out.println("Escuche!");
    	publisher.publishEvent(data);
    	
        logger.info("New message received: \"" + data + "\"");
    }
    
    

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher eventPublisher) {
		this.publisher = eventPublisher;
		
	}
}
