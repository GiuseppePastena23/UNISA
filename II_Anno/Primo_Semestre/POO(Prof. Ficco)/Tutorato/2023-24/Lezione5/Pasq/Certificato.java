package es1;

public class Certificato {
    private final Ente certificatore;
    private final String descrizione;

    public Certificato(Ente certificatore, String descrizione) {
        this.certificatore = certificatore;
        this.descrizione = descrizione;
    }

    public Ente getCertificatore() {
        return certificatore;
    }

    public String getDescrizione() {
        return descrizione;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        try {
             return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }
}
