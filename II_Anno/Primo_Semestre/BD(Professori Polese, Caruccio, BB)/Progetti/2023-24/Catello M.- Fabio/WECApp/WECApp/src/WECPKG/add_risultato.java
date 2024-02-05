package WECPKG;

import WECPKG.Utilities.Connessione;
import WECPKG.Utilities.Utilities;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class add_risultato extends JDialog {

    private JPanel subpanel1;
    private JPanel mainpanel;
    private JPanel subpanel2;
    private JButton chiudiButton;
    private JButton applicaButton;
    private JTextField puntitextfield;
    private JTextField posizionetextfield;
    private JTextField motivotextfield;
    private int id_gara;
    private int codice_gara;
    public add_risultato(int id_gara, int codice_gara){
        this.id_gara = id_gara;
        this.codice_gara = codice_gara;
        mainpanel.add(subpanel1, BorderLayout.CENTER);
        mainpanel.add(subpanel2, BorderLayout.SOUTH);
        add(mainpanel);
        setSize(245, 104);


        applicaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int posizione = Utilities.tryIntParse(posizionetextfield.getText());
                int punti = Utilities.tryIntParse(puntitextfield.getText());
                String motivo = Utilities.tryCastToString(motivotextfield.getText());
                Connessione con = new Connessione();
                System.out.println(Operazioni.updatePartecipazione(posizione, punti, motivo, id_gara,codice_gara, con));
                dispose();
            }
        });

        puntitextfield.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                testit();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                testit();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                testit();
            }
            public void testit(){
                if (Utilities.tryIntParse(puntitextfield.getText()) > 0 || Utilities.tryIntParse(posizionetextfield.getText()) > 0) {
                    motivotextfield.setText("");
                }
            }
        });

        posizionetextfield.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                testit();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                testit();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                testit();
            }
            public void testit(){
                if (Utilities.tryIntParse(puntitextfield.getText()) > 0 || Utilities.tryIntParse(posizionetextfield.getText()) > 0) {
                    motivotextfield.setText("");
                }
            }
        });
        motivotextfield.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                testit();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                testit();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                testit();
            }
            public void testit(){
                String temp = motivotextfield.getText();
                if (!temp.isBlank() || !temp.isEmpty()) {
                    puntitextfield.setText("0");
                    posizionetextfield.setText("0");
                }
            }
        });
    }

}

