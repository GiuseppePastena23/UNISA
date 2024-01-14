import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Combattimento c = new Combattimento();

        Random random = new Random();
        int tipo = 0;
        for(int i = 0; i < 20; i++){
            tipo = random.nextInt(1,4);
            switch (tipo) {
                case 1:
                    c.aggiungiMostro(new MostroDiFuoco(random.nextInt(0,40), random.nextInt(10, 41), random.nextInt(1, 10)));
                    break;
                case 2:
                    c.aggiungiMostro(new MostroDiAcqua(random.nextInt(0,40), random.nextInt(10, 41), random.nextInt(1, 10)));
                    break;
                case 3:
                    c.aggiungiMostro(new MostroDiPietra(random.nextInt(0,40), random.nextInt(40, 51), random.nextInt(1, 10)));
                    break;
            }
        }

        System.out.println(c.toString());

        for(int i = 0; i < 5000; i++){
            c.combatti(random.nextInt(0,20), random.nextInt(0, 20));
        }

        System.out.println(c.rimuovi());
        


        System.out.println(c.toString());


    }
}
