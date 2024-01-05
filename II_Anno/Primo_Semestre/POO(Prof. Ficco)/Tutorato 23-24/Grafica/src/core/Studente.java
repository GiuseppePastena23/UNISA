package core;

import gui.CampoVuotoException;

import java.io.*;

public class Studente implements Serializable {
    private final String nome;
    private final String cognome;
    private final int eta;
    private final Categoria categoria;

    public Studente(String nome, String cognome, int eta, Categoria categoria) {
        if (nome.isBlank() || cognome.isBlank()) throw new CampoVuotoException("Nome o cognome vuoto");
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getEta() {
        return eta;
    }

    public Categoria getCategoria() {
        return categoria;
    }



    @Override
    public String toString() {
        return nome + " " + cognome + " " + eta + " " + categoria;
    }
}
