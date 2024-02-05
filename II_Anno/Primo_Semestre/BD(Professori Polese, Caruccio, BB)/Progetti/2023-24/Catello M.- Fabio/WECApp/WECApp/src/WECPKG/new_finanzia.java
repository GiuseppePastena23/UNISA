package WECPKG;

import WECPKG.Utilities.ComboItem;
import WECPKG.Utilities.Connessione;
import WECPKG.Utilities.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class new_finanzia extends JPanel {
    private JPanel mainpanel;
    private JPanel subpanel1;
    private JComboBox scuderiacomboBox;
    private JComboBox PiloticomboBox;
    private JTextField importotextfield;
    private JTextField datatextfield;
    private JPanel subpanel2;
    private JButton applicaButton;
    private JButton annullaButton;

    public new_finanzia() {

        populatePilota(populateScuderia());
        mainpanel.add(subpanel1, BorderLayout.CENTER);
        mainpanel.add(subpanel2, BorderLayout.SOUTH);
        add(mainpanel);
        setSize(222, 139);



        applicaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            double importo = 0;
            ComboItem par;
            int rif_equipaggio = 0;
            ArrayList<String> temp = new ArrayList<String>();

            try {
                par = (ComboItem) PiloticomboBox.getSelectedItem();
                temp = par.getValues();
                importo = Double.parseDouble(importotextfield.getText());
                rif_equipaggio = Integer.parseInt(temp.get(3));
            } catch (Exception ex) { Utilities.error_message(ex); }
             Operazioni.register_finanzia(importo, datatextfield.getText(),Operazioni.find_scuderia(rif_equipaggio,new Connessione()),temp.get(0), temp.get(1), temp.get(2), new Connessione());
            }
        });
        scuderiacomboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                populatePilota(new Connessione());
            }
        });
    }
    private Connessione populateScuderia(){
        scuderiacomboBox.removeAllItems();
        try{
            Connessione con = new Connessione();
            PreparedStatement query = con.getConnessione().prepareStatement(Query.queryfinanziamento);
            ResultSet result = query.executeQuery();
            while(result.next()){
                scuderiacomboBox.addItem(result.getString("nome_scuderia"));
            }
            return con;
        }
        catch(Exception ex) {Utilities.error_message(ex); return null;}
    }

    private void populatePilota(Connessione con){
        PiloticomboBox.removeAllItems();
        try {
         PreparedStatement query = con.getConnessione().prepareStatement(Query.queryfinanziamento1);
         query.setObject(1,scuderiacomboBox.getSelectedItem());
         ResultSet result = query.executeQuery();
            while (result.next()){
                ArrayList<String> list = new ArrayList<>();
                list.add(result.getString(1));
                list.add(result.getString(2));
                list.add(result.getString(3));
                list.add(result.getString(4));
                PiloticomboBox.addItem(new ComboItem(list.get(0)+" "+list.get(1)+" "+list.get(2),list));
            }
        } catch(Exception e){
            Utilities.error_message(e);
        }


    }
}
