package WECPKG;

import WECPKG.Utilities.ComboItem;
import WECPKG.Utilities.Connessione;
import WECPKG.Utilities.Utilities;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class new_risultati extends JPanel {
    private JPanel mainpanel;
    private JPanel subpanel2;
    private JPanel subpanel1;
    private JTable table1;
    private JButton selezionaButton;
    private JComboBox garacomboBox;
    private JCheckBox selezionaTuttiCheckBox;

    public new_risultati() {
        populateTable(populateGara());
        mainpanel.add(subpanel1, BorderLayout.NORTH);
        mainpanel.add(subpanel2, BorderLayout.CENTER);
        add(mainpanel);
        setSize(500, 500);


        selezionaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                populateTable(new Connessione());
            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Point point = e.getPoint();
                int row = table1.rowAtPoint(point);
                if (e.getClickCount() == 2 && table1.getSelectedRow() != -1) {
                    ComboItem combo = (ComboItem) garacomboBox.getSelectedItem();
                    add_risultato res = new add_risultato(Utilities.tryIntParse(Utilities.tryCastToString(table1.getValueAt(row,1))), Utilities.tryIntParse(combo.getValue()));
                    res.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                    res.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    res.setVisible(true);
                    res.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            super.windowClosed(e);
                        }
                    });
                }

            }
        });
    }

    private Connessione populateGara(){

        try{
            Connessione connessione = new Connessione();
            PreparedStatement query = connessione.getConnessione().prepareStatement(Query.q6);
            ResultSet result = query.executeQuery();
            while(result.next()){
                garacomboBox.addItem(new ComboItem(result.getString(2) +" "+ result.getString(3), result.getString(1)));
            }
            return connessione;
        }
        catch(Exception ex) {Utilities.error_message(ex); return null;}
    }

    private int populateTable(Connessione conn) {
        int result = 0;

        try {
            PreparedStatement query;
            if (!selezionaTuttiCheckBox.isSelected()){
                query = conn.getConnessione().prepareStatement(Query.q7);
            }
             else { query = conn.getConnessione().prepareStatement(Query.q8); }

            ComboItem combo = (ComboItem) garacomboBox.getSelectedItem();
            int codice_gara = Integer.parseInt(combo.getValue());

            query.setObject(1, codice_gara);
            ResultSet set = query.executeQuery();
            result = showDataInTable(set, table1);


        } catch (SQLException e) {
            Utilities.error_message(e);
            return result;
        }
        return result;
    }

    private int showDataInTable(ResultSet rs, JTable table) throws SQLException {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"ID","Vettura", "Punti","Posizione","MotivoRitiro"}, 0) {
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }

        };
        int counter = 0;
        while (rs.next()) {
            int ID = rs.getInt(1);
            String vettura =  rs.getString(2) +" " + rs.getString(3);
            int punti = rs.getInt(4);
            int posizione = rs.getInt(5);
            String ritiro = rs.getString(6);

            model.addRow(new Object[]{ID,vettura, punti,posizione,ritiro});
            counter++;
        }

        JTableHeader header = table1.getTableHeader();
        table1.setModel(model);
        subpanel1.add(header, BorderLayout.NORTH);
        return counter;

    }

}
