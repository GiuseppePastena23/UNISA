package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MainWindow extends JFrame{
    String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public MainWindow(){
        setTitle("Codice Fiscale");
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)

        JPanel main = new JPanel();
        JTextField nomeField = new JTextField(10);
        JTextField cognomeField = new JTextField(10);
        JRadioButton b1 = new JRadioButton("Maschio");
        JRadioButton b2 = new JRadioButton("Femmina");
        ButtonGroup bg = new ButtonGroup();
        bg.add(b1);
        bg.add(b2);
        JTextField giorno = new JTextField(5);
        JComboBox<String> mese = new JComboBox<>(months);
        JTextField anno = new JTextField(6);
        JTextField comune = new JTextField(10);
        JButton calcolo = new JButton("Calcola codice fiscale");
        JTextField resField = new JTextField(10);
        resField.setEditable(false);

        

        main.add(nomeField);
        main.add(cognomeField);
        main.add(b1);
        main.add(b2);
        main.add(giorno);
        main.add(mese);
        main.add(anno);
        main.add(comune);
        main.add(calcolo);
        main.add(resField);

        
        add(main);
        setVisible(true);
    }
    

    public static void main(String[] args) {
        MainWindow window = new MainWindow();
    }
}
    
    
