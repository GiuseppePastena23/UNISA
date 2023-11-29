import java.util.List;

public class Studente {
    public String nome, cognome, matricola;
    private String DSA; // descrizione patologia principale
    public List<Esami> esamiSuperati;

    public Studente(String nome, String cognome, String matricola, String DSA) {
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
        this.DSA = DSA;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public String getDSA() {
        return DSA;
    }

    public void setDSA(String DSA) {
        this.DSA = DSA;
    }

    public boolean isDSA() {
        return DSA != null;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " Cognome: " + cognome + " Matricola:" + matricola + ((isDSA()) ? "DSA: " + DSA : null);
    }
}
