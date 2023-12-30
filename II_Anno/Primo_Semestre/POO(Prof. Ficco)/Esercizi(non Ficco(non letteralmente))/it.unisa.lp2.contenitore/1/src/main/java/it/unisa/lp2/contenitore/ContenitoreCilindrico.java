package it.unisa.lp2.contenitore;

public class ContenitoreCilindrico extends Contenitore {
    int raggio, altezza;

    public ContenitoreCilindrico(String nome, int codice, double prezzo, int capienza, int raggio, int altezza) {
        super(nome, codice, prezzo, capienza);
        this.raggio = raggio;
        this.altezza = altezza;
    }

    @Override
    public String toString() {
        return String.format("Raggio base %d, Altezza %d", super.toString(), raggio, altezza);
    }

    @Override
    public boolean equals(Object o) {
        // TODO Auto-generated method stub
        return super.equals(o);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ContenitoreCilindrico c;
        try {
            c = (ContenitoreCilindrico) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error();
        }
        c.raggio = raggio;
        c.altezza = altezza;
        return c;
    }

    
}
