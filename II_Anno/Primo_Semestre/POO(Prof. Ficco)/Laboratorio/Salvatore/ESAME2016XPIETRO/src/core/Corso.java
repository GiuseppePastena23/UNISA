package core;

public abstract class Corso
{
    private String Nome;

    private String Docente;

    private int TotaleOreLezioni;


    public Corso(String nome, String docente, int totaleOreLezioni)
    {
        Nome = nome;
        Docente = docente;
        TotaleOreLezioni = totaleOreLezioni;
    }

    public String getNome() 
    {
        return Nome;
    }
    public void setNome(String nome) 
    {
        this.Nome = nome;
    }
    
    public String getDocente() 
    {
        return Docente;
    }
    public void setDocente(String docente) 
    {
        this.Docente = docente;
    }

    public int getTotaleOreLezioni() 
    {
        return TotaleOreLezioni;
    }

    public void setTotaleOreLezioni(int totaleOreLezioni) 
    {
        TotaleOreLezioni = totaleOreLezioni;
    }

    public abstract int DammiNumeroCFU();

    public abstract int CalcolaCosto();

    @Override
    public String toString() {
        return "Corso [Nome=" + Nome + ", Docente=" + Docente + ", TotaleOreLezioni=" + TotaleOreLezioni + "]";
    }
    

}
