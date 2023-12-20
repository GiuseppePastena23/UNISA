package es1;

public abstract class Prodotto {
    protected Certificato certificato;
    protected String denominazione;
    protected float peso;

    public Prodotto(Certificato certificato, String denominazione, float peso) {
        this.certificato = certificato;
        this.denominazione = denominazione;
        this.peso = peso;
    }

    public Certificato getCertificato() {
        return certificato;
    }

    public void setCertificato(Certificato certificato) {
        this.certificato = certificato;
    }

    public String getDenominazione() {
        return denominazione;
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }


}
