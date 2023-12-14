package es2;

import java.util.GregorianCalendar;

public class Determinato extends Dipendente {
    public GregorianCalendar fineContratto;

    public Determinato(int id, String nome, String cognome, float salario, GregorianCalendar fineContratto) {
        super(id, nome, cognome, salario);
        this.fineContratto = fineContratto;
    }

    public GregorianCalendar getFineContratto() {
        return fineContratto;
    }

    @Override
    public String toString() {
        return "Determinato{" +
                "fineContratto=" + fineContratto +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }

}