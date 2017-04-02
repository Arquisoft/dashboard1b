package hello.listeners;

import javax.annotation.ManagedBean;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.kafka.annotation.KafkaListener;

@ManagedBean
public class DeleteInappropiateSugerenceListener implements ApplicationEventPublisherAware{

private static final Logger logger = Logger.getLogger(NewSugerenceListener.class);
    
    private ApplicationEventPublisher publisher;

    @KafkaListener(id="deleteSugerence", topics = KafkaTopics.DELETE_SUGERENCE)
    public void listen(String data) {
    	
    	publisher.publishEvent(data);
    	
        logger.info("New message received: \"" + data + "\"");
    }
    

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher eventPublisher) {
		this.publisher = eventPublisher;
		
	}

}