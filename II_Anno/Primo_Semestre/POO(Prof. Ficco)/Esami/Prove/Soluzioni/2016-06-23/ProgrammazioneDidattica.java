package core;

import java.util.ArrayList;
import java.util.List;

public class ProgrammazioneDidattica {
    private String nome;
    private List<Corso> corsi;
    private int oreMinime;
    private int oreMassime;

    public ProgrammazioneDidattica(String nome, int oreMinime, int oreMassime) {
        this.nome = nome;
        corsi = new ArrayList<Corso>();
        this.oreMinime = oreMinime;
        this.oreMassime = oreMassime;
    }

    public void aggiungiCorso(Corso c) {
        if (oreTotali() + c.oreTotali() > oreMassime) {
            throw new OreSuperateException();
        }
        corsi.add(c);
    }

    public void cancellaCorso(Corso c) {
        corsi.remove(c);
    }

    public boolean verifica() {
        int ore = oreTotali();
        return (oreMinime <= ore && ore <= oreMassime);
    }

    public int calcolaCosto() {
        return corsi.stream().mapToInt(Corso::calcolaCosto).sum();
    }

    public int calcolaCFU() {
            return corsi.stream().mapToInt(Corso::dammiNumeroCFU).sum();
    }

    private int oreTotali() {
        return corsi.stream().mapToInt(Corso::oreTotali).sum();
    }

    public String getNome() {
        return nome;
    }

    public List<Corso> getCorsi() {
        return corsi;
    }

    public int getOreMinime() {
        return oreMinime;
    }

    public int getOreMassime() {
        return oreMassime;
    }

}
