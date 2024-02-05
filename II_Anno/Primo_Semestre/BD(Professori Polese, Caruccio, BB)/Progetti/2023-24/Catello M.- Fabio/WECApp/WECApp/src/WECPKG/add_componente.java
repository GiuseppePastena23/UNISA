package WECPKG;

import WECPKG.Componenti.Cambio;
import WECPKG.Componenti.Componente;
import WECPKG.Componenti.Motore;
import WECPKG.Componenti.Telaio;
import WECPKG.Utilities.Connessione;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class add_componente extends JDialog {
    private JPanel mainpanel;
    private JPanel subpanel1;
    private JRadioButton motoreRadioButton;
    private JRadioButton cambioRadioButton;
    private JRadioButton telaioRadioButton;
    private JPanel subpanel3;
    private JButton annullaButton;
    private JButton applicaButton;
    private JPanel subpanel2;
    private JComboBox Vettura;
    private int rif_vettura;
    private JTextField Costo;
    private JTextField Cilindrata;
    private JComboBox TipoMotore;
    private JTextField Cilindri;
    private JTextField Peso;
    private JTextField Materiale;
    private JComboBox Marce;
    private JTextField DataI;
    private JComboBox Costruttore;
    private JPanel panel1;

    private Componente comp ;


    public void setComponente(Componente e){
        this.comp = e;
    }

    public Componente getComponente() {
        return comp;
    }

    public add_componente(int rif_vettura) {
        this.rif_vettura = rif_vettura;
        setSize(286, 428);
        ButtonGroup buttons = new ButtonGroup();
        buttons.add(motoreRadioButton);
        buttons.add(cambioRadioButton);
        buttons.add(telaioRadioButton);
        motoreRadioButton.setSelected(true);

        Vettura.setEnabled(false);
        Vettura.addItem(this.rif_vettura);
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

        mainpanel.add(subpanel1, BorderLayout.NORTH);
        mainpanel.add(subpanel2, null);
        mainpanel.add(subpanel3, BorderLayout.SOUTH);
        panel1.add(mainpanel);
        add(panel1, BorderLayout.CENTER);


        try {
            Connessione con = new Connessione();
            ResultSet temp = con.getStatement().executeQuery(Query.q1);
            while (temp.next()) {
                Costruttore.addItem(temp.getString("ragione_sociale"));
            }
            con.getConnessione().close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Errore: " + ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
        }

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
                String Data = DataI.getText();
                double costo = 0;
                if(cambioRadioButton.isSelected()){
                    if (Data.isBlank() || Data.isEmpty() || Costo.getText().isEmpty()|| Costo.getText().isBlank()) throw new IllegalArgumentException("Input Errati");
                    else {
                        costo = Double.parseDouble(Costo.getText());
                    }
                    setComponente(new Cambio(costo, rif_vettura, Costruttore.getSelectedItem().toString(),Data,Marce.getSelectedItem().toString()));
                }
                else if(telaioRadioButton.isSelected()){
                    double peso = 0;
                    if (Data.isBlank() || Data.isEmpty() || Costo.getText().isEmpty()|| Costo.getText().isBlank() || Peso.getText().isBlank() || Peso.getText().isEmpty()) throw new IllegalArgumentException("Input Errati");
                    else {
                        costo = Double.parseDouble(Costo.getText());
                        peso = Double.parseDouble(Peso.getText());
                    }
                    setComponente(new Telaio(costo, Data, Costruttore.getSelectedItem().toString(), rif_vettura, peso, Materiale.getText()));
                }
                else if (motoreRadioButton.isSelected()){
                    int cilindrata = 0;
                    int cilindri = 0;
                    if (Data.isBlank() || Data.isEmpty() || Costo.getText().isEmpty()|| Costo.getText().isBlank() || Cilindrata.getText().isEmpty() || Cilindrata.getText().isBlank() || Cilindri.getText().isBlank() || Cilindri.getText().isEmpty()) throw new IllegalArgumentException("Input Errati");
                    else {
                        costo = Double.parseDouble(Costo.getText());
                        cilindrata = Integer.parseInt(Cilindrata.getText());
                        cilindri = Integer.parseInt(Cilindri.getText());
                    }
                    setComponente(new Motore(costo,Data, rif_vettura, Costruttore.getSelectedItem().toString(), cilindrata, cilindri, TipoMotore.getSelectedItem().toString()));
                }
                    dispose();
            }
        });
    }
}