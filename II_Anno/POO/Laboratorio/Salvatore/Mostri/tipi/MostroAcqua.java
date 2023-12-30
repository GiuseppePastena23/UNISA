package tipi;

public class MostroAcqua extends Mostro 
{
    private int Temperatura;

    MostroAcqua(String Nome, int LivelloEnergia, int Vitalita, int Temperatura)
    {
        super(Nome, LivelloEnergia, Vitalita);
        this.Temperatura = Temperatura;
    }    

    public void attacco(Mostro m)
    {
        if(this.getVitalita() > 0 && this.getLivelloEnergia() > 0);
        if(m instanceof MostroDiPietra)
        {
            m.setLivelloEnergia(m.getLivelloEnergia() - (Temperatura/2));
        }
        //else nothing
    }

    public int getTemperatura()
    {
        return(this.Temperatura);
    }

    public void setTemperatura(int Temperatura)
    {
        Temperatura = this.Temperatura;
    }

    @Override
    public String toString() 
    {
        return
        (
            super.toString() +
            "Temperatura = " + getTemperatura() + "\n"
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
        MostroAcqua mostro = (MostroAcqua)obj;
        return (getNome().equals(mostro.getNome()) && (getLivelloEnergia() == mostro.getLivelloEnergia()) && (getVitalita() == mostro.getVitalita()) && (getTemperatura() == mostro.getTemperatura()));
    }
}
