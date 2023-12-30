USE Campionato;

-- OP1
-- Registrazione di una scuderia
INSERT INTO Scuderia (Nome, Paese) VALUES
(?, ?);

-- OP2
-- Inserimento dei dati di un’autovettura, compresi i componenti di cui è composta


-- OP3
-- Aggiunta di un nuovo pilota ad un equipaggio
-- controllare che non sia tutto composto da GD

-- OP4
-- Registrazione di un finanziamento per una scuderia


-- OP5 - OP6
-- Iscrizione di una vettura ad una gara; Registrazione del risultato conseguito da ciascuna vettura iscritta ad una gara
INSERT INTO Partecipazione (Nome_Gara, nGara_Vettura, Punti, Posizione, Minuti_gareggiati, Motivo_ritiro) VALUES
(?, ?, ?, ?, ?, ?);


-- OP7
-- Verifica della possibilità di montare un componente su una vettura
SELECT * FROM Componente, Vettura WHERE Tipo = ? AND Componente.nGara_Vettura = ?;
-- se questa query ritorna qualcosa, allora il componente è già montato su una vettura e non può essere montato


-- OP8
-- Per ciascuna scuderia, stampare la somma totale dei finanziamenti ricevuti
SELECT Scuderia.Nome, SUM(Pilota.Quota) AS Totale_finanziamenti_ric FROM Scuderia, Pilota, Vettura
WHERE Pilota.nGara_Vettura = Vettura.nGara AND Vettura.Nome_Scuderia = Scuderia.Nome GROUP BY Scuderia.Nome;


-- OP9
-- Stampa annuale delle scuderie che hanno partecipato al campionato compreso il numero di finanziamenti
SELECT Scuderia.Nome, SUM(Pilota.Quota) AS Totale_finanziamenti_ric FROM Scuderia, Pilota, Vettura, Partecipazione
WHERE Pilota.nGara_Vettura = Vettura.nGara AND Vettura.Nome_Scuderia = Scuderia.Nome
AND Partecipazione.nGara_Vettura = Vettura.nGara
GROUP BY Scuderia.Nome;


-- OP10
-- Visualizzare i piloti che hanno vinto nel "circuito di casa"
SELECT p.Cognome, g.Nome, c.Nome, c.Paese
FROM Pilota p
INNER JOIN Vettura v ON p.nGara_Vettura = v.nGara
INNER JOIN Partecipazione pt ON v.nGara = pt.nGara_Vettura
INNER JOIN Gara g ON pt.Nome_Gara = g.Nome
INNER JOIN Circuito c ON g.Nome_Circuito = c.Nome
WHERE p.Nazionalita = c.Paese AND pt.Posizione = 1;



-- OP11
-- Per ciascuna scuderia, visualizzare la percentuale di gentleman driver di cui si compone l'equipaggio
SELECT s.Nome,
       Count(p.Quota) * 100 /
       (SELECT Count(*)
        FROM Pilota pi
        INNER JOIN Vettura v ON pi.nGara_Vettura = v.nGara
        WHERE v.Nome_Scuderia = s.Nome
       ) AS Percentuale_GD
FROM Scuderia s
INNER JOIN Vettura v ON s.Nome = v.Nome_Scuderia
INNER JOIN Pilota p ON v.nGara = p.nGara_Vettura
-- per renderla esclusiva WHERE p.Quota > 0
GROUP BY s.Nome;



-- OP12
-- Stampa mensile dei costruttori compreso il numero di componenti che ha fornito
SELECT * FROM Costruttore;


-- OP13
-- Stampa della classifica finale dei punti conseguiti da tutte le vetture
SELECT Vettura.nGara, Vettura.Nome_Scuderia, SUM(Partecipazione.Punti) AS Punti_totali
FROM Vettura
INNER JOIN Partecipazione ON Vettura.nGara = Partecipazione.nGara_Vettura
GROUP BY Vettura.nGara
ORDER BY Punti_totali DESC;

-- OP14
-- Stampa delle classifiche finali di punti per tipo di motore
SELECT Vettura.nGara, Vettura.Nome_Scuderia, Componente.Tipo_motore, SUM(Partecipazione.Punti) AS Punti_totali
FROM Vettura
INNER JOIN Partecipazione ON Vettura.nGara = Partecipazione.nGara_Vettura
INNER JOIN Componente ON Vettura.nGara = Componente.nGara_Vettura
WHERE Tipo_motore IS NOT NULL
GROUP BY Componente.Tipo_motore, Vettura.nGara, Vettura.Nome_Scuderia
ORDER BY Componente.Tipo_motore, Punti_totali DESC;


-- OP15
-- Stampare un report che elenchi ciascuna scuderia sulla base del rapporto punti/minuti di gara,
-- mediando tra le macchine appartenenti a ciascuna scuderia
SELECT
    s.Nome AS Nome_Scuderia,
    SUM(pa.Punti) AS Punti_totali,
    SUM(pa.Minuti_gareggiati) AS Minuti_totali,
    SUM(pa.Punti) / SUM(pa.Minuti_gareggiati) AS Rapporto_Punti_Per_Minuto
FROM
    Scuderia s
JOIN Vettura v ON s.Nome = v.Nome_Scuderia
JOIN Partecipazione pa ON v.nGara = pa.nGara_Vettura
GROUP BY
    s.Nome
ORDER BY
    Rapporto_Punti_Per_Minuto DESC;
