import java.util.Random;

public class Tester {
    Random random = new Random();

    public static void main(String[] args) {
        Combattimento combattimento = new Combattimento();


    }

    Mostro generaMostro() {
        Mostro m = null;
        String name = randomString();
        int energy = random.nextInt(40, 51);
        int hp = random.nextInt(10, 41);

        switch (random.nextInt(3)) {
            case 0: {
                m = new MostroDiFuoco(name, energy, hp, random.nextInt(1, 20));
                break;
            }
            case 1: {
                m = new MostroDiAcqua(name, energy, hp, random.nextInt(1, 20));
                break;
            }
            case 2: {
                m = new MostroDiPietra(name, energy, hp, random.nextInt(1, 20));
                break;
            }
        }

        return m;
    }

    String randomString() {
        final int size = 10;
        String charset = "1234567890qwertyuiopasdfghjklzxcvbnm";
        int charsetSize = charset.length();
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < size; i++) {
            string.append(charset.charAt(random.nextInt(charsetSize)));
        }
        return string.toString();
    }
}
