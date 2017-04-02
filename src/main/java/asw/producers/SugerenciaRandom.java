package asw.producers;

import asw.DBManagement.model.Sugerencia;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Alex on 2017-04-02.
 */
public class SugerenciaRandom {
    final java.util.Random rand = new java.util.Random();
    final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";
    final Set<String> identifiers = new HashSet<String>();

    protected Sugerencia newSugerencia() {
        return new Sugerencia(randomString(),randomDate(),randomBool(),randomNumber(0,1000));
    }

    private boolean randomBool() {
        return Math.random() < 0.5;
    }

    private Date randomDate() {
        Random r =new Random();
        long unixtime=(long) (1293861599+r.nextDouble()*60*60*24*365);
        return new Date(unixtime);
    }


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

    private int randomNumber(int min,int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
