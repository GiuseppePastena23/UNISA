package tipi;

public class MostroDiPietra extends Mostro
{
    private int Peso;

    MostroDiPietra(String Nome, int LivelloEnergia, int Vitalita, int Peso)
    {
        super(Nome, LivelloEnergia, Vitalita);
        this.Peso = Peso;
    }    
    
    public void attacco(Mostro m)
    {
        if(this.getVitalita() > 0 && this.getLivelloEnergia() > 0);
        if(m instanceof MostroFuoco)
        {
            m.setLivelloEnergia(m.getLivelloEnergia() - (Peso/3));
        }
        //else nothing
    }

    public int getPeso()
    {
        return this.Peso;
    }

    public void setPeso(int Peso)
    {
        this.Peso = Peso;
    }

    @Override
    public String toString() 
    {
        return
        (
            super.toString() +
            "Peso = " + getPeso() + "\n"
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
        MostroDiPietra mostro = (MostroDiPietra)obj;
        return (getNome().equals(mostro.getNome()) && (getLivelloEnergia() == mostro.getLivelloEnergia()) && (getVitalita() == mostro.getVitalita()) && (getPeso() == mostro.getPeso()));
    }
}
