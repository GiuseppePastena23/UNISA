package WECPKG;

import WECPKG.Utilities.ComboItem;
import WECPKG.Utilities.Connessione;
import WECPKG.Utilities.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class new_pilota extends JPanel{
    private JPanel mainpanel;
    private JPanel subpanel1;
    private JRadioButton pilotaAMRadioButton;
    private JRadioButton pilotaPRORadioButton;
    private JPanel subpanel2;
    private JTextField cognome;
    private JTextField nome;
    private JTextField data_nascita;
    private JTextField nazione;
    private JTextField prima_licenza;
    private JTextField licenze;
    private JComboBox equipaggioComboBox;
    private JPanel subpanel3;
    private JButton annullaButton;
    private JButton applicaButton;
    private JCheckBox GMCheckBox;
    private String rif_scuderia;


    public new_pilota() {

        ButtonGroup buttons = new ButtonGroup();
        buttons.add(pilotaAMRadioButton);
        buttons.add(pilotaPRORadioButton);

        pilotaAMRadioButton.setSelected(true);
        licenze.setText(null);
        licenze.setEditable(false);

        try {
            Connessione con = new Connessione();
            ResultSet temp = con.getStatement().executeQuery(Query.q4);
            while(temp.next()){
                equipaggioComboBox.addItem(new ComboItem(temp.getString("ID_EQUIPAGGIO") + "  " + temp.getString("rif_scuderia") + " " + temp.getString("modello") + " "+ temp.getString("id_gara"), temp.getString("ID_EQUIPAGGIO")));
             //testare cosa succede se i parametri sono null ( un equipaggio non è assegnato a nessun veicolo )
            }
            con.getConnessione().close();
        } catch (Exception ex) {
           Utilities.error_message(ex);
        }



        mainpanel.add(subpanel1, BorderLayout.NORTH);
        mainpanel.add(subpanel2, BorderLayout.CENTER);
        mainpanel.add(subpanel3, BorderLayout.SOUTH);
        add(mainpanel);

        pilotaAMRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GMCheckBox.setEnabled(true);
                prima_licenza.setEditable(true);
                licenze.setText(null);
                licenze.setEditable(false);
            }
        });
        pilotaPRORadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GMCheckBox.setEnabled(false);
                GMCheckBox.setSelected(false);
                prima_licenza.setText(null);
                prima_licenza.setEditable(false);
                licenze.setEditable(true);
            }
        });
        applicaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id_equip = 0;
                try{
                ComboItem id_equipaggio =(ComboItem) equipaggioComboBox.getSelectedItem();
                    String par = id_equipaggio.getValue();
                id_equip = Integer.parseInt(par);
                if (pilotaAMRadioButton.isSelected() && GMCheckBox.isSelected() && check_equipaggio(id_equip)) {
                    Connessione con = new Connessione();
                    con.getConnessione().setAutoCommit(false);
                    Operazioni.add_pilota_AM(nome.getText(),cognome.getText(),data_nascita.getText(),nazione.getText(), prima_licenza.getText(), GMCheckBox.isSelected(), id_equip, con);
                    add_finanzia finanzia = new add_finanzia(nome.getText(),cognome.getText(), data_nascita.getText());
                    finanzia.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                    finanzia.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    finanzia.setVisible(true);

                    rif_scuderia = Operazioni.find_scuderia(id_equip, new Connessione());
                    Operazioni.register_finanzia(finanzia.getImporto(),finanzia.getData_fin(),rif_scuderia, nome.getText(),cognome.getText(),data_nascita.getText(), con);
                    Utilities.info_message("Pilota inserito con successo");
                } else if(pilotaAMRadioButton.isSelected() && !GMCheckBox.isSelected()){
                    Operazioni.add_pilota_AM(nome.getText(),cognome.getText(),data_nascita.getText(),nazione.getText(), prima_licenza.getText(), false, id_equip, new Connessione());
                    Utilities.info_message("Pilota inserito con successo");
                }

                else if (pilotaPRORadioButton.isSelected()){
                    int nlicenze = 0;
                    int rif_equipaggio = 0;
                        if(licenze.getText().isEmpty() || licenze.getText().isBlank() ) {
                            throw new IllegalArgumentException("numero di licenze inserito invalido");
                        }
                        else {
                            nlicenze = Integer.parseInt(licenze.getText());
                            rif_equipaggio = Integer.parseInt(((ComboItem) equipaggioComboBox.getSelectedItem()).getValue());
                        }
                    Operazioni.add_pilota_PRO(nome.getText(),cognome.getText(),data_nascita.getText(),nazione.getText(),nlicenze,rif_equipaggio, new Connessione());
                        Utilities.info_message("Pilota inserito con successo");
                }
            } catch (Exception ex) {Utilities.error_message(ex); }
            }
        });
    }

    private boolean check_equipaggio(int rif_equipaggio){

        try {
            Connessione con1 = new Connessione();
            PreparedStatement query = con1.getConnessione().prepareStatement(Query.q5);
            query.setObject(1, rif_equipaggio);
            ResultSet temp = query.executeQuery();
            temp.next();
            if (temp.getString("test").equals("true")) {
                con1.getConnessione().close();
                return true;
            } else {
                throw new SQLException("RV3: Un equipaggio deve avere almeno un pilota non gm!");
            }
        } catch (Exception ex) {
            Utilities.error_message(ex);
            return false;
        }
    }


}
