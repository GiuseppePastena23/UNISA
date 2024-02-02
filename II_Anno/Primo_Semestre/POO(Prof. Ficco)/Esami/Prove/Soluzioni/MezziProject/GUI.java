package gui;

import core.Autobus;
import core.Treno;
import core.VeicoliManager;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.util.stream.Collectors;

public class GUI extends JFrame {

    public GUI(VeicoliManager veicoliManager) {
        super("Veicoli");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setLayout(new FlowLayout());

        JPanel top = new JPanel(new FlowLayout());
        JPanel bottom = new JPanel();

        JButton buttonRitardo = new JButton("Treni in ritardo");
        JButton buttonPosti = new JButton("Autobus con posti");
        JTextArea textArea = new JTextArea(50, 50);
        textArea.setEditable(false);


        buttonRitardo.addActionListener(e -> {
            textArea.setText(
                veicoliManager.stream()
                    .filter(v -> (v instanceof Treno && ((Treno) v).getRitardo() >= 60))
                        .map(Objects::toString)
                        .collect(Collectors.joining("\n"))
            );
        });

        buttonPosti.addActionListener(e -> {
            textArea.setText(
                    veicoliManager.stream()
                        .filter(v -> (v instanceof Autobus && ((Autobus) v).getPosti() >= 30))
                        .map(Objects::toString)
                            .collect(Collectors.joining("\n"))
            );
        });

        top.add(buttonRitardo);
        top.add(buttonPosti);
        bottom.add(textArea);
        add(top);
        add(bottom);
        pack();
        setVisible(true);
    }

}
