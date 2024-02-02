package core;

public class Autobus extends Veicolo{
    private int posti;

    public Autobus(TipoVeicolo tipoVeicolo, int kmPercorsi, int posti) {
        super(tipoVeicolo, kmPercorsi);
        this.posti = posti;
    }


    public int getPosti() {
        return posti;
    }

    @Override
    public String toString() {
        return "Autobus [" + super.toString() + " posti: " + posti + "]";
    }

}
