package es2;

import java.io.Serializable;

public abstract class Dipendente implements Serializable {
    public final int id;
    public final String nome, cognome;
    private float salario;

    public Dipendente(int id, String nome, String cognome, float salario) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getStipendioMensile() {
        return salario;
    }

    public boolean equals(Dipendente d) {
        return id == d.getId();
    }

    @Override
    public String toString() {
        return "Dipendente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", salario=" + salario +
                '}';
    }
}
