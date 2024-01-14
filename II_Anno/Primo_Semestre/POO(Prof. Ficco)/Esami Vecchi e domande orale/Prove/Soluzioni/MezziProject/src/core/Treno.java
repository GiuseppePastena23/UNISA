package core;

public class Treno extends Veicolo {
    private int minutiRitardo;

    public Treno(TipoVeicolo tipoVeicolo, int kmPercorsi, int minutiRitardo) {
        super(tipoVeicolo, kmPercorsi);
        this.minutiRitardo = minutiRitardo;
    }


    public int getRitardo() {
        return minutiRitardo;
    }

    @Override
    public String toString() {
        return "Treno[" + super.toString() + " minutiRitardo: " + minutiRitardo + "]";
    }
}
