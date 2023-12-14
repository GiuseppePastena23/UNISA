package tester;

import java.util.Random;

import spedizione.Cliente;
import spedizione.DestInternazionali;
import spedizione.DestNazionali;
import spedizione.Spedizione;
import spedizione.SpedizioneInternazionale;
import spedizione.SpedizioneNazionale;

public class SpedizioneTest {
    public static void main(String[] args) {
        Random rnd = new Random();
        Cliente cliente = new Cliente("RSSMRA75A01F205A", 1000);
        System.out.println(cliente.toString());
        for (int i = 0; i < 10; i++) {
            Spedizione spedizione;
            if(rnd.nextInt(2) == 0){
                spedizione = new SpedizioneNazionale(
                            DestNazionali.values()[rnd.nextInt(DestNazionali.values().length)],
                            DestNazionali.values()[rnd.nextInt(DestNazionali.values().length)]
                        );
            } else {
                spedizione = new SpedizioneInternazionale(  
                            DestInternazionali.values()[rnd.nextInt(DestInternazionali.values().length)],
                            DestInternazionali.values()[rnd.nextInt(DestInternazionali.values().length)]
                        );
            }
            cliente.spedisci(spedizione);
            System.out.println(spedizione);

        }
        System.out.println(cliente.toString());
    }
}