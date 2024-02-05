package WECPKG;

public class Query {

    /* ~~~ Operazioni.java ~~~ */

    //register_scuderia
    static String statement1 = "INSERT INTO Scuderia (nome_scuderia, nazione_sede) VALUES (?,?);";
    static String statement2 = "INSERT INTO Vettura (id_gara, modello, rif_scuderia, totale_punti) VALUES (?,?,?,0);";

    //register_vettura e register_componente
    static String statementvettura = "INSERT INTO vettura(id_gara, modello, totale_punti, rif_scuderia) VALUES (?,?,0,?)";
    static String statementmotore = "INSERT INTO componente_motore(rif_vettura,vettura,costo,data_installazione,rif_costruttore,cilindrata,tipo_motore,ncilindri) VALUES(?,?,?,?,?,?,?,?)";
    static String statementtelaio = "INSERT INTO componente_telaio(rif_vettura,vettura,costo,data_installazione,rif_costruttore,peso,materiale) VALUES (?,?,?,?,?,?,?)";
    static String statementcambio = "INSERT INTO componente_cambio(rif_vettura,vettura,costo,data_installazione,rif_costruttore,marce) VALUES(?,?,?,?,?,?)";
    static String updatestatement = "UPDATE costruttore c SET c.ncomponenti = c.ncomponenti + 1 WHERE c.ragione_sociale = ?";

    //add_pilota_AM
    static String querystatement = "INSERT INTO pilota_am(nome, cognome, data_nascita, nazionalità, punteggio, data_prima_licenza, quota, nfinanziamenti, gm,rif_equipaggio) VALUES (?,?,?,?,0,?,0,0,?,?)";
    static String updatestatementAM = "UPDATE pilota_am p SET p.nfinanziamenti = 1, p.quota = 0 WHERE (p.nome = ? AND p.cognome = ? AND p.data_nascita = ?)";

    //add_pilota_PRO
    static String querystatementPRO = "INSERT INTO pilota_pro(nome, cognome, data_nascita, nazionalità, punteggio, nlicenze, rif_equipaggio) VALUES (?,?,?,?,0,?,?)";

    //register_finanzia
    static String statementfin = "INSERT INTO finanzia(importo, data_fin, rif_scuderia, rif_gm_nome, rif_gm_cognome, rif_gm_data_nascita) VALUES (?,?,?,?,?,?)";
    static String statementfin1 = "UPDATE pilota_am p SET p.quota = p.quota + ?, p.nfinanziamenti = p.nfinanziamenti + 1 WHERE(p.nome = ? AND p.cognome = ? AND p.data_nascita = ?)";

    //sign_vettura
    static String statementpart = "INSERT INTO partecipazione(rif_gara, rif_vettura, punti) VALUES (?,?,0)";

    //check_partecipazione
    static String querystatement1 = "SELECT IF(EXISTS(SELECT 1 FROM partecipazione p WHERE(p.rif_vettura = ? AND p.rif_gara = ?)),'true','false') AS test;";
    /* una vettura deve avere un equipaggio (non vuoto) per poter partecipare. */
    static String querystatement2 = "SELECT IF(EXISTS(SELECT 1 FROM equipaggio e WHERE(e.rif_vettura = ? AND (SELECT 1 FROM(SELECT pa.rif_equipaggio FROM pilota_am pa UNION SELECT pr.rif_equipaggio FROM pilota_pro pr) AS pilota WHERE (pilota.rif_equipaggio = e.ID_EQUIPAGGIO)))),'true','false') AS test;";

    //find_scuderia
    static String querystatement3 = "SELECT scuderia.nome_scuderia AS scuderia FROM equipaggio e JOIN vettura ON e.rif_vettura = vettura.id_gara JOIN scuderia ON vettura.rif_scuderia = scuderia.nome_scuderia WHERE(e.ID_EQUIPAGGIO = ?)";

    //check_componente
    static String querymotorestatement = "SELECT v.id_gara, IF(EXISTS(SELECT 1 FROM componente_motore c WHERE c.rif_vettura = v.id_gara), 'true', 'false') AS test FROM vettura v WHERE v.id_gara = ?;";
    static String querytelaiostatement = "SELECT v.id_gara, IF(EXISTS(SELECT 1 FROM componente_telaio c WHERE c.rif_vettura = v.id_gara), 'true', 'false') AS test FROM vettura v WHERE v.id_gara = ?;";
    static String querycambiostatement = "SELECT v.id_gara, IF(EXISTS(SELECT 1 FROM componente_cambio c WHERE c.rif_vettura = v.id_gara), 'true', 'false') AS test FROM vettura v WHERE v.id_gara = ?;";

