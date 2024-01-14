package test;

import core.*;
import gui.GUI;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ProgrammazioneDidattica p = new ProgrammazioneDidattica("Corso di Laurea in Informatica", 25, 500);
        CorsoTriennale corsoTriennale1 = new CorsoTriennale("Corso1", "Docente1", 20, 10);
        CorsoTriennale corsoTriennale2 = new CorsoTriennale("Corso2", "Docente2", 15, 8);
        CorsoTriennale corsoTriennale3 = new CorsoTriennale("Corso3", "Docente3", 18, 12);

        CorsoDottorato corsoDottorato1 = new CorsoDottorato("CorsoDottorato1", "DocenteDottorato1", 30, Lingue.INGLESE);
        CorsoDottorato corsoDottorato2 = new CorsoDottorato("CorsoDottorato2", "DocenteDottorato2", 25, Lingue.ITALIANO);
        CorsoDottorato corsoDottorato3 = new CorsoDottorato("CorsoDottorato3", "DocenteDottorato3", 28, Lingue.ITALIANO);

        CorsoMagistrale corsoMagistrale1 = new CorsoMagistrale("CorsoMagistrale1", "Docente1", 25, Arrays.asList(Indirizzi.INFORMATICA, Indirizzi.INGEGNERIA));
        CorsoMagistrale corsoMagistrale2 = new CorsoMagistrale("CorsoMagistrale2", "Docente2", 20, Arrays.asList(Indirizzi.INFORMATICA));
        CorsoMagistrale corsoMagistrale3 = new CorsoMagistrale("CorsoMagistrale3", "Docente3", 22, Arrays.asList(Indirizzi.FISICA));

        p.aggiungiCorso(corsoTriennale1);
        p.aggiungiCorso(corsoTriennale2);
        p.aggiungiCorso(corsoTriennale3);
        p.aggiungiCorso(corsoDottorato1);
        p.aggiungiCorso(corsoDottorato2);
        p.aggiungiCorso(corsoDottorato3);
        p.aggiungiCorso(corsoMagistrale1);
        // p.aggiungiCorso(corsoMagistrale2);
        p.aggiungiCorso(corsoMagistrale3);

        new GUI(p);
    }
}
