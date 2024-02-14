package core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Campionato 
{
    private static List<Squadra> ListaSquadre = new ArrayList<>();
    
    public Campionato(){};

    public List<Squadra> getListaSquadre()
    {
        return(ListaSquadre);
    }

    public static void addPlayer(Calciatori c, Squadra s)
    {
        int NumeroMaglia = c.getNumeroMaglia();
        if
        (
            s.getListaCalciatori().stream().anyMatch(c1 -> c1.getNumeroMaglia() == NumeroMaglia)
        )
        {
            throw new NumberNotAvaiableException();
        }
        //dopo tutti i controlli
        s.addCalciatore(c);
    }   
     
    public static void SquadraSubscription(Squadra s) throws SquadraRegisteredException
    {
        if(ListaSquadre.stream().anyMatch( s1 -> s1.getNome() == s.getNome()))
        {
            throw new SquadraRegisteredException();
        }
        else
        {
            ListaSquadre.add(s);
        }
    }

    public void PrintCalciatoriByNumero(int NumeroMaglia)
    {
        ListaSquadre.stream()
        .forEach(c -> c.printCalciatoreByNumero(NumeroMaglia));
        /* 
        return
        (
            ListaSquadre.stream()
            .flatMap(squadra -> squadra.getListaCalciatori().stream())
            .filter(c -> c.getNumeroMaglia() == NumeroMaglia)
            .map(Calciatori::toString)
            .collect(Collectors.toList())
        );
        */
    }

    public Squadra searchBySquadra(String NomeSquadra)
    {
        return
        (
            ListaSquadre.stream()
            .filter(s -> s.getNome() == NomeSquadra)
            .findFirst()
            .orElse(null)
        );
    }

    public void printSquadraByScudetti()
    {
        ListaSquadre.stream()
        .sorted((s1, s2) -> Integer.compare(s1.getScudettiVinti(), s2.getScudettiVinti()))
        .forEach(System.out::println);
    }
}
