package asw.producers;

import asw.DBManagement.model.Sugerencia;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import javax.annotation.ManagedBean;
import java.math.BigInteger;
import java.security.SecureRandom;

@ManagedBean
@EnableScheduling
public class KafkaProducer {

    private static final Logger logger = Logger.getLogger(KafkaProducer.class);


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private ObjectMapper mapper;

    private Sugerencia sugerencia;
    private SugerenciaRandom sugerenciaRandom;


    @Scheduled(fixedDelay = 15000)
    public void sendNewSuggestion() {
        sugerenciaRandom = new SugerenciaRandom();
        String sugerenciaJSON = "";
        sugerencia = sugerenciaRandom.newSugerencia();
        logger.info(sugerencia);

        try {
            sugerenciaJSON = mapper.writeValueAsString(sugerencia);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        logger.info("Sugerencia:"+ sugerenciaJSON);
        String id = randomID();
        send("test", id);
    }

    private String randomID() {
        return new BigInteger(130, new SecureRandom()).toString(32);
    }

    public void send(String topic, String data) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, data);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                logger.info(result);
                logger.info("Success on sending message \"" + data + "\" to topic " + topic);
            }

            @Override
            public void onFailure(Throwable ex) {
                logger.error("Error on sending message \"" + data + "\", stacktrace " + ex.getMessage());
            }
        });
    }

}