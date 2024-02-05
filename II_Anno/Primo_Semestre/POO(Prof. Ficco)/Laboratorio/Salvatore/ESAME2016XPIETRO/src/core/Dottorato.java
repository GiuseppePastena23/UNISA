package core;

public class Dottorato extends Corso
{

    private int TotaleOreLaboratorio;


    public Dottorato(String nome, String docente, int totaleOreLaboratorio, int totaleOreLezioni)
    {
        super(nome, docente, totaleOreLezioni);
        TotaleOreLaboratorio = totaleOreLaboratorio;
    }

    public int DammiNumeroCFU()
    {
        return(getTotaleOreLezioni()/8 + getTotaleOreLaboratorio()/10);
    }

    public int CalcolaCosto()
    {
        return(TotaleOreLaboratorio*35 + getTotaleOreLezioni()*50);
    }
    
    public int getTotaleOreLaboratorio() 
    {
        return TotaleOreLaboratorio;
    }

    public void setTotaleOreLaboratorio(int totaleOreLaboratorio) 
    {
        TotaleOreLaboratorio = totaleOreLaboratorio;
    }

    @Override
    public String toString() {
        return "Dottorato [Nome=" + getNome() + ", Docente=" + getDocente() + ", TotaleOreLezioni=" + getTotaleOreLezioni() +
                ", TotaleOreLaboratorio=" + TotaleOreLaboratorio + "]";
    }


}
