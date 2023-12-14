import game.scripts.Cavaliere;
import game.scripts.Orco;
import game.scripts.Personaggio;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Personaggio> personaggi = new ArrayList<>();
        personaggi.add(new Cavaliere(0, 0));
        personaggi.add(new Orco(0, 1));

        Orco orc = (Orco) personaggi.get(1);
        orc.colpisci(personaggi.get(0));

        System.out.println(personaggi.get(0));
        System.out.println(personaggi.get(1));
    }
}
