import java.io.Serializable;

public class Lavoratore implements Serializable{
    public String nome;
    public String cognome;
    public float salario;
    

    public Lavoratore(String nome, String cognome, float salario){
        this.nome = nome;
        this.cognome = cognome;
        this.salario = salario;
    }

    
}