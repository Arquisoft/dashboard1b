package hello.listeners;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.kafka.annotation.KafkaListener;

import asw.DBManagement.model.Sugerencia;

import javax.annotation.ManagedBean;

/**
 * Created by herminio on 28/12/16.
 */
@ManagedBean
public class NewSugestionListener implements ApplicationEventPublisherAware{

    private static final Logger logger = Logger.getLogger(NewSugestionListener.class);
    
    private ApplicationEventPublisher publisher;

    @KafkaListener(id= "newSugestion", topics = "newSugestion")
    public void listen(Sugerencia data) {
    	
    	publisher.publishEvent(data);
    	
        logger.info("New message received: \"" + data + "\"");
    }
    

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher eventPublisher) {
		this.publisher = eventPublisher;
		
	}
}
