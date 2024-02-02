package tester;

import java.util.Random;

import gioco.Cliente;
import gioco.Ambata;
import gioco.CartaAlta;

public class Starter {

    public static void main(String[] args) throws Exception {
        Random rnd = new Random();
        Cliente cliente = new Cliente("RSSMRN54B25H704D","Mario","Rossi", rnd.nextInt(51) + 50);
        System.out.println(cliente.toString());
        for (int i = 0; i < 10; i++) {
            if(rnd.nextInt(2) == 0)
                cliente.acquistaBiglietto(new Ambata());
            else    
                cliente.acquistaBiglietto(new CartaAlta());
        }
        while(cliente.giocaUltimoBiglietto());
        System.out.println(cliente.toString());
    }
}
