package WECPKG;

import WECPKG.Componenti.Cambio;
import WECPKG.Componenti.Componente;
import WECPKG.Componenti.Motore;
import WECPKG.Componenti.Telaio;
import WECPKG.Utilities.Connessione;
import WECPKG.Utilities.Utilities;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class new_vettura extends JPanel {
    private JPanel panel1;
    private JTextField id_gara;
    private JTextField modello;
    private JButton cancellaButton;
    private JButton applicaButton;
    private JButton aggiungiComponenteButton;
    private JComboBox scuderiacombobox;
    private JTable table1;
    private JButton rimuoviComponenteButton;

    private ArrayList<Componente> componenteArrayList = new ArrayList<>();

    public new_vettura(){
        try {
            Connessione con = new Connessione();
            ResultSet temp = con.getStatement().executeQuery(Query.q9);
            int i = 1;
            while(temp.next()){
                scuderiacombobox.addItem(temp.getString("nome_scuderia"));
            }
            con.getConnessione().close();
            add(panel1, BorderLayout.BEFORE_FIRST_LINE);
        } catch(Exception e){ Utilities.error_message(e);
        }

        aggiungiComponenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String parsed = id_gara.getText();
                int test;
                try {
                    if (parsed.isEmpty() || parsed.isBlank())
                        throw new IllegalArgumentException("Per favore indica l'id_gara per procedere.");
                    else {
                        test = Integer.parseInt(id_gara.getText());
                    }
                    add_componente comp = new add_componente(test);
                    comp.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                    comp.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    comp.setVisible(true);
                    comp.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            super.windowClosed(e);
                            componenteArrayList.add(comp.getComponente());
                            showDataInTable(componenteArrayList,table1);
                        }
                    });

                } catch (Exception ex) {Utilities.error_message(ex);}
            }
        });
        applicaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idg = id_gara.getText();
                try {
                    if (
                            hasMoreInstances(componenteArrayList, Telaio.class) ||
                                    hasMoreInstances(componenteArrayList, Motore.class) ||
                                    hasMoreInstances(componenteArrayList, Cambio.class)
                    ) { throw new IllegalArgumentException("RV2: Puoi aggiungere solo un componente per tipo!"); }
                    if (idg.isEmpty() || idg.isBlank()) throw new IllegalArgumentException("Argomento Illegale");
                    else {
                        Operazioni.register_vettura(Integer.parseInt(idg), modello.getText(), scuderiacombobox.getSelectedItem().toString(), componenteArrayList, new Connessione());
                    }
                } catch (Exception ex) {Utilities.error_message(ex);}
            }
        });
        rimuoviComponenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!table1.getSelectionModel().isSelectionEmpty()){
                componenteArrayList.remove(table1.getSelectedRow());
                showDataInTable(componenteArrayList, table1);
                }
            }
        });
    }

    private void showDataInTable(ArrayList<Componente> listOfComponenti, JTable table){
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Tipo", "Costo"}, 0);
        for(Componente componente:listOfComponenti){
            model.addRow(new Object[]{componente.getClass().getSimpleName(), componente.getCosto()});
        }
        table.setModel(model);
    }

    private static boolean hasMoreInstances(ArrayList<Componente> components, Class<? extends Componente> subclass) {
        HashMap<Class<? extends Componente>, Integer> subclassCounts = new HashMap<>();
        for (Componente animal : components) {
            Class<? extends Componente> clazz = animal.getClass();
            int count = subclassCounts.getOrDefault(clazz, 0);
            subclassCounts.put(clazz, count + 1);
        }
        var subclassCount = subclassCounts.get(subclass);
        if (subclassCount == null) return false;
        else return subclassCount > 1;
    }


}
