package WECPKG;

import javax.swing.*;
import java.sql.*;
public class Connessione {
        private Connection con;
        private Statement statement;
        public Connessione()
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Campionato","root", "rootarded");
                statement = con.createStatement();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"\"Errore: \"+ e.getMessage()","ERRORE", JOptionPane.ERROR_MESSAGE);
            }
        }

        public Connection getConnessione(){
            return con;
        }

        public Statement getStatement(){
            return statement;
        }
    }


