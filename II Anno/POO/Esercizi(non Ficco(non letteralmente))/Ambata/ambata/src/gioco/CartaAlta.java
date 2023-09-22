package gioco;

import java.util.ArrayList;
import java.util.Random;

public class CartaAlta extends Biglietto {
    public int numBiglietto;
    private int A,B,C,D;
    
    public CartaAlta() {
        super.setCostoBiglietto(10);
        super.setMoltiplicatoreVincita(5);
        super.setVincente(false);
    }

    public Integer getA(){
        return this.A;
    }
    public void setA(Integer value){
        this.A = value;
    }
    public Integer getB(){
        return this.B;
    }
    public void setB(Integer value){
        this.B = value;
    }
    public Integer getC(){
        return this.C;
    }
    public void setC(Integer value){
        this.C = value;
    }
    public Integer getD(){
        return this.D;
    }
    public void setD(Integer value){
        this.D = value;
    }

    @Override
    public boolean gioca() {
        super.setVincente(false);
        Random rnd = new Random();
        //Banco
        setA(rnd.nextInt(10) + 1); setB(rnd.nextInt(10) + 1);
        //Giocatore
        setC(rnd.nextInt(10) + 1); setD(rnd.nextInt(10) + 1);
        if((getC() > getA()) && (getD() > getB()))
            super.setVincente(true);
        return super.getVincente();
    }

    @Override
    /***
     * Ritorna il costo del biglietto moltiplicato per
     *  Se Vincente: per il moltiplicatore di vincita
     *  Se Perdente: per 0, quindi sarà 0 il valore di ritorno;
     */
    public Integer dammiVincita() {
        return super.getCostoBiglietto() * (super.getVincente() ? super.getMoltiplicatoreVincita() : 0);
    }

    @Override
    public String toString() {
        String output = String.format("~ Biglietto Carta Alta ~\nCarte Giocatore\t[%d] [%d]:\nCarte Banco\t[%d] [%d]\n", this.C, this.D, this.A, this.B);
        output += super.getVincente() ? "Biglietto Vincente!\n" : "Hai perso, ritenta!\n";
        
        return output;
    }
    
}
