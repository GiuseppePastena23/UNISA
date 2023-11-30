package es2;

public class Indeterminato extends Dipendente {
    private static final int bonusPerc = 30;
    public String qualificaSettoriale;

    public Indeterminato(int id, String nome, String cognome, float salario, String qualificaSettoriale) {
        super(id, nome, cognome, salario);
        this.qualificaSettoriale = qualificaSettoriale;
    }

    public void setQualificaSettoriale(String qualificaSettoriale) {
        this.qualificaSettoriale = qualificaSettoriale;
    }

    public String getQualificaSettoriale() {
        return qualificaSettoriale;
    }

    @Override
    public float getStipendioMensile() {
        return getSalario() * (1 + (bonusPerc / 100.0f));
    }

    @Override
    public String toString() {
        return "Indeterminato{" +
                "qualificaSettoriale='" + qualificaSettoriale + '\'' +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }
}
