package gioco;

public abstract class Biglietto {
    protected Integer costoBiglietto; 
    protected Integer moltiplicatoreVincita;
    protected boolean vincente;

    public Biglietto() {
        costoBiglietto = 10;
        moltiplicatoreVincita = 5;
        vincente = false;
    }

    public Integer getMoltiplicatoreVincita() {
        return this.moltiplicatoreVincita;
    }
    public void setMoltiplicatoreVincita(Integer value) {
        this.moltiplicatoreVincita = value;
    }

    public Integer getCostoBiglietto() {
        return this.costoBiglietto;
    };
    public void setCostoBiglietto(Integer value) {
        this.costoBiglietto = value;
    }

    public void setVincente(boolean value){
        this.vincente = value;
    }
    public boolean getVincente() {
        return this.vincente;
    };

    public abstract boolean gioca();

    public abstract Integer dammiVincita();

    @Override
    public abstract String toString();
}
