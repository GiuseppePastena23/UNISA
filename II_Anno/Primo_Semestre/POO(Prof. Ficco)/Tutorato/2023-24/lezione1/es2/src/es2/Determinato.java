package es2;

import java.util.Date;

public class Determinato extends Dipendente {
    public Date fineContratto;


    public Determinato(int id, String nome, String cognome, float salario, Date fineContratto) {
        super(id, nome, cognome, salario);
        this.fineContratto = fineContratto;
    }

    public Date getFineContratto() {
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