    //updatePartecipazione
    static String updateStatement = "UPDATE partecipazione p SET p.punti = ?, p.posizione = ?, p.motivo_ritiro = ? WHERE(p.rif_gara = ? AND p.rif_vettura = ?);";
    static String updatevetturastatement ="UPDATE vettura v SET v.totale_punti = v.totale_punti + ? WHERE( v.id_gara = ?);";
    static String updatepilota1statement = "UPDATE pilota_pro p JOIN EQUIPAGGIO e ON p.rif_equipaggio = e.ID_EQUIPAGGIO JOIN PARTECIPAZIONE pa ON e.rif_vettura = pa.rif_vettura SET p.punteggio = p.punteggio + ? WHERE e.ID_EQUIPAGGIO = ? AND pa.rif_gara = ?;";
    static String updatepilota2statement = "UPDATE pilota_am p JOIN EQUIPAGGIO e ON p.rif_equipaggio = e.ID_EQUIPAGGIO JOIN PARTECIPAZIONE pa ON e.rif_vettura = pa.rif_vettura SET p.punteggio = p.punteggio + ? WHERE e.ID_EQUIPAGGIO = ? AND pa.rif_gara = ?;";

    /* ~~~ add_componente.java ~~~ */

    static String q1 = "SELECT ragione_sociale FROM Costruttore ";

    /* ~~~ new_componente.java ~~~ */
    static String querycomponente1 = "SELECT id_gara, modello, rif_scuderia FROM vettura";
    static String querycomponente2 = "SELECT ragione_sociale FROM Costruttore ";

    /* ~~~ new_finanzia.java ~~~ */
    static String queryfinanziamento = "SELECT nome_scuderia FROM scuderia";
    static String queryfinanziamento1 = "SELECT p.nome, p.cognome, p.data_nascita, p.rif_equipaggio FROM pilota_am p INNER JOIN equipaggio e ON p.rif_equipaggio = e.ID_EQUIPAGGIO INNER JOIN vettura v ON e.rif_vettura = v.id_gara INNER JOIN scuderia s ON v.rif_scuderia = s.nome_scuderia WHERE s.nome_scuderia = ? AND p.gm = true;";

    /* ~~~ new_partecipazione.java ~~~ */

    static String q2 = "SELECT v.id_gara, v.modello, v.rif_scuderia FROM vettura v";
    static String q3 =  "SELECT g.codice_gara, g.nome_gara, g.stagione FROM gara g";

    /* ~~~ new_pilota.java ~~~ */

    static String q4 = "SELECT equipaggio.ID_EQUIPAGGIO, vettura.id_gara, vettura.modello, vettura.rif_scuderia FROM equipaggio LEFT JOIN vettura ON equipaggio.rif_vettura = vettura.id_gara";
    static String q5 =  "SELECT IF(EXISTS(SELECT 1 FROM pilota_am pa WHERE pa.gm = 0 AND pa.rif_equipaggio = e.ID_EQUIPAGGIO) OR EXISTS(SELECT 1 FROM pilota_pro pp WHERE pp.rif_equipaggio = e.ID_EQUIPAGGIO), 'true', 'false') AS test FROM equipaggio e WHERE e.ID_EQUIPAGGIO = ? ;";

    /* ~~~ new_risultati.java ~~~ */

    static String q6 = "SELECT g.codice_gara, g.nome_gara, g.stagione FROM gara g";
    static String q7 = "SELECT v.id_gara, v.modello, v.rif_scuderia, p.punti, p.posizione, p.motivo_ritiro FROM vettura v JOIN partecipazione p ON v.id_gara = p.rif_vettura WHERE(p.rif_gara = ? AND p.posizione = 0 AND p.punti = 0 AND motivo_ritiro IS NULL) ORDER BY v.id_gara";
    static String q8 = "SELECT v.id_gara, v.modello, v.rif_scuderia, p.punti, p.posizione, p.motivo_ritiro FROM vettura v JOIN partecipazione p ON v.id_gara = p.rif_vettura WHERE(p.rif_gara = ? ) ORDER BY v.id_gara;";

    /* ~~~ new_vettura.java ~~~ */
    static String q9 = "SELECT nome_scuderia FROM scuderia";




}

