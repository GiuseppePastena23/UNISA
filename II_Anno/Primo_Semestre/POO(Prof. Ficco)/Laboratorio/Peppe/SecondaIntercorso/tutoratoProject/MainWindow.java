package campionato.gui;

import javax.swing.*;

import campionato.Campionato;
import campionato.Giocatore;
import campionato.Squadra;
import campionato.exception.SquadraRegisteredException;

import java.awt.*;
import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame{

        public static void main(String[] args) {
            new MainWindow();
        }
    
        static Campionato campionato = new Campionato("Serie A");
         
        public MainWindow() {
                setTitle("Gestione Campionato: " + campionato.getNome());
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                setSize(500, 500);

                JPanel panel = new JPanel(new GridLayout(10, 10, 10, 10));
                JPanel mainPanel = new JPanel(new BorderLayout());

                JLabel label1 = new JLabel("Nome Squadra");
                label1.setBounds(50, 50, 100, 30);
                panel.add(label1);

                JTextField textField1 = new JTextField(10);
                textField1.setBounds(160, 50, 100, 30);
                panel.add(textField1);

                JLabel label2 = new JLabel("Scudetti");
                label2.setBounds(50, 100, 100, 30);
                panel.add(label2);

                JTextField textField2 = new JTextField(10);
                textField2.setBounds(160, 100, 100, 30);
                panel.add(textField2);

                JButton addButton = new JButton("Add");
                addButton.setBounds(50, 150, 100, 30);
                panel.add(addButton);

                JTextArea textArea = new JTextArea();

                JButton stampaSquadre = new JButton("Stampa squadre");
                JButton stampaGiocatori = new JButton("Stampa Giocatori");
                
                
                JLabel nomeGiocatore = new JLabel("Nome Giocatore");
                panel.add(nomeGiocatore);
                JTextField nomeGioc = new JTextField(10);
                panel.add(nomeGioc);
                JLabel numeroMaglia = new JLabel("nMaglia");
                panel.add(numeroMaglia);
                JComboBox<Integer> nMaglia = new JComboBox<>();
                for (int i = 1; i <= 99; i++) {
                    nMaglia.addItem(i);
                }
                panel.add(nMaglia);

                JButton addGiocatore = new JButton("Add giocatore");
                panel.add(addGiocatore);
                
                
                
                

                stampaSquadre.addActionListener(e -> {campionato.getSquadre().forEach(s -> textArea.append(s.toString() + "\n"));});

                JComboBox comboBox = new JComboBox<>();
                
                stampaGiocatori.addActionListener(e -> {campionato.searchBySquadra(comboBox.getSelectedItem().toString()).getGiocatori().stream().forEach(s -> textArea.append(s.toString() + "\n"));});

                stampaGiocatori.addActionListener(e -> {
                    campionato.searchBySquadra(comboBox.getSelectedItem().toString()).getGiocatori().stream().forEach(s2 -> textArea.append(s2.toString()));
                });

                addGiocatore.addActionListener(e -> {
                    Giocatore g = new Giocatore(nomeGioc.getText(), 20, (int)nMaglia.getSelectedItem());
                    campionato.addPlayer(g, campionato.searchBySquadra((String)comboBox.getSelectedItem()));
                });

                addButton.addActionListener(e -> {
                    try {
                        Squadra s = new Squadra(textField1.getText(), Integer.parseInt(textField2.getText()));
                        campionato.squadraSubscription(s);
                        comboBox.addItem(s.getNome());
                        textArea.append("Aggiunta " + textField1.getText() + "/Scudetti: " + textField2.getText() + "\n");
                    } catch (SquadraRegisteredException a) {
                        textArea.append("Squadra gia' inserita!\n");
                        a.printStackTrace();
                    }
                    
                });

                campionato.getSquadre().stream().forEach(s -> comboBox.addItem(s.getNome()));

                panel.add(comboBox);
                panel.add(stampaSquadre);
                panel.add(stampaGiocatori);
                mainPanel.add(textArea, BorderLayout.CENTER);
                mainPanel.add(panel, BorderLayout.NORTH);
                add(mainPanel);
                setVisible(true);
            }
    }

