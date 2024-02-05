package WECPKG;

import WECPKG.Utilities.Utilities;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class displayquery extends JPanel {
    private JTable table1;
    private JPanel subpanel1;
    private JPanel mainpanel;
    private JPanel subpanel2;
    private JButton aggiornaTabellaButton;
    private ResultSet set;

    public displayquery(ResultSet set) {
        this.set = set;
        try {
            showDataInTable(set, table1);
        } catch (SQLException EX) {
            Utilities.error_message(EX);
        }
        mainpanel.add(subpanel1, BorderLayout.NORTH);
        mainpanel.add(subpanel2, BorderLayout.CENTER);
        add(mainpanel);
        setSize(500, 500);


        aggiornaTabellaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    showDataInTable(set, table1);
                } catch (SQLException ex) {
                    Utilities.error_message(ex);
                }
            }
        });
    }

        public int showDataInTable (ResultSet rs, JTable table) throws SQLException {

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            String[] columns = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                columns[i - 1] = rsmd.getColumnName(i);
            }
            DefaultTableModel model = new DefaultTableModel(columns, 0) {
                public boolean isCellEditable(int rowIndex, int mColIndex) {
                    return false;
                }

            };
            int counter = 0;
            while (rs.next()) {
                Object[] rowData = new Object[columns.length];
                for (int j = 0; j < columns.length; j++) {
                    rowData[j] = rs.getObject(j + 1);
                }
                model.addRow(rowData);
                JTableHeader header = table1.getTableHeader();
                table1.setModel(model);
                subpanel1.add(header, BorderLayout.NORTH);
                counter++;
            }
            return counter;
        }
    }

