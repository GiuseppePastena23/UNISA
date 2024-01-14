package core.corsi;

import java.util.List;
import java.util.ArrayList;

public class ProgrammazioneDidattica {
    private String nome;
    private List<Corso> corsi;
    private int minHPreviste;
    private int maxHPreviste;

    public ProgrammazioneDidattica(String nome, int maxHPreviste){
        this.nome = nome;
        this.maxHPreviste = maxHPreviste;
        corsi = new ArrayList<>();
    }

    public void aggiungiCorso(Corso corso) throws OreSuperateException{
        if((corso.getOre() + getTotaleOre()) > maxHPreviste){
            throw new OreSuperateException("Ore Superate!");
        }
        else{
            corsi.add(corso);
        }
    }

    public boolean cancellaCorso(Corso c){
        return (corsi.remove(c));
    }

    public boolean verifica(){
        return getTotaleOre() >= minHPreviste && getTotaleOre() <= maxHPreviste;
    }
    
    public int calcolaCosto(){
        return corsi.stream().mapToInt(c -> c.calcolaCosto()).sum();
    }

    public int calcolaCFU(){
        return corsi.stream().mapToInt(c -> c.dammiNumeroCFU()).sum();
    }

    public int getTotaleOre(){
        return corsi.stream().mapToInt(c -> c.getOre()).sum();
    }

    public List<Corso> getList(){
        return corsi;
    }
}
