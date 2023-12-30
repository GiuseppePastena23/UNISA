package tipi;

public class MostroFuoco extends Mostro
{
    private int Potenza;

    MostroFuoco(String Nome, int LivelloEnergia, int Vitalita, int Potenza)
    {
        super(Nome, LivelloEnergia, Vitalita);
        this.Potenza = Potenza;
    }

    public void attacco(Mostro m)
    {
        if(this.getVitalita() > 0 && this.getLivelloEnergia() > 0);
        this.setLivelloEnergia(this.getLivelloEnergia() - Potenza);
        if(m instanceof MostroAcqua)
        {
            m.setLivelloEnergia(m.getLivelloEnergia() - Potenza);
        }
        //else nothing
    }

    public void setPotenza(int Potenza)
    {
        this.Potenza = Potenza;
    }

    public int getPotenza()
    {
        return(this.Potenza);
    }

    @Override
    public String toString() 
    {
        return
        (
            super.toString() +
            "Potenza = " + getPotenza() + "\n"
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
        MostroFuoco mostro = (MostroFuoco)obj;
        return (getNome().equals(mostro.getNome()) && (getLivelloEnergia() == mostro.getLivelloEnergia()) && (getVitalita() == mostro.getVitalita()) && (getPotenza() == mostro.getPotenza()));
    }
}
