package gui;

import javax.swing.*;


import core.university.CampiVuotoException;
import core.university.Categoria;
import core.university.GestoreStudenti;
import core.university.SalvataggioControllatoException;
import core.university.Studenti;

import java.awt.*;

public class GuiStudenti
{
    public static JPanel createJPanel1()
    {
        JPanel panel = new JPanel();
        JButton ButtonSalva = new JButton();
        ButtonSalva.addActionListener
        (
            e -> 
            {        
                try 
                {
                    GestoreStudenti.SalvaFile("File.txt");
                }
                catch (SalvataggioControllatoException ex)
                 {
                    ex.printStackTrace();
                }
            }
        );
        panel.setLayout(new FlowLayout());
        panel.add(ButtonSalva);

        return panel;
    }

    public static JPanel createJPanel2()
    {
        JPanel panel = new JPanel();
        JLabel nome = new JLabel("Nome");
        JLabel cognome = new JLabel("Cognome");
        JLabel eta = new JLabel("Eta");
        JLabel categoria = new JLabel("Categoria");

        JTextField TextNome = new JTextField();
        JTextField TextCognome = new JTextField();

        JComboBox EtaBOX = new JComboBox<>();
        for(int i = 1; i <= 99; i++)
        {
            EtaBOX.addItem(i);
        }
        JComboBox CategoriaBOX = new JComboBox<>(Categoria.values());
        


        JButton aggiungiStudente = new JButton("Aggiungi");
        aggiungiStudente.addActionListener
        (
            e ->
            {   
                //controllo field vuota
                if(TextNome.getText().isEmpty() || TextCognome.getText().isEmpty())
                {
                    throw new CampiVuotoException("Nome e Cognome devono essere forniti");
                }
                //controllo field vuota Jbox
                if(EtaBOX.getSelectedIndex() == -1 || CategoriaBOX.getSelectedIndex() == -1)
                {
                    throw new CampiVuotoException("Seleazionare Età e Categoria");
                }

                String nomeStudente = TextNome.getText();
                String cognomeStudente = TextCognome.getText();
                int etaStudente = (int)EtaBOX.getSelectedItem();
                Categoria categoriaStudente = (Categoria)CategoriaBOX.getSelectedItem();

                Studenti studente = new Studenti(nomeStudente, cognomeStudente, etaStudente, categoriaStudente);

                GestoreStudenti.addStudente(studente);

            }
        );

        panel.add(nome);
        panel.add(TextNome);
        panel.add(cognome);
        panel.add(TextCognome);
        panel.add(eta);
        panel.add(EtaBOX);
        panel.add(categoria);
        panel.add(CategoriaBOX);
        panel.add(aggiungiStudente);
        panel.setLayout(new FlowLayout());
        return panel;
    }

    public static JPanel createJPanel3()
    {
        JPanel panel = new JPanel();

        JButton eta = new JButton("Studenti per eta");
        JButton fuoricorso = new JButton("Studenti fuori corso");
        JButton over30 = new JButton("Studenti over 30");
        JButton under30 = new JButton("Studenti under 30");

        eta.addActionListener
        (
            e->
            {
                GestoreStudenti.OrdinaPerEta().stream().forEach(s -> System.out.println(s));
            }
        );

        fuoricorso.addActionListener
        (
            e->
            {
                GestoreStudenti.getFuoriCorso().stream().forEach(System.out::println);
            }
        );

        over30.addActionListener
        (
            e->
            {
                GestoreStudenti.getLimit30(true).stream().forEach(s -> System.out.println(s));
            }
        );

        under30.addActionListener
        (
            e->
            {
                GestoreStudenti.getLimit30(false).stream().forEach(s -> System.out.println(s));
            }
        );

        panel.add(eta);
        panel.add(fuoricorso);
        panel.add(over30);
        panel.add(under30);
        panel.setLayout(new FlowLayout());
        return panel;
    }

    public static void Gestore()
    {
        JFrame frame = new JFrame("Lezione 4 - Esercizio 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        

        frame.add(createJPanel1());
        frame.add(createJPanel2());
        frame.add(createJPanel3());

        frame.setVisible(true);
    }
}
