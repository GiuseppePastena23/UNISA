

public class MonetaConiata extends Moneta{
    protected final int annoDiConio;
    protected Ente ente;

    public MonetaConiata(int valore, int annoDiConio, Ente ente){
        super(valore);
        this.annoDiConio = annoDiConio;
        this.ente = ente;
    }

    public int getAnnoDiConio(){
        return this.annoDiConio;
    }

    public Ente getEnte(){
        return this.ente;
    }

    public void setEnte(Ente ente){
        this.ente = ente;
    } 
}
