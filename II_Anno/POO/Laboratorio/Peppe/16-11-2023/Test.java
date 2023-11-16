import Fantasy.*;
import java.util.Random;



public class Test{
    public static void main(String[] args) {
        Random rand = new Random();
        Personaggio[] pg = new Personaggio[10];
        for (int i = 0; i < pg.length; i++) {
            int value = rand.nextInt(2);
            if(value == 0)
                pg[i] = (new Cavaliere(rand.nextInt(100), new Posizione(rand.nextInt(100), rand.nextInt(100))));
            else if(value == 1)
                pg[i] = (new Orco(rand.nextInt(100), new Posizione(rand.nextInt(100), rand.nextInt(100))));
        }
        for (int j = 0; j < pg.length; j++)
        {
            System.out.println(pg[j].getId() + " " + pg[j].getType() + " " + pg[j].getEnergy() + " " + pg[j].posizione().x + " " + pg[j].posizione().y);
        }
    }
}