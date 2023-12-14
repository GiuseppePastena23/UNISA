import java.util.GregorianCalendar;

public class Alimentare extends Prodotto {
    GregorianCalendar scadenza;

    public Alimentare(Long codice, String descrizione, String marca, double prezzo, int grammatura, GregorianCalendar scadenza, int peso) {
        super(codice, descrizione, marca, prezzo, grammatura);
        this.scadenza = scadenza;
    }

    public boolean isScaduto() {
        GregorianCalendar now = new GregorianCalendar();
        if( now.compareTo(scadenza) > 0 )
            return true;
        return false;
    }

    public boolean acquista(int grammi) {
        if (grammi > super.getQuantita()) 
            return false;

        super.setQuantita(super.getQuantita() - grammi);
        return true;
    }

}
