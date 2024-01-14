public class Certificato{
    protected Ente enteCertificatore;
    protected String description;

    public Certificato(Ente ente, String description)
    {
        this.enteCertificatore = ente;
        this.description = description;
    }

    public Ente getEnte(){
        return this.enteCertificatore;
    }

    public String getDescription(){
        return this.description;
    }
}