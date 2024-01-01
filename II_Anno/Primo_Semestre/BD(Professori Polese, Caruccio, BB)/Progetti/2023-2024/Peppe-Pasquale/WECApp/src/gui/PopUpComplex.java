package gui;

import core.Queries;
import core.Query;
import core.QueryRunner;

import javax.swing.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * Usare questa classe solo per le query complesse
 */
public class PopUpComplex {

    public PopUpComplex(Query query) {
        switch (query.opNumber) {
            case 2 -> query2Behaviour();
            case 3 -> query3Behaviour();
            case 4 -> query4Behaviour();
            case 7 -> query7Behaviour();
            default -> {
                System.err.println("Query complessa non implementata");
                System.exit(1);
            }
        }
    }

    private static String inputDialog(String message, String title) {
        return JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
    }

    private static String inputDialogOBBLIGATORIO(String message, String title) throws IOException {
        String input = inputDialog(message, title);
        if (input == null || input.isBlank()) {
            throw new IOException("Operazione annullata");
        }
        return input;
    }

    private static void successDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "Successo", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void errorDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "Errore", JOptionPane.ERROR_MESSAGE);
    }

    private static boolean confirmDialog(String message, String titolo) {
        int yesno = JOptionPane.showConfirmDialog(null, message, titolo, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return yesno == JOptionPane.YES_OPTION;
    }


    ////////////////////////////////// OP2 ///////////////////////////////////////////////

    /**
     * <h1>OP2 RIASSUNTO</h1>
     * <p>
     * Inserimento dei dati di un’autovettura, compresi i componenti di cui è composta
     * faccio inserire i dati della vettura in ogni caso, controllo che sia andata a buon fine
     * poi chiedo se l'utente vuole inserire un componente
     * gli faccio mettere i dati del componente anche in base al TIPO moto/cambio/telaio
     * prima di inserire il componente controllo che la vettura non abbia gia' un componente di quel tipo
     * se la query ritorna qualcosa, allora il componente è già montato su una vettura e non può essere montato
     * se la query non ritorna nulla, allora il componente non è montato e si procede al montaggio
     * aumenta di conseguenza il contatore dei componenti prodotti dal costruttore
     * </p>
     * <p>
     * query usate: <br>
     * <ul>
     * <li>inserimento vettura: <br>
     *   INSERT INTO Vettura (nGara, Modello, Data_acquisto, Prezzo, Nome_Scuderia) VALUES (?, ?, ?, ?, ?);
     * </li>
     *
     * <li>controllo se la vettura ha gia' un componente di quel tipo <br>
     *   SELECT Tipo, nGara_Vettura FROM Componente WHERE nGara_Vettura = ? AND Tipo = ?;
     * </li>
     * <li> inserimento componente <br>
     *   INSERT INTO Componente (Costo, Tipo, Cilindrata_motore, nCilindri_motore, Tipo_motore, Materiale_telaio, Peso_telaio, nMarce_cambio, Ragione_sociale_Costruttore, nGara_Vettura) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
     * </li>
     * <li> aggiornamento contatore componenti prodotti dal costruttore <br>
     *   UPDATE Costruttore SET nComponenti_forniti = nComponenti_forniti + 1 WHERE Ragione_sociale = ?;
     * </li>
     * </ul>
     */
    public void query2Behaviour() {
        //* Inserimento della vettura
        String nGara = null;
        try {
            nGara = createVettura();
        } catch (SQLException e) {
            errorDialog(e.toString());
            return;
        } catch (IOException ignored) {
            return;
        }

        //* chiedi se l'utente vuole CREARE un componente con un messaggio pop-up
        boolean keepGoing; // continuare a chiedere se vuole creare un componente
        while ((keepGoing = confirmDialog("Vuoi produrre un componente da montare sulla vettura appena creata?", "OP2 - Creazione componente")) && (nGara != null)) {
            try {
                montaComponente(nGara);
            } catch (IOException ignored) {
                return;
            } catch (Exception e) {
                errorDialog(e.toString());
                return;
            }
        }
    }

    private static String createVettura() throws IOException, SQLException {
        final String titoloOperazione = "OP2 - Creazione vettura";

        //* Inserimento nuova vettura
        // INSERT INTO Vettura (nGara, Modello, Data_acquisto, Prezzo, Nome_Scuderia) VALUES (?, ?, ?, ?, ?);

        //* chiedo i dati della vettura
        // CAMPI OBBLIGATORI
        String nGara, modello, dataAcquisto, prezzo, nomeScuderia;
        nGara = inputDialogOBBLIGATORIO("Inserisci il numero di gara INT", titoloOperazione);
        modello = inputDialogOBBLIGATORIO("Inserisci il modello STRING", titoloOperazione);
        dataAcquisto = inputDialogOBBLIGATORIO("Inserisci la data di acquisto (YYYY-MM-DD)", titoloOperazione);
        prezzo = inputDialogOBBLIGATORIO("Inserisci il prezzo FLOAT dot separated", titoloOperazione);
        nomeScuderia = inputDialogOBBLIGATORIO("Inserisci il nome della scuderia STRING", titoloOperazione);

        //* eseguo la query
        // INSERT INTO Vettura (nGara, Modello, Data_acquisto, Prezzo, Nome_Scuderia) VALUES (?, ?, ?, ?, ?);
        Query queryCreateVettura = new Query(0, "Inserimento nuova vettura", "INSERT INTO Vettura (nGara, Modello, Data_acquisto, Prezzo, Nome_Scuderia) " +
                "VALUES (" + nGara + ", '" + modello + "', '" + dataAcquisto + "', " + prezzo + ", '" + nomeScuderia + "');", true);
        ResultSet resultSet = QueryRunner.runQuery(queryCreateVettura);
        if (resultSet == null) {
            throw new SQLException("Errore nell'esecuzione della query\n" + queryCreateVettura.query);
        } else {
            successDialog("Query eseguita con successo\n" + queryCreateVettura.query);
        }
        return nGara;
    }

    private static void montaComponente(String nGara) throws Exception {
        String titoloOperazione = "OP2 - Montaggio componente";
        ResultSet resultSet;
        //* Inserimento nuovo componente
        // INSERT INTO Componente (Costo, Tipo, Cilindrata_motore, nCilindri_motore, Tipo_motore, Materiale_telaio, Peso_telaio, nMarce_cambio, Ragione_sociale_Costruttore, nGara_Vettura) VALUES
        //         (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
        // CAMPI OBBBLIGATORI
        String ragioneSocialeCostruttore, costo, tipo;
        ragioneSocialeCostruttore = inputDialogOBBLIGATORIO("Inserisci la ragione sociale del costruttore STRING", titoloOperazione);
        costo = inputDialogOBBLIGATORIO("Inserisci il costo  FLOAT dot separated", titoloOperazione);
        tipo = inputDialogOBBLIGATORIO("Inserisci il tipo ENUM={Motore, Cambio, Telaio}", titoloOperazione);
        if (!(tipo.equals("Motore") || tipo.equals("Cambio") || tipo.equals("Telaio"))) {
            throw new Exception("Tipo di componente non riconosciuto");
        }

        // campi opzionali
        String cilindrataMotore = null;
        String nCilindriMotore = null;
        String tipoMotore = null;
        String materialeTelaio = null;
        String pesoTelaio = null;
        String nMarceCambio = null;

        // In base al tipo di componente inserisco i dati necessari
        switch (tipo) {
            case "Motore" -> {
                cilindrataMotore = inputDialogOBBLIGATORIO("Inserisci la cilindrata del motore INT", titoloOperazione);
                nCilindriMotore = inputDialogOBBLIGATORIO("Inserisci il numero di cilindri del motore INT", titoloOperazione);
                tipoMotore = inputDialogOBBLIGATORIO("Inserisci il tipo del motore STRING", titoloOperazione);
            }
            case "Cambio" -> {
                nMarceCambio = inputDialogOBBLIGATORIO("Inserisci il numero di marce del cambio INT", titoloOperazione);
            }
            case "Telaio" -> {
                materialeTelaio = inputDialogOBBLIGATORIO("Inserisci il materiale del telaio STRING", titoloOperazione);
                pesoTelaio = inputDialogOBBLIGATORIO("Inserisci il peso del telaio  FLOAT dot separated", titoloOperazione);
            }
        }

        //* Controllo se non la macchina non ha gia' un componente di quel tipo
        // se la query ritorna qualcosa, allora il componente è già montato su una vettura e non può essere montato
        // SELECT Tipo, nGara_Vettura FROM Componente WHERE nGara_Vettura = ? and Tipo = ?
        Query queryCheckComponente = new Query(0, "Controllo componente gia montato", "SELECT Tipo, nGara_Vettura " +
                "FROM Componente WHERE nGara_Vettura = " + nGara + " AND Tipo = '" + tipo + "';", true);
        resultSet = QueryRunner.runQuery(queryCheckComponente);
        if (resultSet == null) {
            throw new SQLException("Errore nell'esecuzione della query\n" + queryCheckComponente.query);
        }
        if (resultSet.next()) {
            throw new Exception("Errore: la vettura ha gia' un componente di tipo " + tipo);
        }


        // la vettura non ha il componente di quel tipo, si procede al montaggio
        Query queryCreateComponente = new Query(0, "Inserimento nuovo componente", "INSERT INTO Componente (Costo, Tipo, \n" +
                "Cilindrata_motore, nCilindri_motore, Tipo_motore, " +
                "\nMateriale_telaio, Peso_telaio, " +
                "\nnMarce_cambio, " +
                "\nRagione_sociale_Costruttore, nGara_Vettura) " +
                "\nVALUES (" + costo + ", '" + tipo + "', \n" +
                cilindrataMotore + ", " + nCilindriMotore + ", '\n" + tipoMotore + "', \n'" + materialeTelaio + "', " + pesoTelaio + ",\n " + nMarceCambio + ", \n'" + ragioneSocialeCostruttore + "', " + nGara + ");", true);
        resultSet = QueryRunner.runQuery(queryCreateComponente);
        if (resultSet == null) {
            throw new SQLException("Errore nell'esecuzione della query\n" + queryCreateComponente.query);
        }
        successDialog("Query eseguita con successo\n" + queryCreateComponente.query);

        // aumentare il contatore dei componenti prodotti dal costruttore
        // UPDATE Costruttore SET nComponenti_forniti = nComponenti_forniti + 1 WHERE Ragione_sociale = ragioneSocialeCostruttore;
        Query queryUpdateCostruttore = new Query(0, "Aggiornamento contatore componenti prodotti dal costruttore", "UPDATE Costruttore SET nComponenti_forniti = nComponenti_forniti + 1 WHERE Ragione_sociale = '" + ragioneSocialeCostruttore + "';", true);
        resultSet = QueryRunner.runQuery(queryUpdateCostruttore);
        if (resultSet == null) {
            throw new SQLException("Non e' possibile aumentare il numero di componenti forniti\n" + queryUpdateCostruttore.query);
        }
        successDialog("Componenti forniti da " + ragioneSocialeCostruttore + "aumentati \n" + queryUpdateCostruttore.query);
        return;
    }

    ////////////////////////////// FINE OP2 ///////////////////////////////////////////////


    ////////////////////////////////// OP3 ///////////////////////////////////////////////
    // Aggiunta di un nuovo pilota a un equipaggio
    // controllare che l'equipaggio non sia tutto composto da GD
    public void query3Behaviour() {
        try {
            createPilota();
        } catch (IOException ignored) {
            return;
        }
        catch (Exception e) {
            errorDialog(e.toString());
        }
    }

    private static void createPilota() throws Exception {
        String titoloOperazione = "OP3 - Creazione pilota";
        boolean canBeInserted; // automaticamente valido per PRO e AM
        // INSERT INTO Pilota (SSID, Nome, Cognome, DDN, Nazionalita, Tipo, Quota, nLicenze, Data_prima_licenza, nGara_Vettura) VALUES
        // chiedo i dati del pilota
        String SSID, nome, cognome, DDN, nazionalita, tipo, nGaraVettura; // CAMPI OBBLIGATORI
        String quota = null, nLicenze = null, dataPrimaLicenza = null; // CAMPI OPZIONALI

        SSID = inputDialogOBBLIGATORIO("Inserisci il SSID STRING", titoloOperazione);
        nome = inputDialogOBBLIGATORIO("Inserisci il nome STRING", titoloOperazione);
        cognome = inputDialogOBBLIGATORIO("Inserisci il cognome STRING", titoloOperazione);
        DDN = inputDialogOBBLIGATORIO("Inserisci la data di nascita (YYYY-MM-DD)", titoloOperazione);
        nazionalita = inputDialogOBBLIGATORIO("Inserisci la nazionalita' (PAESE) STRING", titoloOperazione);
        nGaraVettura = inputDialogOBBLIGATORIO("Inserisci il numero di gara della vettura INT", titoloOperazione);
        tipo = inputDialogOBBLIGATORIO("Inserisci il tipo ENUM={GD, AM, PRO}", titoloOperazione);

        switch (tipo) {
            case "PRO" -> {
                nLicenze = inputDialogOBBLIGATORIO("Inserisci il numero di licenze INT", titoloOperazione);
            }
            case "AM" -> {
                dataPrimaLicenza = inputDialogOBBLIGATORIO("Inserisci la data della prima licenza (YYYY-MM-DD)", titoloOperazione);
            }
            case "GD" -> {
                dataPrimaLicenza = inputDialogOBBLIGATORIO("Inserisci la data della prima licenza (YYYY-MM-DD)", titoloOperazione);
                quota = inputDialogOBBLIGATORIO("Inserisci la quota FLOAT dot separated", titoloOperazione);
            }
            default -> {
                throw new Exception("Tipo di pilota non riconosciuto");
            }
        }

        // se si vuole inserire un GD controllo che l'equipaggio non sia tutto composto da GD
        if (tipo.equals("GD") && isAllGD(nGaraVettura)) {
            throw new Exception("Non e' possibile inserire un GD in un equipaggio composto solo da GD");
        }

        // si puo' inserire il pilota
        Query queryCreatePilota = new Query(0, "Inserimento nuovo pilota", "INSERT INTO Pilota (SSID, Nome, Cognome, DDN, Nazionalita, Tipo, Quota, nLicenze, Data_prima_licenza, nGara_Vettura) \n" +
                "VALUES ('" + SSID + "', '" + nome + "', '" + cognome + "', '" + DDN + "', '" + nazionalita + "', '" + tipo + "', " + quota + ", " + nLicenze + ", '" + dataPrimaLicenza + "', " + nGaraVettura + ");", true);
        ResultSet resultSet = QueryRunner.runQuery(queryCreatePilota);
        if (resultSet == null) {
            throw new SQLException("Errore nell'esecuzione della query\n" + queryCreatePilota.query);
        } else {
            successDialog("Query eseguita con successo\n" + queryCreatePilota.query);
        }
    }


    // se si vuole inserire un GD controllo che l'equipaggio non sia tutto composto da GD
    /* ! Se il risultato è vuoto non si puo inserire il GD !
    SELECT Pilota.Cognome, Pilota.Nome, Pilota.Tipo, Pilota.nGara_Vettura
    FROM Pilota
    INNER JOIN Vettura ON Vettura.nGara = Pilota.nGara_Vettura
    WHERE (Tipo = 'PRO' OR Tipo = 'AM') AND nGara_Vettura = ?;
     */
    private static boolean isAllGD(String nGaraVettura) throws SQLException {
    Query queryCheckEquipaggio = new Query(0, "Controllo equipaggio", "SELECT Pilota.Cognome, Pilota.Nome, Pilota.Tipo, Pilota.nGara_Vettura\n" +
                "FROM Pilota\n" +
                "INNER JOIN Vettura ON Vettura.nGara = Pilota.nGara_Vettura\n" +
                "WHERE (Tipo = 'PRO' OR Tipo = 'AM') AND nGara_Vettura = " + nGaraVettura + ";", true);
        ResultSet resultSet = QueryRunner.runQuery(queryCheckEquipaggio);
        if (resultSet == null) {
            throw new SQLException("Errore nell'esecuzione della query\n" + queryCheckEquipaggio.query);
        }

        return !resultSet.next(); // se il risultato è vuoto non si puo inserire il GD
    }

    ////////////////////////////// FINE OP3 ///////////////////////////////////////////////


    ////////////////////////////// OP4 ///////////////////////////////////////////////
    // Aggiunta di un nuovo pilota a un equipaggio
    public void query4Behaviour() {
        try {
            addFinanziamento();
        } catch (IOException ignored) {}
        catch (SQLException e) {
            errorDialog(e.toString());
        }
    }

    private static void addFinanziamento() throws IOException, SQLException {
        String titoloOperazione = "OP4 - Aggiunta finanziamento";
        ResultSet resultSet;
        // UPDATE Pilota SET Quota = Quota + ? WHERE SSID = ? AND Tipo = 'GD';
        String SSID, quota;
        SSID = inputDialogOBBLIGATORIO("Inserisci il SSID STRING", titoloOperazione);
        quota = inputDialogOBBLIGATORIO("Inserisci la quota FLOAT dot separated", titoloOperazione);

        // controllo che il pilota sia GD
        Query queryCheckPilota = new Query(0, "Controllo pilota", "SELECT * FROM Pilota WHERE SSID = '" + SSID + "' AND Tipo = 'GD';", true);
        resultSet = QueryRunner.runQuery(queryCheckPilota);
        if (resultSet == null) {
            throw new SQLException("Errore nell'esecuzione della query\n" + queryCheckPilota.query);
        }
        if (!resultSet.next()) {
            throw new IOException("Il pilota non e' GD");
        }

        // il pilota e' GD, aggiungo il finanziamento
        Query queryAddFinanziamento = new Query(0, "Aggiunta finanziamento", "UPDATE Pilota\n " +
        "SET Quota = Quota + " + quota + " WHERE SSID = '" + SSID + "' AND Tipo = 'GD';", true);
        resultSet = QueryRunner.runQuery(queryAddFinanziamento);
        if (resultSet == null) {
            throw new SQLException("Errore nell'esecuzione della query\n" + queryAddFinanziamento.query);
        } else {
            successDialog("Query eseguita con successo\n" + queryAddFinanziamento.query);
        }
    }

    ////////////////////////////// FINE OP4 ///////////////////////////////////////////////

    ////////////////////////////// OP7 ///////////////////////////////////////////////
    // Verifica della possibilità di montare un componente su una vettura
    public void query7Behaviour() {
        try {
            if (canMount()) {
                successDialog("E' possibile montare il componente");
            } else {
                errorDialog("Non e' possibile montare il componente");
            }
        } catch (IOException ignored) {}
        catch (SQLException e) {
            errorDialog(e.toString());
        }
    }

    private static boolean canMount() throws IOException, SQLException {
        String titoloOperazione = "OP7 - Verifica montaggio componente";
        ResultSet resultSet;
        // SELECT Tipo, nGara_Vettura FROM Componente WHERE Tipo = ? AND nGara_Vettura = ?;
        String tipo, nGaraVettura;
        tipo = inputDialogOBBLIGATORIO("Inserisci il tipo ENUM={Motore, Cambio, Telaio}", titoloOperazione);
        nGaraVettura = inputDialogOBBLIGATORIO("Inserisci il numero di gara della vettura INT", titoloOperazione);
        Query queryCheckComponente = new Query(0, "Controllo componente gia montato", "SELECT Tipo, nGara_Vettura " +
                "FROM Componente WHERE Tipo = '" + tipo + "' AND nGara_Vettura = " + nGaraVettura + ";", true);
        resultSet = QueryRunner.runQuery(queryCheckComponente);
        if (resultSet == null) {
            throw new SQLException("Errore nell'esecuzione della query\n" + queryCheckComponente.query);
        }
        return !resultSet.next(); // se la query ritorna qualcosa, allora il componente è già montato su una vettura e non può essere montato
    }

}
