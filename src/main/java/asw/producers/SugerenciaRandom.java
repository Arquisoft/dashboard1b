package asw.producers;

import asw.DBManagement.model.Sugerencia;

import java.util.*;

/**
 * Created by Alex on 2017-04-02.
 */
public class SugerenciaRandom {
    final java.util.Random rand = new java.util.Random();
    final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";
    final Set<String> identifiers = new HashSet<String>();

    protected Sugerencia newSugerencia() {
        Sugerencia sugerencia = new Sugerencia(randomNumber(0,1000), randomString(), randomDate(), randomBool(), randomNumber(0,1000));
        return sugerencia;
    }

    private boolean randomBool() {
        return Math.random() < 0.5;
    }

    private Date randomDate() {
        int year, dayOfYear;

        GregorianCalendar gc = new GregorianCalendar();
        year = randomNumber(1900, 2010);
        gc.set(gc.YEAR, year);
        dayOfYear = randomNumber(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);

        return gc.getTime();
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
