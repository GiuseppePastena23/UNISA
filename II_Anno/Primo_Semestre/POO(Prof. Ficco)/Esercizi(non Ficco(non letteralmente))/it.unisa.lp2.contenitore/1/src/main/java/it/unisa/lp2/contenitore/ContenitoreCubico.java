package it.unisa.lp2.contenitore;

public class ContenitoreCubico extends Contenitore {
    int ampiezza;

    public ContenitoreCubico(String nome, int codice, double prezzo, int capienza, int ampiezza) {
        super(nome, codice, prezzo, capienza);
        this.ampiezza = ampiezza;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ContenitoreCubico c;
        try {
            c = (ContenitoreCubico) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error();
        }
        c.ampiezza = ampiezza;
        return c;
    }

    @Override
    public String toString() {
        return String.format("Ampiezza lato %d" , super.toString(), ampiezza);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    
}
