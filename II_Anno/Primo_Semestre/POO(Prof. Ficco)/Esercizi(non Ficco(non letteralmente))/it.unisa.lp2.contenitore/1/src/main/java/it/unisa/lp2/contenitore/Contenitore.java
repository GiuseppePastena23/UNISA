package it.unisa.lp2.contenitore;

public class Contenitore {
    String nome;
    int codice;
    double prezzo;
    int capienza;

    public Contenitore(String nome, int codice, double prezzo, int capienza) {
        this.nome = nome;
        this.codice = codice;
        this.prezzo = prezzo;
        this.capienza = capienza;
    }

    @Override
    public boolean equals(Object o) {
        // Se e' lo stesso oggetto ritorna true
        if (o == this) {
            return true;
        }
        /*
         * Se e' un istanza di Contenitore o non "null instanceof [type]" returns false
         */
        if (!(o instanceof Contenitore)) {
            return false;
        }
        // typecast a Contenitore in modo da poter comparare gli id
        Contenitore c = (Contenitore) o;
        return codice == c.codice;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Contenitore clone;
        try {
            clone = (Contenitore) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error();
        }
        clone.codice = codice;
        clone.capienza = capienza;
        clone.nome = nome;
        clone.prezzo = prezzo;
        return clone;
    }

    @Override
    public String toString() {
        return String.format("Codice: %d Nome: %s Prezzo: %.2f Capienza: %d" , codice, nome, prezzo, capienza)
    }

    

}
