package es1;

public class Imballaggio {
    protected float dimensione;
    protected float peso;

    public Imballaggio(float dimensione, float peso) {
        this.dimensione = dimensione;
        this.peso = peso;
    }

    public float getDimensione() {
        return dimensione;
    }

    public void setDimensione(float dimensione) {
        this.dimensione = dimensione;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }


}
