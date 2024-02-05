package WECPKG;

import WECPKG.Utilities.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class add_finanzia extends JDialog {
    private JTextField textField1;
    private JTextField textField2;
    private JPanel subpanel1;
    private JButton annullaButton;
    private JButton applicaButton;
    private JPanel mainpanel;
    private JPanel subpanel2;
    private String nome_pilota;
    private String cognome_pilota;
    private String data_pilota;
    private double importo;
    private String data_fin;

    public add_finanzia(String rif_pilota_nome, String rif_pilota_cognome, String rif_pilota_data_nascita) {
        this.nome_pilota = rif_pilota_nome;
        this.cognome_pilota = rif_pilota_cognome;
        this.data_pilota = rif_pilota_data_nascita;

    mainpanel.add(subpanel1, BorderLayout.NORTH);
    mainpanel.add(subpanel2, BorderLayout.CENTER);
    add(mainpanel, BorderLayout.CENTER);
    setSize(291, 167);


        applicaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setimporto();
                setDatafin();
                dispose();
            }
        });
    }

    public void setimporto() {
        try{
            this.importo = Double.parseDouble(textField1.getText());
        }catch(Exception ex) {
            Utilities.error_message(ex);
            this.importo = 0;}
    }
    public void setDatafin(){
        try{
            this.data_fin = textField2.getText();
        }catch(Exception ex) {
            Utilities.error_message(ex);
            this.data_fin = "";
        }
    }

    public double getImporto() {
        return importo;
    }

    public String getData_fin() {
        return data_fin;
    }
}

