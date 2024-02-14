package core;

public class Calciatori 
{
    private String Nome;
    private String Cognome;
    private int NumeroMaglia;
    
    public Calciatori(String nome, String cognome, int numeroMaglia) {
        Nome = nome;
        Cognome = cognome;
        NumeroMaglia = numeroMaglia;
        if(NumeroMaglia < 1 || NumeroMaglia > 99)
        {
            throw new NumberNotValidException();
        }
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public void setCognome(String cognome) {
        Cognome = cognome;
    }

    public int getNumeroMaglia() {
        return NumeroMaglia;
    }

    public void setNumeroMaglia(int numeroMaglia) {
        if(numeroMaglia < 1 || numeroMaglia > 99)
        {
            throw new NumberNotValidException();
        }
        NumeroMaglia = numeroMaglia;
    }

    @Override
    public String toString() {
        return "Calciatori [Nome=" + Nome + ", Cognome=" + Cognome + ", NumeroMaglia=" + NumeroMaglia + "]";
    }
    
}
