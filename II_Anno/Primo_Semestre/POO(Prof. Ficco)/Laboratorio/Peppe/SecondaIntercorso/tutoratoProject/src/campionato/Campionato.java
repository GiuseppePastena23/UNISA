package campionato;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import campionato.exception.SquadraRegisteredException;

public class Campionato {
    
    private String nome;
    private List<Squadra> squadre;

    public Campionato(String nome){
        squadre = new ArrayList<>();
        this.nome = nome;
    }

    public void squadraSubscription(Squadra s) throws SquadraRegisteredException {
        if(squadre.contains(s)){
            throw new SquadraRegisteredException("Squadra gia' registrata");
        }
        squadre.add(s);
    }

    public void addPlayer(Giocatore g, Squadra s){
        if(squadre.contains(s)){
            s.addGiocatore(g);
        }
    }

    public void printPlayersByNumber(int n){
        squadre.stream().forEach(s-> s.getPlayerByNumber(n));
    }

    public List<Squadra> getSquadre(){
        return squadre.stream().collect(Collectors.toList());
    }

    public Squadra searchBySquadra(String nomeSquadra){
        return squadre.stream().filter(s -> s.getNome().equalsIgnoreCase(nomeSquadra)).findAny().orElse(null);
    }

    public void printSquadreByScudetti(){
        squadre.stream()
               .sorted((s,s1)-> s.getScudetti() - s1.getScudetti())
               .forEachOrdered(System.out::println);
    }
}
