import javax.swing.*;

import Studenti.Studenti;
import Studenti.Studenti.Categoria;

import java.awt.*;

public class GuiStudenti
{
    public static void Gestore()
    {
        JFrame frame = new JFrame("Lezione 4 - Esercizio 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel Studente = new JPanel(new FlowLayout()); //dove metteremo gli studenti

        //label come indicato dalla foto
        JLabel Nome = new JLabel("Nome");
        JLabel Cognome = new JLabel("Cognome");
        JLabel Eta = new JLabel("Eta");
        JLabel Categoria = new JLabel("Categoria");
        
        //textfield come indicato nella foto
        JTextField insertNome = new JTextField(1); 
        JTextField insertCognome = new JTextField(1);
        JTextField insertEta = new JTextField(1);
        JTextField insertCategoria = new JTextField(1);

        //bottone inserisci
        JButton AggiungiStudente = new JButton("Aggiungi");
        AggiungiStudente.addActionListener(e->{});;
        
    }
}
