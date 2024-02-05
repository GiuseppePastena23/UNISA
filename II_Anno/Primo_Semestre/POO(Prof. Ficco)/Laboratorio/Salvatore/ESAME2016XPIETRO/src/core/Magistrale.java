package core;

import java.util.List;
import java.util.ArrayList;

public class Magistrale extends Corso
{
    private List<NomiIndirizzi> IndirizziConCorso = new ArrayList<>();

    public Magistrale(String nome, String docente, List<NomiIndirizzi> indirizziConCorso, int totaleOreLezioni)
    {
        super(nome, docente, totaleOreLezioni);
        IndirizziConCorso = indirizziConCorso;
    }

    public int DammiNumeroCFU()
    {
        return(getTotaleOreLezioni()/8);
    }
    
    public int CalcolaCosto()
    {
        return(getTotaleOreLezioni()*50);
    }

    public void addIndirizziConCorso(NomiIndirizzi nomeCorso)
    {
        IndirizziConCorso.add(nomeCorso);
    }

    public void removeIndirizziConCorso(NomiIndirizzi nomeCorso)
    {
        IndirizziConCorso.remove(nomeCorso);
    }

    public List<NomiIndirizzi> getIndirizziConCorso()
    {
        return IndirizziConCorso;
    }

    @Override
    public String toString() {
        return "Magistrale [Nome=" + getNome() + ", Docente=" + getDocente() + ", TotaleOreLezioni=" + getTotaleOreLezioni() +
                ", Indirizzi corso =" + IndirizziConCorso + "]";
    }
}
