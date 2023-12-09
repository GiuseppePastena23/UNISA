package dipendenti;

import java.util.List;
import java.util.ArrayList;

public class Gestore 
{
    private static List<Dipendente> Dipendenti = new ArrayList<>();

    public List<Dipendente> getStagisti()
    {
        List<Dipendente>Stagisti = new ArrayList<>();

        for(Dipendente dipendente : Stagisti) //se un dipendente è uno stagista aggiungilo a stagisti
        {
            if(dipendente instanceof Stagista)
            {
                Stagista stagista = (Stagista)dipendente; //downcasting
                Stagisti.add(stagista);
            }
            //else do nothing
        }

        return(Stagisti);
    }

    public void StampaLavoratori(int soglia) //se un dipendente ha un salario maggiore di soglia allora stampalo
    {
        for(Dipendente dipendente : Dipendenti)
        {
            if(dipendente.getSalario() >= soglia)
            {
                System.out.println(dipendente);
            }
        }
    }
}
