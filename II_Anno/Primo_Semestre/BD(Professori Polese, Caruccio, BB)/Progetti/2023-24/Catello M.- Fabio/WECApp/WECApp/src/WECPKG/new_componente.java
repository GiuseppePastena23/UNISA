package WECPKG;

import WECPKG.Componenti.Cambio;
import WECPKG.Componenti.Motore;
import WECPKG.Componenti.Telaio;
import WECPKG.Utilities.ComboItem;
import WECPKG.Utilities.Connessione;
import WECPKG.Utilities.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class new_componente extends JPanel{

    private JRadioButton motoreRadioButton;
    private JRadioButton cambioRadioButton;
    private JRadioButton telaioRadioButton;
    private JPanel subpanel1;
    private JPanel subpanel2;
    private JPanel subpanel3;
    private JPanel mainpanel;
    private JButton annullaButton;
    private JButton applicaButton;
    private JComboBox Vettura;
    private JTextField Costo;
    private JTextField Cilindrata;
    private JComboBox TipoMotore;
    private JTextField Cilindri;
    private JTextField Peso;
    private JTextField Materiale;
    private JComboBox Marce;
    private JTextField DataI;
    private JComboBox Costruttore;


    public new_componente() {
        ButtonGroup buttons = new ButtonGroup();
        buttons.add(motoreRadioButton);
        buttons.add(cambioRadioButton);
        buttons.add(telaioRadioButton);
        motoreRadioButton.setSelected(true);

        TipoMotore.setEditable(false);
        Marce.setEditable(false);
        TipoMotore.addItem("Turbo");
        TipoMotore.addItem("Aspirato");
        Marce.addItem(7);
        Marce.addItem(8);

        Marce.setEnabled(false);
        Peso.setText(null);
        Peso.setEditable(false);
        Materiale.setText(null);
        Materiale.setEditable(false);

        mainpanel.add(subpanel1,BorderLayout.NORTH);
        mainpanel.add(subpanel2, null);
        mainpanel.add(subpanel3, BorderLayout.SOUTH);
        add(mainpanel);

        populateComboBoxes();



        motoreRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    Cilindrata.setEditable(true);
                    Cilindri.setEditable(true);
                    TipoMotore.setEnabled(true);

                    Marce.setEnabled(false);
                    Peso.setText(null);
                    Peso.setEditable(false);
                    Materiale.setText(null);
                    Materiale.setEditable(false);
            }
        });

        cambioRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Marce.setEnabled(true);

                Peso.setText(null);
                Peso.setEditable(false);
                Materiale.setText(null);
                Materiale.setEditable(false);
                Cilindri.setText(null);
                Cilindri.setEditable(false);
                Cilindrata.setText(null);
                Cilindrata.setEditable(false);
                TipoMotore.setEnabled(false);
            }
        });

        telaioRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Marce.setEnabled(false);
                Peso.setEditable(true);
                Materiale.setEditable(true);

                Cilindri.setText(null);
                Cilindri.setEditable(false);

                Cilindrata.setText(null);
                Cilindrata.setEditable(false);
                TipoMotore.setEnabled(false);

            }
        });
        applicaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rifvettura = 0;
                double costo = 0;
                try{
                    ComboItem par =  (ComboItem) Vettura.getSelectedItem();
                    if (par!= null) rifvettura = Integer.parseInt(par.getValue());
                    costo = Double.parseDouble(Costo.getText());
                } catch (Exception pe){
                    Utilities.error_message(pe);
                }
                if(motoreRadioButton.isSelected()){
                 if(!Operazioni.check_componente(rifvettura, Motore.class, new Connessione())){
                     int cilindrata = Integer.parseInt(Cilindrata.getText());
                     int cilindri = Integer.parseInt(Cilindri.getText());
                     Operazioni.register_componente(new Motore(costo,DataI.getText(),rifvettura,Costruttore.getSelectedItem().toString(),cilindrata,cilindri,TipoMotore.getSelectedItem().toString()),new Connessione());
                    } else {
                     Utilities.info_message("Il tipo di componente selezionato è già stato inserito nella vettura, Annullo l'inserimento...");}
                }
                else if(telaioRadioButton.isSelected()){
                    if(!Operazioni.check_componente(rifvettura, Telaio.class, new Connessione())){
                       double peso = Double.parseDouble(Peso.getText());
                       Operazioni.register_componente(new Telaio(costo, DataI.getText(), Costruttore.getSelectedItem().toString(), rifvettura, peso, Materiale.getText()), new Connessione());

                    } else {
                        Utilities.warn_message("Il tipo di componente selezionato è già stato inserito nella vettura, Annullo l'inserimento...");}
                }
                else if(cambioRadioButton.isSelected()){
                    if(!Operazioni.check_componente(rifvettura, Cambio.class, new Connessione())){
                        Operazioni.register_componente(new Cambio(costo,rifvettura, Costruttore.getSelectedItem().toString(), DataI.getText(), Marce.getSelectedItem().toString()), new Connessione());

                    } else {
                        Utilities.warn_message("Il tipo di componente selezionato è già stato inserito nella vettura, Annullo l'inserimento...");}

                }
                }

        });
    }

    private void populateComboBoxes(){
        try {
            Connessione con = new Connessione();
            ResultSet temp = con.getStatement().executeQuery(Query.querycomponente1);
            while(temp.next()) {
                Vettura.addItem(new ComboItem(
                        temp.getString("id_gara") +" "+ temp.getString("modello") +" "+ temp.getString("rif_scuderia"),
                        temp.getString("id_gara")));
            }
            temp = con.getStatement().executeQuery(Query.querycomponente2);
            while(temp.next()){
                Costruttore.addItem(temp.getString("ragione_sociale"));
            }
            con.getConnessione().close();

        } catch(Exception ex) {Utilities.error_message(ex);}

    }
}

