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
        //if(squadre.stream().anyMatch(s1 -> s1.getNome().equals(s.getNome())))
        if(squadre.stream().filter(e -> e.getNome().equals(s.getNome())).count() > 0)
        {
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
               .sorted((s,s1)-> s1.getScudetti() - s.getScudetti())
               .forEach(System.out::println);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSquadre(List<Squadra> squadre) {
        this.squadre = squadre;
    }
}
