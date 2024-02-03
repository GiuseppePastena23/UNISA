public abstract class Lavoratore {
    protected String nome;
    protected String cognome;
    protected String CF;
    protected Sesso sesso;
    protected int eta;
    protected double stipendio;

    public Lavoratore(String nome, String cognome, String CF, Sesso sesso, int eta, double stipendio){
        this.nome = nome;
        this.cognome = cognome;
        this.CF = CF;
        this.sesso = sesso;
        this.eta = eta;
        this.stipendio = stipendio;
    }

    public double getStipendio() {
        return stipendio;
    }

    public int getEta() {
        return eta;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public String getCF() {
        return CF;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object obj){
        Lavoratore l  = (Lavoratore) obj;
        return this.getCF().equals(l.getCF());
    }
}
