package core;

public abstract class Corso {
    protected String nome;
    protected String docente;
    protected int oreFrontali;


    protected Corso(String nome, String docente, int oreFrontali) {
        this.nome = nome;
        this.docente = docente;
        this.oreFrontali = oreFrontali;
    }

    public abstract int dammiNumeroCFU();

    public int calcolaCosto() {
        return oreFrontali * 50;
    }

    public int oreTotali() {
        return oreFrontali;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public int getOreFrontali() {
        return oreFrontali;
    }

    public void setOreFrontali(int oreFrontali) {
        this.oreFrontali = oreFrontali;
    }

    @Override
    public String toString() {
        return "[" + nome + ", " + calcolaCosto() + ", " + docente + "]";
    }
}
