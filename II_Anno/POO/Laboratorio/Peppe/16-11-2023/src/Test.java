import Fantasy.*;
import java.util.Random;



public class Test{
    public static void main(String[] args) {
        Random pgs = new Random(1);
        Random rand = new Random();
        Personaggio[] pg = new Personaggio[10];
        for (int i = 0; i < pg.length; i++) {
            if(pgs.nextInt(1) == 0)
                pg[i] = (new Cavaliere("Cavaliere" + i, rand.nextInt(100), new Posizione(rand.nextInt(100), rand.nextInt(100))));
            else if(pgs.nextInt(1) == 1)
                pg[i] = (new Orco("Orco" + i, rand.nextInt(100), new Posizione(rand.nextInt(100), rand.nextInt(100))));
        }
        for (int j = 0; i < pg.length; j++)
        {
            System.out.println(pg[j].getId() + " " + pg[j].getType() + " " + pg[j].getEnergy() + " " + pg[j].getPos().x + " " + pg[j].getPos().y);
        }
    }
}