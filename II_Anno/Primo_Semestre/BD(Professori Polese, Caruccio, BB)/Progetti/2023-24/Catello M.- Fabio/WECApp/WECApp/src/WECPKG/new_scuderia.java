package WECPKG;

import WECPKG.Utilities.Connessione;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class new_scuderia extends JPanel {

    private JTextField textField1;
    private JTextField textField2;
    private JLabel sede_scuderia;
    private JTextField textField4;
    private JButton aggiungiComponentiButton;
    private JButton annullaButton;
    private JButton applicaButton;
    private JPanel panelmain;
    private JPanel subpanel;
    private JTextField textField3;

    public new_scuderia(){

        add(panelmain, BorderLayout.BEFORE_FIRST_LINE);

       applicaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = textField1.getText(); //nome scuderia
                String b = textField2.getText(); //sede scuderia
                String c = textField3.getText(); //id gara
                String d = textField4.getText(); //modello
                Connessione con = new Connessione();
                Operazioni.register_scuderia(a,b,Integer.parseInt(c),d, con);
            }
       });
 }
}
