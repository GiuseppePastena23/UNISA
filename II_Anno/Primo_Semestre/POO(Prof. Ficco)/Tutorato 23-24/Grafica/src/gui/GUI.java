package gui;

import core.*;

import javax.swing.*;
import java.awt.*;
import java.util.Comparator;

public class GUI extends JFrame {
    public GUI() {
        super("Studenti Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());



        JPanel saveOnFilePanel = saveOnFilePanel();
        JPanel inputPanel = inputPanel();
        JPanel showPanel = showPanel();
        add(saveOnFilePanel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(showPanel, BorderLayout.SOUTH);

        setSize(365, 500);
        setVisible(true);
    }

    private static JPanel saveOnFilePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        Button saveOnFileButton = new Button("Salva su file");
        saveOnFileButton.addActionListener(actionEvent -> {
            try {
                StudentiManager.printOnFile();
            } catch (SalvataggioControllatoException e) {
                JOptionPane.showMessageDialog(null, e.toString(), "Errore nel salvataggio dei dati", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(saveOnFileButton);
        return panel;
    }

    private static JPanel inputPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // nome
        JLabel nomeLabel = new JLabel("Nome");
        JTextField nomeTextField = new JTextField();
        nomeTextField.setColumns(10);

        // cognome
        JLabel cognomeLabel = new JLabel("Cognome");
        JTextField cognomeTextField = new JTextField();
        cognomeTextField.setColumns(10);

        // eta
        JLabel etaLabel = new JLabel("Eta");
        JComboBox etaComboBox = new JComboBox();
        for (int i = 18; i <= 100; i++) {
            etaComboBox.addItem(i);
        }

        // categoria
        JLabel categoriaLabel = new JLabel("Categoria");
        JComboBox categoriaComboBox = new JComboBox();
        for (Categoria cat : Categoria.values()) {
            categoriaComboBox.addItem(cat);
        }

        // button
        JButton addButton = new JButton("Aggiungi");
        addButton.addActionListener(actionEvent -> {
            Studente studente = null;
            String nomeStudente, cognomeStudente;
            int etaStudente;
            Categoria categoriaStudente;

            nomeStudente = nomeTextField.getText();
            cognomeStudente = cognomeTextField.getText();

            // non possono essere vuote
            etaStudente = (int) etaComboBox.getSelectedItem();
            categoriaStudente = (Categoria) categoriaComboBox.getSelectedItem();

            studente = new Studente(nomeStudente, cognomeStudente, etaStudente, categoriaStudente);
            StudentiManager.addStudente(studente);
        });

        panel.add(nomeLabel);
        panel.add(nomeTextField);
        panel.add(cognomeLabel);
        panel.add(cognomeTextField);
        panel.add(etaLabel);
        panel.add(etaComboBox);
        panel.add(categoriaLabel);
        panel.add(categoriaComboBox);
        panel.add(addButton);
        return panel;
    }

    private static JPanel showPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        JButton byAgeButton = new JButton("Studenti per eta");
        JButton fuoriCorsoButton = new JButton("Studenti fuori corso");
        JButton over30Button = new JButton("Studenti over 30");
        JButton under30Button = new JButton("Studenti under 30");

        byAgeButton.addActionListener(actionEvent -> {
            StudentiManager.getStudenti()
                    .stream()
                    .sorted((s1, s2) -> s1.getEta() - s2.getEta())
                    .forEach(System.out::println);
        });

        fuoriCorsoButton.addActionListener(actionEvent -> {
            StudentiManager.getStudenti()
                    .stream()
                    .filter(st -> st.getCategoria() == Categoria.FUORI_CORSO)
                    .forEach(System.out::println);
        });

        over30Button.addActionListener(actionEvent -> {
            StudentiManager.getStudenti()
                    .stream()
                    .filter(st -> st.getEta() >= 30)
                    .forEach(System.out::println);
        });

        under30Button.addActionListener(actionEvent -> {
            StudentiManager.getStudenti()
                    .stream()
                    .filter(st -> st.getEta() < 30)
                    .forEach(System.out::println);
        });

        panel.add(byAgeButton);
        panel.add(fuoriCorsoButton);
        panel.add(over30Button);
        panel.add(under30Button);
        return panel;
    }

}
