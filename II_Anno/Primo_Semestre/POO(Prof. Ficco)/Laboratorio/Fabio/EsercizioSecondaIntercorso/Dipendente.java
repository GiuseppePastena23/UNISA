public class Dipendente extends Lavoratore{
private boolean impiegato;
    public Dipendente(String nome, String cognome, String CF, Sesso sesso, int eta, double stipendio){
        super(nome,cognome,CF,sesso,eta,stipendio);
        this.impiegato = false;
    }

    public void setImpiegato(boolean impiegato) {
        this.impiegato = impiegato;
    }

    public boolean isImpiegato() {
        return impiegato;
    }
}
