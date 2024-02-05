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

public class new_partecipazione extends JPanel {
    private JPanel mainpanel;
    private JPanel subpanel1;
    private JPanel subpanel2;
    private JComboBox vetturacomboBox;
    private JComboBox garacomboBox;
    private JButton applicaButton;
    private JButton annullaButton;


    public new_partecipazione(){

        populateGara(populateVettura());
        mainpanel.add(subpanel1, BorderLayout.CENTER);
        mainpanel.add(subpanel2, BorderLayout.SOUTH);
        add(mainpanel);
        setSize(183, 147);


        applicaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codice_gara = 0;
                int rif_vettura = 0;
                try{
                    ComboItem combovettura = (ComboItem) vetturacomboBox.getSelectedItem();
                    ComboItem combogara = (ComboItem) garacomboBox.getSelectedItem();
                    rif_vettura = Integer.parseInt(combovettura.getValue());
                    codice_gara = Integer.parseInt(combogara.getValue());
                    } catch(Exception ex){
                    Utilities.error_message(ex);
                }
                if(!Operazioni.check_partecipazione(rif_vettura,codice_gara, new Connessione())) { //N.B: Questo controllo è parzialmente ridondante in quanto lo schema risolve a priori RV2,
                    Operazioni.sign_vettura(rif_vettura, codice_gara, new Connessione());
                } else {
                    Utilities.warn_message("1. La vettura selezionata ha già una partecipazione nella gara selezionata!\n 2. La vettura selezionata non ha un equipaggio con almeno un pilota!");
                }
            }
        });
    }

    private Connessione populateVettura(){
        vetturacomboBox.removeAllItems();
        try{
            Connessione con = new Connessione();
            PreparedStatement query = con.getConnessione().prepareStatement(Query.q2);
            ResultSet result = query.executeQuery();
            while(result.next()){
                vetturacomboBox.addItem(new ComboItem(result.getString(1) +" "+ result.getString(2) +" "+ result.getString(3),result.getString(1)));
            }
            return con;
        }
        catch(Exception ex) {Utilities.error_message(ex); return null;}
    }

    private void populateGara(Connessione con){
        garacomboBox.removeAllItems();
        try{
            PreparedStatement query = con.getConnessione().prepareStatement(Query.q3);
            ResultSet result = query.executeQuery();
            while(result.next()){
                garacomboBox.addItem(new ComboItem(result.getString(2) +" "+ result.getString(3), result.getString(1)));
            }
            con.getConnessione().close();
        }
        catch(Exception ex) {Utilities.error_message(ex);}
    }
}
