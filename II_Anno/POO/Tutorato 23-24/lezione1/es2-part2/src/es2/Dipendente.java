package es2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Dipendente implements Serializable {
    private static int lastID = 0;
    protected final int id;
    protected final String nome, cognome;
    protected float salario;
    protected List<Progetto> historyProjects = new ArrayList<>();


    // Autoincrement ID
    public Dipendente(String nome, String cognome, float salario) {
        this.id = ++lastID;
        this.nome = nome;
        this.cognome = cognome;
        this.salario = salario;
    }

    // Specified ID
    public Dipendente(int id, String nome, String cognome, float salario) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.salario = salario;
    }

    public static int getLastID() {
        return lastID;
    }

    public static void setLastID(int lastID) {
        Dipendente.lastID = lastID;
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

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Dipendente)) {
            return false;
        }
        Dipendente dip = (Dipendente) obj;
        return this.getId() == dip.getId();
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
