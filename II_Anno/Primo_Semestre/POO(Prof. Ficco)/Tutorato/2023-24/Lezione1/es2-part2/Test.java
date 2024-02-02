package test;
import es2.*;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        // test suite per Manager.java
        /*
        Manager m = new Manager();
        Indeterminato indeterminato = new Indeterminato(1, "Mario", "Rossi", 2500, "esperto");
        Determinato determinato = new Determinato(2, "Luigi", "Verdi", 1500, new Date());
        Stagista stagista = new Stagista(3, "Giovanni", "Bianchi", 600, indeterminato);

        m.add(indeterminato);
        m.add(determinato);
        m.add(stagista);

        m.saveLavoratoriBinary("lavoratori.bin");
        m.saveLavoratori("lavoratori.txt");
        m.clear();
        m.readLavoratori("lavoratori.bin");
        m.showDipendenti();

         */

        for (int i = 0; i < 100; i++) {
            System.out.println(Util.genRandomAlphaNumID());
        }
    }
}
