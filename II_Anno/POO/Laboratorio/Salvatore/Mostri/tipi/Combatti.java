package tipi;

import java.util.ArrayList;
import java.util.List;

public class Combatti 
{
    private static List <Mostro> Mostri = new ArrayList<>();

    public void AggiungiMostro(Mostro mostro)
    {
        Mostri.add(mostro);
    }

    public void combatti (int i, int j)
    {
        Mostri.get(i).attacco(Mostri.get(j));
        Mostri.get(j).attacco(Mostri.get(i));
    }

    public void rimuovi()
    {
        for(int i = 0; i < Mostri.size(); i++)
        {
            if(Mostri.get(i).getVitalita() <= 0)
            {
                Mostri.remove(i);
            }
        }
    }

    @Override
    public String toString()
    {
        return
        (
            "Elenco Mostri: \n" + Mostri
        );
    }
}
