public class Certificato{
    protected Ente enteCertificatore;
    protected int codice;
    protected String descrizione;

    public Certificato(Ente ente, int codice, String description)
    {
        this.enteCertificatore = ente;
        this.descrizione = description;
        this.codice = codice;
    }

    public Ente getEnte(){
        return this.enteCertificatore;
    }

    public String getDescrizione(){
        return this.descrizione;
    }
}