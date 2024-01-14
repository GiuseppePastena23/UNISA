import java.io.Serializable;

public class Lavoratore implements Serializable {
    public String nome, cognome;
    public float salario;

    public Lavoratore(String nome, String cognome, float salario) {
        this.nome = nome;
        this.cognome = cognome;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Lavoratore{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", salario=" + salario +
                '}';
    }
}
