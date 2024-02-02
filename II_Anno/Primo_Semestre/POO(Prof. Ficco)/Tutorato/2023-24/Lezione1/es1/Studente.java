package es1;

import java.util.ArrayList;
import java.util.List;

public class Studente {
    public final String nome, cognome, codiceFiscale, matricola;
    public final List<Esame> esamiSuperati;


    public Studente(String nome, String cognome, String codiceFiscale, String matricola) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.matricola = matricola;
        esamiSuperati = new ArrayList<Esame>();
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public String getMatricola() {
        return matricola;
    }

    public void superaEsame(Esame esame) {
        if (!haSuperato(esame)) esamiSuperati.add(esame);
    }

    public boolean haSuperato(Esame esame) {
        return esamiSuperati.contains(esame);
    }

    public boolean equals(Studente s) {
        return matricola.equals(s.getMatricola());
    }

    @Override
    public String toString() {
        return "es1.Studente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", codiceFiscale='" + codiceFiscale + '\'' +
                ", matricola='" + matricola + '\'' +
                ", esamiSuperati=" + esamiSuperati +
                '}';
    }
}
