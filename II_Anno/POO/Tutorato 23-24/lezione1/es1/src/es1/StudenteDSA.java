package es1;

public class StudenteDSA extends Studente {
    private Patologia patologia;

    public StudenteDSA(String nome, String cognome, String codiceFiscale, String matricola, Patologia patologia) {
        super(nome, cognome, codiceFiscale, matricola);
        this.patologia = patologia;
    }

    public Patologia getPatologia() {
        return patologia;
    }

    public void setPatologia(Patologia patologia) {
        this.patologia = patologia;
    }

    @Override
    public String toString() {
        return "es1.StudenteDSA{" +
                "patologia=" + patologia +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", codiceFiscale='" + codiceFiscale + '\'' +
                ", matricola='" + matricola + '\'' +
                ", esamiSuperati=" + esamiSuperati +
                '}';
    }
}

