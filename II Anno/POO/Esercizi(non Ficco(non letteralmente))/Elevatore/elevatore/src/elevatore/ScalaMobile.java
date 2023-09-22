package elevatore;

import java.util.GregorianCalendar;

public class ScalaMobile extends Elevatore {
    private boolean inFunzione;
    private int lunghezza;
    private GregorianCalendar orarioAccensione;

    public ScalaMobile(Integer codice, String marca, double prezzoBase, int lunghezza) {
        super(codice, marca, prezzoBase);
        this.lunghezza = lunghezza;
    }

    //Getter & Setter
    public GregorianCalendar getAccensione() {
        return orarioAccensione;
    }
    public void setAccensione(GregorianCalendar orarioAccensione) {
        this.orarioAccensione = orarioAccensione;
    }

    public boolean isInFunzione() {
        return inFunzione;
    }
    public void setInFunzione(boolean inFunzione) {
        if (inFunzione && !isAcceso())
            throw new RuntimeException();
        this.inFunzione = inFunzione;
    }

    public int getLunghezza() {
        return lunghezza;
    }
    public void setLunghezza(int lunghezza) {
        this.lunghezza = lunghezza;
    }

    

    //Methods
    @Override
    public void accendi() {
        super.accendi();
        this.setAccensione(new GregorianCalendar());
        this.setInFunzione(true);
    }

    @Override
    public void spegni() {
        super.spegni();
        this.setInFunzione(false);
        this.orarioAccensione = null;
    }
    
    @Override
    public double getCosto() {
        return super.getPrezzoBase() * this.lunghezza / 10;
    }
    /**
     * Ottiene il tempo di utilizzo se acceso
     * @return ritorna il tempo di utilizzo in minuti
     */
    public long dammiTempo() {
        if(!isAcceso())
            return 0;
        GregorianCalendar now = new GregorianCalendar();
        return ((now.getTimeInMillis() - orarioAccensione.getTimeInMillis()) / 1000 / 60); //diviso 1000>secondi, diviso 60>minuti
    }
    
    @Override
    public String toString() {
        return String.format("%s In Funzione: %s, Lunghezza: %d, TempoUtilizzo: %dsecondi\n", super.toString(),
                this.isInFunzione() ? "SI" : "NO", this.getLunghezza(), this.dammiTempo()/1000);
    }
    
}
