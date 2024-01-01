package gui;

import core.QueryRunner;

import javax.swing.*;

public class GUI {
    public GUI() {
        // test connessione al database
        if (!QueryRunner.testConnection()) {
            JOptionPane.showMessageDialog(null, "Errore nella connessione al database", "Errore", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        new Menu();
    }
}
