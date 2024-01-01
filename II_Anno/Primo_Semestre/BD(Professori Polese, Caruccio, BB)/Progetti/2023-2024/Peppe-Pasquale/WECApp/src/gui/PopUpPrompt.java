package gui;

import core.Query;
import core.QueryRunner;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopUpPrompt {

    public PopUpPrompt(Query query) {
        // clona query per non modificare quella originale
        query = new Query(query.opNumber, query.name, query.query, query.requiresInput);
        query.query = fillQuery(query); // continua a chiedere input all'utente finché non sono stati inseriti tutti i campi
        if (query.query == null) {
            // l'utente ha cliccato su annulla o ha chiuso la finestra
            // interrompi l'esecuzione della query
            return;
        }


        ResultSet resultSet = QueryRunner.runQuery(query);
        // stampa il risultato della query
        if (resultSet == null) {
            JOptionPane.showMessageDialog(null, "Errore nell'esecuzione della query", "Errore", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else {
            JOptionPane.showMessageDialog(null, "Query eseguita con successo", "Successo", JOptionPane.INFORMATION_MESSAGE);
        }

    }


    public static String fillQuery(Query query) {
        while (query.query.contains("?")) {
            String input = JOptionPane.showInputDialog(null, "Completa i campi contrassegnati dai ?\n" + query.query, query.toString(), JOptionPane.QUESTION_MESSAGE);
            if (input == null) {
                // l'utente ha cliccato su annulla o ha chiuso la finestra
                // interrompi l'esecuzione della query
                return null;
            }
            if (input.isEmpty() || input.isBlank()) {
                JOptionPane.showMessageDialog(null, "Inserisci un valore valido", "Errore", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            query.query = query.query.replaceFirst("\\?", "'"+input+"'");
        }
        return query.query;
    }

}
