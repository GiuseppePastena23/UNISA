package es2;

public class Indeterminato extends Dipendente {
    private static int bonusPerc = 30;
    private String qualificaSettoriale;

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
        return Util.calculatePercentage(getSalario(), bonusPerc);
    }

    public static int getBonusPerc() {
        return bonusPerc;
    }

    public static void setBonusPerc(int bonusPerc) {
        Indeterminato.bonusPerc = bonusPerc;
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
