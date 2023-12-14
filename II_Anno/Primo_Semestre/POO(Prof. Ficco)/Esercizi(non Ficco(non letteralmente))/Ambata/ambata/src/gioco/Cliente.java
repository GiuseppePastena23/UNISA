package gioco;

import java.util.ArrayList;

public class Cliente {
    private String cf;
    private String nome;
    private String cognome;
    private Integer saldo;
    private ArrayList<Biglietto> biglietti;
    private ArrayList<Biglietto> bigliettiGiocati;

    public Cliente(String cf, String nome, String cognome, Integer saldo) {
        this.cf = cf;
        this.nome = nome;
        this.cognome = cognome;
        this.saldo = saldo;
        biglietti = new ArrayList<Biglietto>();
        bigliettiGiocati = new ArrayList<Biglietto>();
    }

    public Integer getSaldo() {
        return this.saldo;
    }
    public void setSaldo(Integer value) {
        this.saldo = value;
    }

    /***
     * Acquista dei biglietti del gioco passato in ingresso come nome
     * Se il gioco non esiste ritorna falso, altrimenti ritorna vero;
     * @param gioco
     * @return ritorna se il biglietto e' stato acquistato
     */
    public boolean acquistaBiglietto(Biglietto gioco){
        if(this.getSaldo() >= gioco.getCostoBiglietto()){
            this.setSaldo(this.getSaldo() - gioco.getCostoBiglietto() );
            biglietti.add(gioco);
            return true;
        }
        return false;
    }
    
    /***
     * Gioca l'ultimo biglietto acquistato
     * @return ritorna falso se non c'e' alcun biglietto da giocare
     */
    public boolean giocaUltimoBiglietto(){
        if(this.biglietti.isEmpty())
            return false;
        //Aggiungi il biglietto ai biglietti gia giocati e lo rimuove da quelli da giocare
        this.bigliettiGiocati.add( this.biglietti.get(this.biglietti.size() - 1) );
        Biglietto biglietto = this.biglietti.remove(this.biglietti.size() - 1);
        if(biglietto.gioca()) //Se il biglietto e' vincente
            biglietto.dammiVincita();
        return true;
    }    

    
    @Override
    /***
     * Ritorna il nome, il cognome, il codice fiscale, il saldo
     * e tutti i biglietti giocati
     */
    public String toString() {
        String output = "";
        output += String.format("%s: %s %s CF: %s - Saldo: %d\n", this.getClass().getSimpleName(),
                this.nome, this.cognome, this.cf, this.saldo);
        output += String.format("Biglietti: %d\n", biglietti.size());
        for (int i = 0; i < biglietti.size(); i++) {
            output += biglietti.get(i).toString() + "\n";
        }
        output += String.format("Biglietti giocati: %d\n", bigliettiGiocati.size());
        for (int i = 0; i < bigliettiGiocati.size(); i++) {
            output += bigliettiGiocati.get(i).toString() + "\n";
        }
        return output;
    }
}
