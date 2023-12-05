package es2;

import java.util.Random;

public class Util {

    public static String genRandomAlphaNumID() {
        final int ID_LENGTH = 12;
        final String ALPHA_NUMERIC_SET = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        final int alphaNumericSetLength = ALPHA_NUMERIC_SET.length();

        Random random = new Random();
        StringBuilder idBuilder = new StringBuilder(ID_LENGTH);

        /*
        prendo una posizione a caso all'interno della stringa
        di tutti i caratteri e la appendo all'ID
        */
        for (int i = 0; i < 12; i++) {
            int randomPosition = random.nextInt(alphaNumericSetLength);
            char c = ALPHA_NUMERIC_SET.charAt(randomPosition);
            idBuilder.append(c);
        }

        return idBuilder.toString();
    }

    public static float calculatePercentage(float baseSalary, float percentBonus) {
        return baseSalary + ((baseSalary * percentBonus) / 100);
    }
}