package es2;

public class Stagista extends Dipendente {
    private static int ritenuta = 300;
    private Dipendente supervisore;

    public Stagista(int id, String nome, String cognome, float salario, Dipendente supervisore) {
        super(id, nome, cognome, salario);
        this.supervisore = supervisore;
    }

    public static int getRitenuta() {
        return ritenuta;
    }

    public static void setRitenuta(int ritenuta) {
        Stagista.ritenuta = ritenuta;
    }

    public Dipendente getSupervisore() {
        return supervisore;
    }

    public void setSupervisore(Dipendente supervisore) {
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
