package asw.producers2;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.ManagedBean;

/**
 * Created by herminio on 26/12/16.
 */
@ManagedBean
public class KafkaProducer {

    private static final Logger logger = Logger.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * Metodo funndamental para la informacion en Kafka.
     * @param topic Topico de Kafka.
     * @param data Datos a enviar.
     */
    public void send(String topic, String data) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, data); //Valido por si solo para el manejo de la informacion.
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                logger.info("Success on sending message \"" + data + "\" to topic " + topic);
            }

            @Override
            public void onFailure(Throwable ex) {
                logger.error("Error on sending message \"" + data + "\", stacktrace " + ex.getMessage());
            }
        });
    }

}
