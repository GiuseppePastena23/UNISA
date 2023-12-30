

public class MonetaDaCollezione extends MonetaConiata{
    protected Certificato certificato;
    protected int valutazione;

    public MonetaDaCollezione(int annoDiConio, Ente ente, Certificato certificato, int valutazione){
        super(valutazione, annoDiConio, ente);
        this.certificato = certificato;
        this.valutazione = valutazione;
    }

    public Certificato getCertificato(){
        return this.certificato;
    }

    public int getValutazione(){
        return this.valutazione;
    }

    public void setValutazione(int valutazione){
        this.valutazione = valutazione;
    }

    public void setCertificato(Certificato certificato){
        this.certificato = certificato;
    }
}