package core.corsi;


public abstract class Corso{
    private String nome;
    private String docente;
    protected int hFrontali;

    public Corso(String nome, String docente, int hFrontali){
        this.nome = nome;
        this.docente = docente;
    }

    public int calcolaCosto(){
        return hFrontali * 50;
    }

    public int getOre(){
        return hFrontali;
    }

    public abstract int dammiNumeroCFU();

    @Override
    public String toString(){
        return nome + ", " + this.calcolaCosto() + ", " + docente;
    }
}