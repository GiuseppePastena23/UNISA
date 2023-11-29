package es2;

public class Stagista extends Dipendente {
    private static final int ritenuta = 300;
    public Dipendente supervisore;

    public Stagista(int id, String nome, String cognome, float salario, Dipendente supervisore) {
        super(id, nome, cognome, salario);
        this.supervisore = supervisore;
    }

    @Override
    public float getStipendioMensile() {
        return getSalario() - ritenuta;
    }

    @Override
    public String toString() {
        return "Stagista{" +
                "supervisore=" + supervisore +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }


}
