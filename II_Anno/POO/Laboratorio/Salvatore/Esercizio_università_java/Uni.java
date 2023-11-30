import java.util.ArrayList;
import java.util.List;

import università.Esame;
import università.Studente;
import università.Studente_DSA;

public class Uni 
{   
    //creazione lista tutti studenti istituto
    private List<Studente> Studenti = new Arraylist<Studente>();

    //get studente a posizione fissata
    Studente getStudente_pos(int pos)
    {
        if(pos >= 0 && pos < Studenti.size())
        {
            return Studenti.get(pos);
        }
        else{java.out.println("Errore indice");}
    }
    //set studente a posizione fissata
    void setStudente_pos(Studente studente, int pos)
    {
        if(pos >= 0 && pos < Studenti.size())
        {
            Studenti.set(pos, studente);
        }
        else{java.out.println("Errore indice");}
    }

    //get all studenti
    Studente getStudenti(){return Studenti;}

    //aggiunti studente nel primo posto libero lista
    void set_Studenti(Studente studente){Studenti.add(Studente);}


    //restituisce tutti gli studenti che hanno l'esame e in curriculum.
    public List<Studente> getStudentiByEsame(Esame esame) 
    {
        List<Studente> Studenti_con_esame = new ArrayList<>();
        for(int i = 0; i < Studenti.size(); i++)
        {
            Studente studente_corrente = Studenti.get(i);
            for(int j = 0; j < studente_corrente.getEsami_superati().size; j++)
            {
                if(studente_corrente.getEsame_superato(j).equal(esame))
                {
                    Studenti_con_esame.add(studente_corrente);
                }
                //else do nothing
            }
        }
        return Studenti_con_esame;
    }
}
