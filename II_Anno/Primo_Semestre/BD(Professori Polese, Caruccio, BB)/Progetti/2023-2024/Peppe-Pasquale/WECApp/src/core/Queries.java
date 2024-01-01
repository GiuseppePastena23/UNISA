package core;

public class Queries {
public static final Query[] queries = {

new Query(1, "Registrazione di una scuderia", "INSERT INTO Scuderia (Nome, Paese) VALUES (?, ?);", true),
new Query(2, "Inserimento dei dati di un’autovettura, compresi i componenti di cui è composta", "", true, true),
new Query(3, "Aggiunta di un nuovo pilota ad un equipaggio", "", true, true),
new Query(4, "Registrazione di un finanziamento per una scuderia", "", true, true),
new Query(56, "Iscrizione di una vettura ad una gara; Registrazione del risultato conseguito da ciascuna vettura iscritta ad una gara", "INSERT INTO Partecipazione (Nome_Gara, nGara_Vettura, Punti, Posizione, Minuti_gareggiati, Motivo_ritiro) VALUES (?, ?, ?, ?, ?, ?);", true),
new Query(7, "Verifica della possibilità di montare un componente su una vettura", "SELECT Tipo, nGara_Vettura FROM Componente\n" +
        "WHERE Tipo = ? AND Componente.nGara_Vettura = ?;", true, true), // -- se questa query ritorna qualcosa, allora il componente è già montato su una vettura e non può essere montato
new Query(8, "Per ciascuna scuderia, stampare la somma totale dei finanziamenti ricevuti", "SELECT Scuderia.Nome, SUM(Pilota.Quota) AS Totale_finanziamenti_ric\n" +
        "FROM Scuderia\n" +
        "INNER JOIN Vettura ON Vettura.Nome_Scuderia = Scuderia.Nome\n" +
        "INNER JOIN Pilota ON Pilota.nGara_Vettura = Vettura.nGara\n" +
        "GROUP BY Scuderia.Nome\n" +
        "ORDER BY Totale_finanziamenti_ric DESC;"),
new Query(9, "Stampa annuale delle scuderie che hanno partecipato al campionato compreso il numero di finanziamenti", "SELECT Scuderia.Nome, COUNT(DISTINCT Pilota.Quota) AS Numero_finanziamenti_ric\n" +
        "FROM Scuderia\n" +
        "INNER JOIN Vettura ON Vettura.Nome_Scuderia = Scuderia.Nome\n" +
        "INNER JOIN Pilota ON Pilota.nGara_Vettura = Vettura.nGara\n" +
        "INNER JOIN Partecipazione ON Partecipazione.nGara_Vettura = Vettura.nGara\n" +
        "GROUP BY Scuderia.Nome;"),
new Query(10, "Visualizzare i piloti che hanno vinto nel circuito di casa", "SELECT p.Cognome, g.Nome, c.Nome, c.Paese\n" +
        "FROM Pilota p\n" +
        "INNER JOIN Vettura v ON p.nGara_Vettura = v.nGara\n" +
        "INNER JOIN Partecipazione pt ON v.nGara = pt.nGara_Vettura\n" +
        "INNER JOIN Gara g ON pt.Nome_Gara = g.Nome\n" +
        "INNER JOIN Circuito c ON g.Nome_Circuito = c.Nome\n" +
        "WHERE p.Nazionalita = c.Paese AND pt.Posizione = 1;"),
new Query(11, "Per ciascuna scuderia, visualizzare la percentuale di gentleman driver di cui si compone l'equipaggio", "SELECT s.Nome,\n" +
        "       Count(p.Quota) * 100 /\n" +
        "       (SELECT Count(*)\n" +
        "        FROM Pilota pi\n" +
        "        INNER JOIN Vettura v ON pi.nGara_Vettura = v.nGara\n" +
        "        WHERE v.Nome_Scuderia = s.Nome\n" +
        "       ) AS Percentuale_GD\n" +
        "FROM Scuderia s\n" +
        "INNER JOIN Vettura v ON s.Nome = v.Nome_Scuderia\n" +
        "INNER JOIN Pilota p ON v.nGara = p.nGara_Vettura\n" +
        "GROUP BY s.Nome;"),
new Query(12, "Stampa mensile dei costruttori compreso il numero di componenti che ha fornito", "SELECT * FROM Costruttore;"),
new Query(13, "Stampa della classifica finale dei punti conseguiti da tutte le vetture", "SELECT Vettura.nGara, Vettura.Nome_Scuderia, SUM(Partecipazione.Punti) AS Punti_totali\n" +
        "FROM Vettura\n" +
        "INNER JOIN Partecipazione ON Vettura.nGara = Partecipazione.nGara_Vettura\n" +
        "GROUP BY Vettura.nGara\n" +
        "ORDER BY Punti_totali DESC;"),
new Query(14, "Stampa delle classifiche finali di punti per tipo di motore", "SELECT Vettura.nGara, Vettura.Nome_Scuderia, Componente.Tipo_motore, SUM(Partecipazione.Punti) AS Punti_totali\n" +
        "FROM Vettura\n" +
        "INNER JOIN Partecipazione ON Vettura.nGara = Partecipazione.nGara_Vettura\n" +
        "INNER JOIN Componente ON Vettura.nGara = Componente.nGara_Vettura\n" +
        "WHERE Tipo_motore IS NOT NULL\n" +
        "GROUP BY Componente.Tipo_motore, Vettura.nGara, Vettura.Nome_Scuderia\n" +
        "ORDER BY Componente.Tipo_motore, Punti_totali DESC;"),
new Query(15, "Stampare un report che elenchi ciascuna scuderia sulla base del rapporto punti/minuti di gara, mediando tra le macchine appartenenti a ciascuna scuderia", "SELECT\n" +
        "    s.Nome AS Nome_Scuderia,\n" +
        "    SUM(pa.Punti) AS Punti_totali,\n" +
        "    SUM(pa.Minuti_gareggiati) AS Minuti_totali,\n" +
        "    SUM(pa.Punti) / SUM(pa.Minuti_gareggiati) AS Rapporto_Punti_Per_Minuto\n" +
        "FROM\n" +
        "    Scuderia s\n" +
        "JOIN Vettura v ON s.Nome = v.Nome_Scuderia\n" +
        "JOIN Partecipazione pa ON v.nGara = pa.nGara_Vettura\n" +
        "GROUP BY\n" +
        "    s.Nome\n" +
        "ORDER BY\n" +
        "    Rapporto_Punti_Per_Minuto DESC;\n"),
};
}
