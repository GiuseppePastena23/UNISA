import java.util.Objects;

public class ProdottoInSpedizione extends Prodotto {
    protected Imballaggio imballaggio;
    protected String destinazione;

    public ProdottoInSpedizione(String name, double weight, Certificato certificato, Imballaggio imballaggio, String destinazione) {
        super(name, weight, certificato);
        this.imballaggio = imballaggio;
        this.destinazione = destinazione;
    }

    // metodi modificatori

    public void setImballaggio(Imballaggio imballaggio) {
        this.imballaggio = imballaggio;
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    // metodi di accesso

    public Imballaggio getImballaggio() {
        return imballaggio;
    }

    public String getDestinazione() {
        return destinazione;
    }

    @Override
    public double getWeight() {
        return super.getWeight() + imballaggio.getPeso();
    }

    @Override
    public String toString() {
        return "ProdottoInSpedizione{" +
                "imballaggio=" + imballaggio +
                ", destinazione='" + destinazione + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProdottoInSpedizione that = (ProdottoInSpedizione) o;

        if (!Objects.equals(imballaggio, that.imballaggio)) return false;
        return Objects.equals(destinazione, that.destinazione);
    }
}

        


