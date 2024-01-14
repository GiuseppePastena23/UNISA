package gui;

import core.Corso;
import core.ProgrammazioneDidattica;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class GUI extends JFrame {
    public GUI(ProgrammazioneDidattica p) {
        super("Programmazione didattica " + p.getNome());
        setSize(100, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 1));

        JLabel costoTotale = new JLabel(String.valueOf(p.calcolaCosto()));
        JComboBox<String> corsiInseriti = new JComboBox<>(p.getCorsi().stream()
                .map(Corso::toString)
                .toArray(String[]::new));

        JButton buttonVerifica = new JButton("Verifica");
        JLabel labelVerifica = new JLabel();
        buttonVerifica.addActionListener(e -> {
            labelVerifica.setText(p.verifica() ? "soddisfa" : "non soddisfa");
        });

        panel.add(costoTotale);
        panel.add(corsiInseriti);
        panel.add(buttonVerifica);
        panel.add(labelVerifica);
        add(panel);
        pack();
        setVisible(true);
    }
}
