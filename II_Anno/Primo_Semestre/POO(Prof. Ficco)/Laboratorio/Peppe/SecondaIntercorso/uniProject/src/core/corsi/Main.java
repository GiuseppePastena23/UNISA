package core.corsi;
import java.io.FileReader;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.*;


public class Main{

    public static void main(String[] args) {
            ProgrammazioneDidattica p = new ProgrammazioneDidattica(null, 200);
            CorsoTriennale corso1 = new CorsoTriennale("Corso1", "Docente1", 20, 10);
            CorsoTriennale corso2 = new CorsoTriennale("Corso2", "Docente2", 15, 8);
            CorsoTriennale corso3 = new CorsoTriennale("Corso3", "Docente3", 18, 12);
            
            CorsoDottorato corsoDottorato1 = new CorsoDottorato("CorsoDottorato1", "DocenteDottorato1", 30, "Italiano");
            CorsoDottorato corsoDottorato2 = new CorsoDottorato("CorsoDottorato2", "DocenteDottorato2", 25, "Inglese");
            CorsoDottorato corsoDottorato3 = new CorsoDottorato("CorsoDottorato3", "DocenteDottorato3", 28, "Francese");
            
            CorsoMagistrale corsoMagistrale1 = new CorsoMagistrale("CorsoMagistrale1", "Docente1", 25, Arrays.asList("Informatica", "Matematica"));
            CorsoMagistrale corsoMagistrale2 = new CorsoMagistrale("CorsoMagistrale2", "Docente2", 20, Arrays.asList("Fisica", "Chimica"));
            CorsoMagistrale corsoMagistrale3 = new CorsoMagistrale("CorsoMagistrale3", "Docente3", 22, Arrays.asList("Economia", "Gestione"));
            
            p.aggiungiCorso(corso1);
            p.aggiungiCorso(corso2);
            p.aggiungiCorso(corso3);
            p.aggiungiCorso(corsoDottorato1);
            p.aggiungiCorso(corsoDottorato2);
            p.aggiungiCorso(corsoDottorato3);
            p.aggiungiCorso(corsoMagistrale1);
            p.aggiungiCorso(corsoMagistrale2);
            p.aggiungiCorso(corsoMagistrale3);

            JFrame frame = new JFrame();
            frame.setTitle("Prova");
            frame.setSize(500, 500);

            JComboBox<String> listCorsi;
            listCorsi = new JComboBox<>();

            JLabel label = new JLabel();
            label.setText(String.valueOf(p.calcolaCosto()));

            JButton b = new JButton();
        
            b.addActionListener(e -> System.out.println(p.verifica()));
            
            for(Corso c : p.getList()){
                listCorsi.addItem(c.toString());
            }
            
            frame.setLayout(new GridLayout(3, 1));
            frame.add(b);
            frame.add(label);
            frame.add(listCorsi);
            frame.setVisible(true);


            // Use the instances of CorsoTriennale and CorsoDottorato as needed
    }
        


}

