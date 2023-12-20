public class ProdottoInMagazzino extends Prodotto {
    protected String codice;

    public ProdottoInMagazzino(String name, double weight, Certificato certificato, String codice) {
        super(name, weight, certificato);
        this.codice = codice;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }
}