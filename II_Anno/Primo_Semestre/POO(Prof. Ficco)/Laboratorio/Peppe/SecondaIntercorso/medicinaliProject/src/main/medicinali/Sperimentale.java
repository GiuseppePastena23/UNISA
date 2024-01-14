package main.medicinali;

public class Sperimentale extends Medicinale{

    private StatoSperimentazione stato;
    private int giorni;

    public Sperimentale(String name, String azienda, String scadenza, int disponibili, boolean isScaduto, StatoSperimentazione stato, int giorni){
        super(name, azienda, scadenza, disponibili, isScaduto);
        this.stato = stato;
        this.giorni = giorni;
    }

    public StatoSperimentazione getStato(){
        return stato;
    }

        
    @Override
    public String toString() {
        return super.toString() + ", giorni=" + giorni + ", stato=" + stato;
    }
}