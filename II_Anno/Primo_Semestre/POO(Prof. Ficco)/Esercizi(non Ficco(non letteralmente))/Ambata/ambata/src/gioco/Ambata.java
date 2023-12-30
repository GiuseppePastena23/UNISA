package gioco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Ambata extends Biglietto {
    public int numeroBiglietto;
    ArrayList<Integer> numeriEstraibili;
    ArrayList<Integer> numeriEstratti;

    public Ambata() {
        super.setCostoBiglietto(10);
        super.setMoltiplicatoreVincita(10);
        super.setVincente(false);
        numeriEstraibili = new ArrayList<Integer>();
        this.numeroBiglietto = new Random().nextInt(45) + 1;
        for (int i = 1; i <= 45; i++) { numeriEstraibili.add(i); }
    }
    
    /***
     * Gioca il biglietto attuale di ambata.
     * @return ritorna vero se il biglietto e' vincente, falso altrimenti;
     */
    @Override
    public boolean gioca() {
        super.setVincente(false);
        numeriEstratti = new ArrayList<Integer>();
        Collections.shuffle(numeriEstraibili);
        for (int i = 0; i < 10; i++) {
            numeriEstratti.add(numeriEstraibili.get(i));
            if(numeriEstratti.get(i) == numeroBiglietto)
                super.setVincente(true);
        }
        return super.getVincente();
    }

    @Override
    public Integer dammiVincita() {
        if(super.getVincente())
            return super.getCostoBiglietto() * super.getMoltiplicatoreVincita();
        return 0;
    }

    @Override
    public String toString() {
        String output = String.format("~ Biglietto Ambata ~\n Numero Fortunato: [%d] - Numeri Estratti:\n", this.numeroBiglietto);
        for (int i = 0; i < numeriEstratti.size(); i++) {
            output += String.format("[%d]\t", numeriEstratti.get(i));
        }
        output += "\n";
        output += super.getVincente() ? "Biglietto Vincente!\n" : "Hai perso, ritenta!\n";
        return output;
    }
    
}
