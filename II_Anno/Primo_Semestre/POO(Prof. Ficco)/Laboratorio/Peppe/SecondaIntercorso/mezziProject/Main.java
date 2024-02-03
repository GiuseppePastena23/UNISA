package gui;

import javax.swing.*;

import core.mezzi.Autobus;
import core.mezzi.Treno;
import core.mezzi.VeicoliManager;

import java.awt.*;
import java.util.Random;

public class Main extends JFrame{

    public Main(){

        VeicoliManager v = new VeicoliManager();
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            int randomCapacity = random.nextInt(101);
            int randomSpeed = random.nextInt(101);
            if (random.nextBoolean()) {
                v.addVeicolo(new Treno(randomCapacity, randomSpeed));
            } else {
                v.addVeicolo(new Autobus(randomCapacity, randomSpeed));
            }
        }

        setTitle("Veicoli");
        setLayout(new BorderLayout());
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTextArea textArea = new JTextArea(250, 250);
        JScrollPane scrollPane = new JScrollPane(textArea);

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
       
        JButton treniInRitardo = new JButton("Treni in ritardo");
        JButton autobusConNPosti = new JButton("Autobus con posti");

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2, 1));
        panel1.add(treniInRitardo);
        panel1.add(autobusConNPosti);

        treniInRitardo.addActionListener(e -> (v.treniInRitardo(60)).stream().forEach(t -> textArea.append(t.toString() + "\n")));
        autobusConNPosti.addActionListener(e -> (v.autobusConNPosti(30)).stream().forEach(t -> textArea.append(t.toString() + "\n")));

        add(scrollPane, BorderLayout.CENTER);
        add(panel1, BorderLayout.NORTH);
        add(textArea, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
