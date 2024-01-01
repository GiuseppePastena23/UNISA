package gui;

import core.Query;
import core.QueryRunner;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;

public class PopUpTable extends JFrame {
    public PopUpTable(Query query) {
        this.setTitle(query.toString());
        this.setIconImage(new ImageIcon("media/weclogo.png").getImage());
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        ResultSet resultSet = QueryRunner.runQuery(query);

        JTable table = null;
        if (resultSet == null) {
            JOptionPane.showMessageDialog(null, "Errore nell'esecuzione della query", "Errore", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // inserisci i dati in una tabella
        try {
            table = new JTable(buildTableModel(resultSet));
            table.setEnabled(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // per mostrare l'intestazione della tabella agggiungerla in uno scrollpane
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);

        panel.add(new JButton("Show query") {{
            this.addActionListener(e -> {
                JOptionPane.showMessageDialog(null, query.query, query.toString(), JOptionPane.INFORMATION_MESSAGE);
            });
        }});


        this.add(panel);
        this.pack();
        this.setVisible(true);
    }


    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);

    }

}
