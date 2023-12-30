package tipi;

public abstract class Mostro 
{
    private String Nome;
    private int LivelloEnergia;
    private int Vitalita;

    Mostro(String Nome, int LivelloEnergia, int Vitalita)
    {
        this.Nome = Nome;
        this.LivelloEnergia = LivelloEnergia;
        this.Vitalita = Vitalita;
    }

    public abstract void attacco(Mostro m);
    
    public void difesa()
    {
        this.Vitalita--;
    }
    
    public String getNome()
    {
        return(this.Nome);
    }

    public int getLivelloEnergia()
    {
        return(this.LivelloEnergia);
    }

    public int getVitalita()
    {
        return(this.Vitalita);
    }

    public void setNome(String Nome)
    {
        this.Nome = Nome;
    }
    
    public void setLivelloEnergia(int LivelloEnergia)
    {
        this.LivelloEnergia = LivelloEnergia;
    }
    
    public void setVitalita(int Vitalita)
    {
        this.Vitalita = Vitalita;
    }

    @Override
    public String toString() 
    {
        return
        (
            "Nome = " + getNome() + "\n" +
            "LivelloEnergia = " + getLivelloEnergia() + "\n" +
            "Vitalità = " + getVitalita() + "\n"
        );
    }

    @Override
    public boolean equals(Object obj) 
    {
        if(obj == this)
        {
            return true;
        }
        if(obj == null || obj.getClass() != this.getClass())
        {
            return false;
        }
        Mostro mostro = (Mostro)obj;
        return (Nome.equals(mostro.getNome()) && (LivelloEnergia == mostro.getLivelloEnergia()) && (Vitalita == mostro.getVitalita()));
    }
}
