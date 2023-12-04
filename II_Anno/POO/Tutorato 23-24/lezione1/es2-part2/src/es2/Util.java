package es2;
import java.util.Random;

public class Util {
    // public static float percent(float n, float per);

    public static String genRandomAlphaNumID() {
        Random random = new Random();
        StringBuilder str = new StringBuilder(12);
        char c;
        for (int i = 0; i < 12; i++) {
            do {
                c = (char) (random.nextInt(123));
            } while (!Character.isAlphabetic(c) && !Character.isDigit(c));
            str.append(c);
        }
        return str.toString();
  }
}
