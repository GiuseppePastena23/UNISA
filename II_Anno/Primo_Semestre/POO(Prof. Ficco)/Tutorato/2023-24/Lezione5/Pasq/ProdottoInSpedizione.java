package es1;

import java.util.Objects;

public class ProdottoInSpedizione extends Prodotto {
    Imballaggio imballaggio;
    String destinazione;

    public ProdottoInSpedizione(Certificato certificato, String denominazione, float peso, Imballaggio imballaggio,
                                String destinazione) {

        super(certificato, denominazione, peso);
        this.imballaggio = imballaggio;
        this.destinazione = destinazione;
    }

    @Override
    public float getPeso() {
        return super.getPeso() + imballaggio.getPeso();
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public Imballaggio getImballaggio() {
        return imballaggio;
    }

    public void setImballaggio(Imballaggio imballaggio) {
        this.imballaggio = imballaggio;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProdottoInSpedizione that = (ProdottoInSpedizione) o;

        if (!Objects.equals(imballaggio, that.imballaggio)) return false;
        return Objects.equals(destinazione, that.destinazione);
    }


    

    @Override
    public String toString() {
        return "Prodotto in spedizone {\n" +
                super.toString() + "\n" +
                imballaggio + "\n" +
                "destinazione: " + destinazione + "\n" +
                "}";
    }

}
