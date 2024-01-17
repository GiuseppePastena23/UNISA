package core;
import java.sql.*;

public class QueryRunner {
    public static final String nomeDB = "Campionato";
    public static final String username = "pasquale";
    public static final String password = "pasquale";
    public static final String url = "jdbc:mariadb://localhost:3306/" + nomeDB; // o jdbc:mysql://localhost:3306/
    public static final String driver = "org.mariadb.jdbc.Driver"; // o com.mysql.cj.jdbc.Driver

    public static ResultSet runQuery(Query interrogazione) {
        Connection conn = null;

        if (interrogazione.query == null) {
            return null;
        }

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Connessione fallita");
            return null;
        }
        try {
            Statement runner = conn.createStatement();
            ResultSet result = runner.executeQuery(interrogazione.query);
            conn.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Errore nell'interrogazione");
        }
        return null;
    }

    public static boolean testConnection() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Connessione fallita");
            return false;
        }
    }

}
