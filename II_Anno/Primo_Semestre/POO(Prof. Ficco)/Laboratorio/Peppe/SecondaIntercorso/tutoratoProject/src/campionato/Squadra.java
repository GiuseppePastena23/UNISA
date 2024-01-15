package campionato;
import campionato.exception.NumberNotValidException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class Squadra {

    private String nome;
    private List<Giocatore> giocatori;
    private int scudetti;

    public Squadra(String nome, int scudetti){
        giocatori = new ArrayList<>();
        this.nome = nome;
    }

    public void addGiocatore(Giocatore g) throws NumberNotValidException {
        if(giocatori.stream().anyMatch(giocatore -> giocatore.getNMaglia() == g.getNMaglia())) {
            throw new NumberNotValidException("Numero già assegnato ad un altro giocatore");
        }
        giocatori.add(g);
    }

    

    public void getPlayerByNumber(int n){
        giocatori.stream().filter(g -> (g.getNMaglia() == n)).forEach(System.out::println);
    }

    public List<Giocatore> getGiocatori(){
        return giocatori.stream().collect(Collectors.toList());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setGiocatori(List<Giocatore> giocatori) {
        this.giocatori = giocatori;
    }

    public int getScudetti() {
        return scudetti;
    }

    public void setScudetti(int scudetti) {
        this.scudetti = scudetti;
    }
    
}
