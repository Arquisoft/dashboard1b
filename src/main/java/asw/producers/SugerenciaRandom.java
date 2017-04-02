package asw.producers;

import asw.DBManagement.model.Sugerencia;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Alex on 2017-04-02.
 */
public class SugerenciaRandom {
    final java.util.Random rand = new java.util.Random();
    final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";
    final Set<String> identifiers = new HashSet<String>();

    protected Sugerencia newSugerencia() {
        Sugerencia sugerencia = new Sugerencia(randomString(), randomNumber(), randomNumber(), randomNumber());
        return sugerencia;
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

    private int randomNumber() {
        Random r = new Random();
        int max = 1000;
        int min = 0;
        return r.nextInt((max - min) + 1) + min;
    }

}
