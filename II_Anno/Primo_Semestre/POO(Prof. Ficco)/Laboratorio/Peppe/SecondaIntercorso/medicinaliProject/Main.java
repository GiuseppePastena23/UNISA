package main.gui;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;

import main.medicinali.*;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        MedSystem med = new MedSystem();

        

        JFrame frame = new JFrame("Finestra con Bottone");
        JButton button = new JButton("Clicca qui");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(null);

        button.addActionListener(e -> {
            med.getFromFile();
            med.printScadutidaAzienda("Azienda1");
            med.printSperimentaliIntermedia();
            med.printUnita();
            med.stampaOrdineAlfa();
            med.stampaToFile();


        });

        button.setBounds(100, 50, 100, 50);

        frame.add(button);
        frame.setVisible(true);
    }

   

    
}

