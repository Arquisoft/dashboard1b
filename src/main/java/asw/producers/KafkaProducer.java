package asw.producers;

import asw.DBManagement.model.Comentario;
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

@ManagedBean
@EnableScheduling
public class KafkaProducer {

    private static final Logger logger = Logger.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private RandomGenerator randomGenerator;

    private Sugerencia sugerencia;
    private Comentario comentario;


    @Scheduled(fixedDelay = 30000)
    public void sendNewSuggestion() {
        String sugerenciaJSON = "";
        sugerencia = randomGenerator.newSugerencia();

        try {
            sugerenciaJSON = mapper.writeValueAsString(sugerencia);
            send("sugerencias", sugerenciaJSON);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(fixedDelay = 11000)
    public void sendNewComentario() {
        String comentarioJSON = "";
        comentario = randomGenerator.newComentario();

        try {
            comentarioJSON = mapper.writeValueAsString(comentario);
            send("comentarios", comentarioJSON);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    
    @Scheduled(fixedDelay = 7000)
    public void sendNewApoyo() {
        String comentarioJSON = "";
        comentario = randomGenerator.newComentario();
        comentario.setTexto("");

        try {
            comentarioJSON = mapper.writeValueAsString(comentario);
            send("apoyos", comentarioJSON);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
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