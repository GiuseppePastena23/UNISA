package gestionebanca;
public class Banca 
{
    private String nome;
    private String cognome;
    private char o;
    private double imp;

    public Banca(String nome, String cognome, char o, double imp) 
    {
        this.nome = nome;
        this.cognome = cognome;
        this.o = o;
        this.imp = imp;
    }

    @Override
    public String toString() 
    {
        return  "nome=" + nome + ", cognome=" + cognome + ", o=" + o + ", imp=" + imp + '}';
    }

    public String getCognome() 
    {
        return cognome;
    }
}