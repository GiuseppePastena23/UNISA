package Progetto.ClassiQuery;

import java.time.LocalDate;

public class Gara
{
    public enum TipoGara
    {
        asciutta,
        bagnata;
    }

    private LocalDate giorno;
    private String nomeCircuito;
    private int durata;
    private TipoGara tipo;
    private String nome;

    public Gara(LocalDate giorno, String nomeCircuito, int durata, TipoGara tipo, String nome) {
        this.giorno = giorno;
        this.nomeCircuito = nomeCircuito;
        this.durata = durata;
        this.tipo = tipo;
        this.nome = nome;
    }

    public LocalDate getGiorno() {
        return giorno;
    }

    public void setGiorno(LocalDate giorno) {
        this.giorno = giorno;
    }

    public String getNomeCircuito() {
        return nomeCircuito;
    }

    public void setNomeCircuito(String nomeCircuito) {
        this.nomeCircuito = nomeCircuito;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public TipoGara getTipoGara() {
        return tipo;
    }

    public void setTipoGara(TipoGara tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Gara{" +
                "giorno=" + giorno +
                ", nomeCircuito='" + nomeCircuito + '\'' +
                ", durata=" + durata +
                ", tipo='" + tipo + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }    
}
