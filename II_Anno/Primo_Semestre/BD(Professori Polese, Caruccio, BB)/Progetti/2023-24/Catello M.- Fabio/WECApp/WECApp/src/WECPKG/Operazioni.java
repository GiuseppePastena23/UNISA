package WECPKG;

import WECPKG.Componenti.Cambio;
import WECPKG.Componenti.Componente;
import WECPKG.Componenti.Motore;
import WECPKG.Componenti.Telaio;
import WECPKG.Utilities.Connessione;
import WECPKG.Utilities.Utilities;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class Operazioni implements SuperOperazioni {
        public static boolean register_scuderia(String nome_scuderia, String sede_scuderia, int id_gara, String modello, Connessione con) {

            try {
                Connessione conn = new Connessione();
                conn.getConnessione().setAutoCommit(false);

                PreparedStatement updater1 = conn.getConnessione().prepareStatement(Query.statement1);
                PreparedStatement updater2 = conn.getConnessione().prepareStatement(Query.statement2);
                updater1.setObject(1,nome_scuderia);
                updater1.setObject(2,sede_scuderia);
                updater2.setObject(1,id_gara);
                updater2.setObject(2,modello);
                updater2.setObject(3,nome_scuderia);
                updater1.execute();
                updater2.execute();
                conn.getConnessione().commit();
                Utilities.info_message("Scuderia e vettura inserite correttamente.");
                con.getConnessione().close();
            } catch (Exception er) {Utilities.error_message(er); return false;}
            return true;
        }

        public static boolean register_vettura(int id_gara, String modello, String rif_scuderia, ArrayList<Componente> list, Connessione con) {
            boolean status = true;
            try {
                status = con.getConnessione().getAutoCommit();
                con.getConnessione().setAutoCommit(false);
                PreparedStatement update1 = con.getConnessione().prepareStatement(Query.statementvettura);
                update1.setObject(1, id_gara);
                update1.setObject(2,modello);
                update1.setObject(3,rif_scuderia);
                update1.execute();
                PreparedStatement update3 = con.getConnessione().prepareStatement(Query.updatestatement);
            for(Componente x: list) {
                if (x instanceof Motore){
                    PreparedStatement update2 = con.getConnessione().prepareStatement(Query.statementmotore);
                    update2.setObject(1,id_gara);
                    update2.setObject(2,id_gara);
                    update2.setObject(3,x.getCosto());
                    update2.setObject(4,x.getData_ins());
                    update2.setObject(5,x.getRif_Costruttore());
                    update2.setObject(6,((Motore) x).getCilindrata());
                    update2.setObject(7, ((Motore) x).getTipo_motore());
                    update2.setObject(8,((Motore) x).getNcilindri());
                    update3.setObject(1,x.getRif_Costruttore());
                    update2.execute();
                    update3.execute();
                } else if (x instanceof Telaio){
                    PreparedStatement update2 = con.getConnessione().prepareStatement(Query.statementtelaio);
                    update2.setObject(1,id_gara);
                    update2.setObject(2,id_gara);
                    update2.setObject(3,x.getCosto());
                    update2.setObject(4,x.getData_ins());
                    update2.setObject(5,x.getRif_Costruttore());
                    update2.setObject(6,((Telaio) x).getPeso());
                    update2.setObject(7,((Telaio) x).getMateriale());
                    update3.setObject(1,x.getRif_Costruttore());
                    update2.execute();
                    update3.execute();
                } else if (x instanceof Cambio){
                    PreparedStatement update2 = con.getConnessione().prepareStatement(Query.statementcambio);
                    update2.setObject(1,id_gara);
                    update2.setObject(2,id_gara);
                    update2.setObject(3,x.getCosto());
                    update2.setObject(4,x.getData_ins());
                    update2.setObject(5,x.getRif_Costruttore());
                    update2.setObject(6,((Cambio) x).getMarce());
                    update3.setObject(1,x.getRif_Costruttore());
                    update2.execute();
                    update3.execute();
                } else throw new IllegalArgumentException("NULL Componente");
            }
            con.getConnessione().commit();
            con.getConnessione().setAutoCommit(status);
            Utilities.info_message("L'inserimento è avvenuto con successo!");
            con.getConnessione().close();
            } catch (Exception ex) {Utilities.error_message(ex); return false;}
            return true;
        }

        public static boolean register_componente(Componente comp, Connessione con) {
            boolean status = true;
            try {
                    status = con.getConnessione().getAutoCommit();
                    con.getConnessione().setAutoCommit(false);
                    if (comp instanceof Motore){
                        PreparedStatement update2 = con.getConnessione().prepareStatement(Query.statementmotore);
                        update2.setObject(1,comp.getRif_vettura());
                        update2.setObject(2,comp.getRif_vettura());
                        update2.setObject(3,comp.getCosto());
                        update2.setObject(4,comp.getData_ins());
                        update2.setObject(5,comp.getRif_Costruttore());
                        update2.setObject(6,((Motore) comp).getCilindrata());
                        update2.setObject(7, ((Motore) comp).getTipo_motore());
                        update2.setObject(8,((Motore) comp).getNcilindri());
                        update2.execute();
                    } else if (comp instanceof Telaio){
                        PreparedStatement update2 = con.getConnessione().prepareStatement(Query.statementtelaio);
                        update2.setObject(1,comp.getRif_vettura());
                        update2.setObject(2,comp.getRif_vettura());
                        update2.setObject(3,comp.getCosto());
                        update2.setObject(4,comp.getData_ins());
                        update2.setObject(5,comp.getRif_Costruttore());
                        update2.setObject(6,((Telaio) comp).getPeso());
                        update2.setObject(7,((Telaio) comp).getMateriale());
                        update2.execute();
                    } else if (comp instanceof Cambio){
                        PreparedStatement update2 = con.getConnessione().prepareStatement(Query.statementcambio);
                        update2.setObject(1,comp.getRif_vettura());
                        update2.setObject(2,comp.getRif_vettura());
                        update2.setObject(3,comp.getCosto());
                        update2.setObject(4,comp.getData_ins());
                        update2.setObject(5,comp.getRif_Costruttore());
                        update2.setObject(6,((Cambio) comp).getMarce());
                        update2.execute();
                } else throw new IllegalArgumentException("NULL Componente");
                  PreparedStatement update3 = con.getConnessione().prepareStatement(Query.updatestatement);
                  update3.setObject(1,comp.getRif_Costruttore());
                  update3.execute();
                  con.getConnessione().commit();
                  con.getConnessione().setAutoCommit(status);
                Utilities.info_message("L'inserimento è avvenuto con successo!");
                con.getConnessione().close();
            } catch (Exception ex) {Utilities.error_message(ex); return false;}
            return true;
        }

        public static boolean add_pilota_AM(String nome, String cognome, String data_nascita, String nazionalità, String data_prima_licenza, boolean gm, int rif_equipaggio, Connessione con) {
            boolean result = false;
            boolean status = true;

            try {
                status = con.getConnessione().getAutoCommit();
                PreparedStatement update =  con.getConnessione().prepareStatement(Query.querystatement);
                if(gm) con.getConnessione().setAutoCommit(false);

                update.setObject(1,nome);
                update.setObject(2,cognome);
                update.setObject(3,data_nascita);
                update.setObject(4,nazionalità);
                update.setObject(5,data_prima_licenza);
                update.setObject(6,gm);
                update.setObject(7,rif_equipaggio);
                update.execute();

                if(gm){
                    PreparedStatement update1 = con.getConnessione().prepareStatement(Query.updatestatementAM);
                    add_finanzia fin = new add_finanzia(nome,cognome,data_nascita);
                    update1.setObject(1,nome);
                    update1.setObject(2,cognome);
                    update1.setObject(3,data_nascita);
                    update1.execute();
                }
                con.getConnessione().commit();
                con.getConnessione().setAutoCommit(status);
                result = true;
                Utilities.info_message("Pilota inserito correttamente!");
            } catch(Exception ex) {Utilities.error_message(ex); result = false;}

            return result;

        }

        public static boolean add_pilota_PRO(String nome, String cognome, String data_nascita, String nazionalità, int nlicenze, int rif_equipaggio, Connessione con){
            boolean result = false;

            try {
                con.getConnessione().setAutoCommit(true);
                PreparedStatement update = con.getConnessione().prepareStatement(Query.querystatementPRO);

                update.setObject(1,nome);
                update.setObject(2, cognome);
                update.setObject(3,data_nascita);
                update.setObject(4,nazionalità);
                update.setObject(5,nlicenze);
                update.setObject(6,rif_equipaggio);

                if (update.execute()) {
                    result = true;
                    Utilities.info_message("Pilota inserito correttamente!");
                }
            } catch(Exception ex) {Utilities.error_message(ex);}
            return result;
        }
        public static boolean register_finanzia(double importo, String data_fin, String rif_scuderia, String rif_gm_nome, String rif_gm_cognome, String rif_gm_data_nascita, Connessione con) {
            boolean result = false;

            try {
                con.getConnessione().setAutoCommit(false);
                PreparedStatement update = con.getConnessione().prepareStatement(Query.statementfin);
                update.setObject(1,importo);
                update.setObject(2,data_fin);
                update.setObject(3,rif_scuderia);
                update.setObject(4,rif_gm_nome);
                update.setObject(5,rif_gm_cognome);
                update.setObject(6, rif_gm_data_nascita);
                update.execute();
                PreparedStatement update1 = con.getConnessione().prepareStatement(Query.statementfin1);
                update1.setObject(1,importo);
                update1.setObject(2,rif_gm_nome);
                update1.setObject(3,rif_gm_cognome);
                update1.setObject(4,rif_gm_data_nascita);
                update1.execute();
                con.getConnessione().commit();
                con.getConnessione().close();
                result = true;
                Utilities.info_message("Finanziamento inserito con successo!");
            } catch(Exception ex) {Utilities.error_message(ex);}
            return result;
        }

        public static boolean sign_vettura(int rif_vettura, int codice_gara, Connessione con) {
            boolean status = false;
            boolean result = false;

             try {
                status = con.getConnessione().getAutoCommit();
                con.getConnessione().setAutoCommit(true);
                PreparedStatement update = con.getConnessione().prepareStatement(Query.statementpart);
                update.setObject(1,codice_gara);
                update.setObject(2,rif_vettura);
                update.execute();
                    result = true;
                    Utilities.info_message("Partecipazione inserita correttamente!");
                con.getConnessione().setAutoCommit(status);
                return result;
            } catch(Exception e) {
                Utilities.error_message(e);
                return result;
            }
        }
        public static boolean check_partecipazione(int rif_vettura,int codice_gara, Connessione con){
            boolean status = false;
            boolean result = false;

            try {
                status = con.getConnessione().getAutoCommit();
                con.getConnessione().setAutoCommit(true);
                PreparedStatement query1 = con.getConnessione().prepareStatement(Query.querystatement1);
                query1.setObject(1,rif_vettura);
                query1.setObject(2,codice_gara);
                PreparedStatement query2 = con.getConnessione().prepareStatement(Query.querystatement2);
                query2.setObject(1,rif_vettura);
                ResultSet set1 = query1.executeQuery();
                ResultSet set2 = query2.executeQuery();
                set1.next();
                set2.next();
                if (set1.getString("test").equals("true") && set2.getString("test").equals("true")) {
                    result = true;
                }
                con.getConnessione().setAutoCommit(status);
            } catch (Exception e) {Utilities.error_message(e);}
            return result;
        }

    public static boolean updatePartecipazione(int posizione, int punti, String motivoRitiro, int refVettura, int refGara, Connessione connessione) {
            boolean result = false;

        try {
            // Create a PreparedStatement

            connessione.getConnessione().setAutoCommit(true);
            PreparedStatement preparedStatement = connessione.getConnessione().prepareStatement(Query.updateStatement);

            // Set the parameters
            preparedStatement.setInt(1, punti);
            preparedStatement.setInt(2, posizione);
            if (!motivoRitiro.isEmpty() && !motivoRitiro.isBlank()) {
                preparedStatement.setString(3, motivoRitiro);
            } else {
                preparedStatement.setNull(3, java.sql.Types.NULL);
            }
            preparedStatement.setInt(4, refGara);
            preparedStatement.setInt(5, refVettura);

            int rowsUpdated = preparedStatement.executeUpdate();

            result = rowsUpdated > 0;

            PreparedStatement preparedStatement3 = connessione.getConnessione().prepareStatement(Query.updatevetturastatement);
            preparedStatement3.setInt(1,punti);
            preparedStatement3.setInt(2,refVettura);
            preparedStatement3.executeUpdate();
            result = true;

            PreparedStatement preparedStatement1 = connessione.getConnessione().prepareStatement(Query.updatepilota1statement);
            PreparedStatement preparedStatement2 = connessione.getConnessione().prepareStatement(Query.updatepilota2statement);

            preparedStatement1.setInt(1, punti);
            preparedStatement1.setInt(2, refVettura);
            preparedStatement1.setInt(3, refGara);

            preparedStatement2.setInt(1, punti);
            preparedStatement2.setInt(2, refVettura);
            preparedStatement2.setInt(3, refGara);

            int rowsUpdated1 = preparedStatement1.executeUpdate();
            int rowsUpdated2 = preparedStatement2.executeUpdate();

            connessione.getConnessione().commit();
            connessione.getConnessione().close();
        } catch (Exception e) {
            Utilities.error_message(e);
            result = false;
        }
        return result;
    }


        public static String find_scuderia(int id_equipaggio, Connessione con){
            String result = " ";
            java.sql.Date data_nascita_data = null;

            try{
                con.getConnessione().setAutoCommit(true);
                PreparedStatement query = con.getConnessione().prepareStatement(Query.querystatement3);
                query.setObject(1,id_equipaggio);
                ResultSet res = query.executeQuery();
                res.next();
                result = res.getString("scuderia");
               con.getConnessione().close();
            } catch(Exception ex) {Utilities.error_message(ex);}
            return result;
        }

        public static boolean check_componente(int rif_vettura, Class<? extends Componente> tipo, Connessione con) {
            boolean result = false;

            try {
                PreparedStatement query;
                switch(tipo.getSimpleName()){
                    case ("Motore"): query = con.getConnessione().prepareStatement(Query.querymotorestatement);
                    case ("Telaio"): query = con.getConnessione().prepareStatement(Query.querytelaiostatement);
                    case ("Cambio"): query = con.getConnessione().prepareStatement(Query.querycambiostatement);
                    default: query = con.getConnessione().prepareStatement(Query.querymotorestatement);
                }
                query.setObject(1,rif_vettura);
                ResultSet test = query.executeQuery();
                test.next();
                if(test.getString("test").equals("true")) {
                    con.getConnessione().close();
                    result = true;
                } else if (test.getString("test").equals("false")) {
                    con.getConnessione().close();
                }
            } catch(Exception ex) {Utilities.error_message(ex); return false;}

            return result;
        }

        public static ResultSet get_finanziamenti() {
            try{
                Connessione con = new Connessione();
                con.getConnessione().setAutoCommit(true);
                PreparedStatement prep = con.getConnessione().prepareStatement("SELECT s.nome_scuderia, SUM(f.importo) AS quota_totale FROM scuderia s LEFT JOIN finanzia f ON f.rif_scuderia = s.nome_scuderia GROUP BY s.nome_scuderia;");
                return prep.executeQuery();
            } catch (Exception e) {Utilities.error_message(e);return null;}

        }

        public static ResultSet get_scuderie() {
            try{
                Connessione con = new Connessione();
                con.getConnessione().setAutoCommit(true);
                PreparedStatement prep = con.getConnessione().prepareStatement("SELECT s.nome_scuderia, COUNT(f.ID_FIN) AS num_finanziamenti FROM scuderia s LEFT JOIN finanzia f ON f.rif_scuderia = s.nome_scuderia WHERE EXISTS (SELECT 1 FROM vettura v JOIN partecipazione p ON v.id_gara = p.rif_vettura WHERE v.rif_scuderia = s.nome_scuderia) GROUP BY s.nome_scuderia;");
                return prep.executeQuery();
            } catch (Exception e) {Utilities.error_message(e);return null;}

        }

        public static ResultSet get_piloti_casa() {
            try{
                Connessione con = new Connessione();
                con.getConnessione().setAutoCommit(true);
                PreparedStatement prep = con.getConnessione().prepareStatement("SELECT pilota.nome, pilota.cognome, pilota.nazionalità FROM (SELECT nome, cognome, nazionalità FROM pilota_am UNION SELECT nome, cognome, nazionalità FROM pilota_pro) AS pilota WHERE pilota.nazionalità IN (SELECT circuito.paese_residenza FROM circuito JOIN gara ON gara.Circuito = circuito.nome_circuito JOIN partecipazione ON partecipazione.rif_gara = gara.codice_gara WHERE partecipazione.posizione = 1);");

                return prep.executeQuery();
            } catch (Exception e) {Utilities.error_message(e);return null;}


        }

        public  static ResultSet get_gm() {
            try {
                Connessione con = new Connessione();
                con.getConnessione().setAutoCommit(true);
                PreparedStatement prep = con.getConnessione().prepareStatement("WITH piloti_totali AS ( SELECT scuderia.nome_scuderia, COUNT(*) AS numero_piloti FROM (SELECT nome, cognome, data_nascita, rif_equipaggio FROM pilota_am UNION SELECT nome, cognome, data_nascita, rif_equipaggio FROM pilota_pro) AS pilota JOIN equipaggio ON pilota.rif_equipaggio = equipaggio.ID_EQUIPAGGIO JOIN vettura ON equipaggio.rif_vettura = vettura.id_gara JOIN scuderia ON vettura.rif_scuderia = scuderia.nome_scuderia GROUP BY scuderia.nome_scuderia), piloti_gm AS ( SELECT scuderia.nome_scuderia, COUNT(pilota_am.gm) AS numero_piloti FROM pilota_am JOIN equipaggio ON pilota_am.rif_equipaggio = equipaggio.ID_EQUIPAGGIO JOIN vettura ON equipaggio.rif_vettura = vettura.id_gara JOIN scuderia ON vettura.rif_scuderia = scuderia.nome_scuderia GROUP BY scuderia.nome_scuderia) SELECT piloti_totali.nome_scuderia, CONCAT(FORMAT((piloti_gm.numero_piloti * 100) / piloti_totali.numero_piloti, 2), '%') AS percentuale_piloti_gm FROM piloti_totali JOIN piloti_gm ON piloti_totali.nome_scuderia = piloti_gm.nome_scuderia;;");

                return prep.executeQuery();
            } catch (Exception e) {Utilities.error_message(e);return null;}

        }

        public static ResultSet get_costruttori() {
            try{
                Connessione con = new Connessione();
                con.getConnessione().setAutoCommit(true);
                PreparedStatement prep = con.getConnessione().prepareStatement("SELECT ragione_sociale, ncomponenti FROM costruttore GROUP BY ragione_sociale;");

                return prep.executeQuery();
            } catch (Exception e) {Utilities.error_message(e);}
            return null;
        }

        public static ResultSet get_classifica_finale() {
            try{
                Connessione con = new Connessione();
                con.getConnessione().setAutoCommit(true);
                PreparedStatement prep = con.getConnessione().prepareStatement("SELECT vettura.id_gara AS vettura, vettura.totale_punti AS punti FROM vettura ORDER BY vettura.totale_punti DESC;");

                return prep.executeQuery();
            } catch (Exception e) {Utilities.error_message(e);}
            return null;
        }

        public static ResultSet get_classifica_parziale(String tipomotore) {
           try{
                Connessione con = new Connessione();
                con.getConnessione().setAutoCommit(true);
               PreparedStatement prep;
                if (tipomotore.equals("aspirato")) {
                    prep = con.getConnessione().prepareStatement("SELECT vettura.id_gara AS vettura, vettura.totale_punti AS punti FROM vettura JOIN componente_motore ON componente_motore.rif_vettura = vettura.id_gara WHERE (componente_motore.tipo_motore = \"aspirato\") ORDER BY vettura.totale_punti DESC;");

                } else  prep = con.getConnessione().prepareStatement("SELECT vettura.id_gara AS vettura, vettura.totale_punti AS punti FROM vettura JOIN componente_motore ON componente_motore.rif_vettura = vettura.id_gara WHERE (componente_motore.tipo_motore = \"turbo\") ORDER BY vettura.totale_punti DESC;");
                return prep.executeQuery();
            } catch (Exception e) {Utilities.error_message(e);return null;}


        }

        public static ResultSet get_report() {
            try{
                Connessione con = new Connessione();
                con.getConnessione().setAutoCommit(true);
                PreparedStatement prep = con.getConnessione().prepareStatement("WITH rapporto_vetture (id_vettura, rapporto, rif_scuderia) AS (SELECT vettura.id_gara, SUM(gara.duratah) / SUM(vettura.totale_punti) AS rapporto, vettura.rif_scuderia FROM vettura JOIN partecipazione ON vettura.id_gara = partecipazione.rif_vettura JOIN gara ON partecipazione.rif_gara = gara.codice_gara GROUP BY vettura.id_gara ORDER BY rapporto DESC) SELECT scuderia.nome_scuderia AS Scuderia, FORMAT(AVG(rapporto),2) AS media FROM scuderia, rapporto_vetture WHERE rapporto_vetture.rif_scuderia = scuderia.nome_scuderia GROUP BY scuderia.nome_scuderia;");

                return prep.executeQuery();
            } catch (Exception e) {Utilities.error_message(e);return null;}


        }



    }


