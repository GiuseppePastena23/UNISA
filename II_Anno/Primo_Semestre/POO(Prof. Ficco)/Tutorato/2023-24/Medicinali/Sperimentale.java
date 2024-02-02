import java.util.GregorianCalendar;

public class Sperimentale extends Medicinale {
    private StatoSperimentazione stato;
    private int nGiorniSperimentazione;

    public Sperimentale(String nome, String azienda, GregorianCalendar dataScadenza, int unitaDisp, StatoSperimentazione stato, int nGiorniSperimentazione) {
        super(nome, azienda, dataScadenza, unitaDisp);
        this.stato = stato;
        this.nGiorniSperimentazione = nGiorniSperimentazione;
    }

    public StatoSperimentazione getStato() {
        return stato;
    }

    public void setStato(StatoSperimentazione stato) {
        this.stato = stato;
    }

    public int getnGiorniSperimentazione() {
        return nGiorniSperimentazione;
    }

    public void setnGiorniSperimentazione(int nGiorniSperimentazione) {
        this.nGiorniSperimentazione = nGiorniSperimentazione;
    }

    @Override
    public String toString() {
        return "Sperimentale{" +
                super.toString() +
                "stato=" + stato +
                ", nGiorniSperimentazione=" + nGiorniSperimentazione +
                '}';
    }
}
