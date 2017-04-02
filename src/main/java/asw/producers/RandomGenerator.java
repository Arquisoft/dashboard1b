package asw.producers;

import asw.DBManagement.model.Ciudadano;
import asw.DBManagement.model.Sugerencia;
import asw.DBManagement.persistence.CiudadanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Alex on 2017-04-02.
 */
@Component
public class RandomGenerator {

    final java.util.Random rand = new java.util.Random();
    final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";
    final Set<String> identifiers = new HashSet<String>();

    @Autowired
    private CiudadanoRepository crepo;

    /**
     * Generate a random sugerencia
     * @return a random sugerencia
     */
    protected Sugerencia newSugerencia() {
        Sugerencia sugerencia = new Sugerencia(randomString(),randomDate(),randomBool(),randomNumber(0,1000));
        sugerencia._setCiudadano(newCiudadano());
        return sugerencia;
    }

    protected Ciudadano newCiudadano() {
        Long id = new Long(randomNumber(1,4));
        System.out.println("id: "+ id);
        Iterable<Ciudadano> ciudadanoIterable = crepo.findAll();
        System.out.println("ciudadanoIterable:" + ciudadanoIterable);
        Ciudadano ciudadano = crepo.findOne(id);
        System.out.println("ciudadano:" + ciudadano);
        return ciudadano;
    }

    /**
     *  Generate a random boolean
     * @return a boolean
     */
    private boolean randomBool() {
        return Math.random() < 0.5;
    }

    /**
     * Generate a random Date
     * @return a Date
     */
    private Date randomDate() {
        Random r =new Random();
        long unixtime=(long) (1293861599+r.nextDouble()*60*60*24*365);
        return new Date(unixtime);
    }

    /**
     * Generate a random string using lexicon string
     * @return a random String
     */
    private String randomString() {
        StringBuilder builder = new StringBuilder();
        while(builder.toString().length() == 0) {
            int length = rand.nextInt(5)+5;
            for(int i = 0; i < length; i++) {
                builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
            }
            if(identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        return builder.toString();
    }

    /**
     * Generate a random int
     * @param min value
     * @param max value
     * @return a random number between min and max
     */
    private int randomNumber(int min,int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}

