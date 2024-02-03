package campionato;

import campionato.exception.NumberNotAvailableException;
import campionato.exception.NumberNotValidException;

public class Giocatore{

    private String nome;
    private int nMaglia;
    private int age;
    
    public Giocatore(String nome, int age, int nMaglia) throws NumberNotValidException{
        if(age < 0 || age > 99){
            throw new NumberNotAvailableException("Numero maglia non valido!");
        }
        this.nome = nome;
        this.age = age;
        this.nMaglia = nMaglia;
    }

    public int getNMaglia(){
        return nMaglia;
    }

    public String getNome(){
        return nome;
    }

    public int getAge(){
        return age;
    }

    @Override
    public String toString() {
        return "Giocatore [nome=" + nome + ", nMaglia=" + nMaglia + ", age=" + age + "]";
    }

    
}