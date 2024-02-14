package core;

import java.util.ArrayList;
import java.util.List;

public class ProgammazioneDidattica 
{
    private NomiIndirizzi NomeIndirizzo;
    private List<Corso> ListaCorsi = new ArrayList<>();
    private int NumeroOreMinime;
    private int NumeroOreMassime;
    
    public ProgammazioneDidattica(){};

    public ProgammazioneDidattica (NomiIndirizzi nomeIndirizzo, List<Corso> listaCorsi, int numeroOreMinime, int numeroOreMassime)
    {
        NomeIndirizzo = nomeIndirizzo;
        ListaCorsi = listaCorsi;
        NumeroOreMassime = numeroOreMassime;
        NumeroOreMinime = numeroOreMinime;
    }

    public void AggiungiCorso(Corso corso)
    {
        if(corso.getTotaleOreLezioni() <= NumeroOreMassime)
        {
            ListaCorsi.add(corso);
        }
        else
        {
            throw new OreSuperate();
        }
    }

    public void CancellaCorso(Corso corso)
    {
        ListaCorsi.remove(corso);
    }

    public boolean verifica()
    {
        int totalLezioni = ListaCorsi.stream()
            .mapToInt(Corso::getTotaleOreLezioni) 
            .sum();
        
        return(totalLezioni <= NumeroOreMassime && totalLezioni >= NumeroOreMinime);
    }

    public int CalcolaCosto()
    {
        return
        (
            ListaCorsi.stream()
            .mapToInt(Corso::CalcolaCosto)
            .sum()
        );
    }

    public int CalcoloCFU()
    {
        return
        (
            ListaCorsi.stream()
            .mapToInt(Corso::DammiNumeroCFU)
            .sum()
        );
    }

    public NomiIndirizzi getNomeIndirizzo() {
        return NomeIndirizzo;
    }

    public void setNomeIndirizzo(NomiIndirizzi nomeIndirizzo) {
        NomeIndirizzo = nomeIndirizzo;
    }

    public List<Corso> getListaCorsi() {
        return ListaCorsi;
    }

    public void setListaCorsi(List<Corso> listaCorsi) {
        ListaCorsi = listaCorsi;
    }

    public int getNumeroOreMinime() {
        return NumeroOreMinime;
    }

    public void setNumeroOreMinime(int numeroOreMinime) {
        NumeroOreMinime = numeroOreMinime;
    }

    public int getNumeroOreMassime() {
        return NumeroOreMassime;
    }

    public void setNumeroOreMassime(int numeroOreMassime) {
        NumeroOreMassime = numeroOreMassime;
    }

    @Override
    public String toString() 
    {
        return "ProgammazioneDidattica [NomeIndirizzo=" + NomeIndirizzo + ", ListaCorsi=" + ListaCorsi
                + ", NumeroOreMinime=" + NumeroOreMinime + ", NumeroOreMassime=" + NumeroOreMassime + "]";
    }

    
}
