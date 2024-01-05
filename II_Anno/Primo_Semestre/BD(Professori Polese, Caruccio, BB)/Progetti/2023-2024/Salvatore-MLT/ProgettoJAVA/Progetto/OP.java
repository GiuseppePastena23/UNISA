package Progetto;

import Progetto.ClassiQuery.*;
import Progetto.ClassiQuery.Componenti.TipoComponente; //java devi morire
import Progetto.ClassiQuery.Gara.TipoGara;

import java.sql.*;
import java.util.List;

import javax.management.Query;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import java.util.ArrayList;

public class OP
{
    //dichiarazione connessione
    private static Connection connessione;

    //funzione connessione alla base dati
    private static String connectToDatabase() throws SQLException 
    {
        String url = "jdbc:mysql://localhost:3306/campionato";
        String username = "pacman34";
        String password = "Sasa1212x";

        try 
        {
            //Caricamento Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver caricato con successo.");
    
            //Connessione al Database
            connessione = DriverManager.getConnection(url, username, password);
            System.out.println("Connessione alla base di dati avvenuta con successo.");
            return("Driver caricato con successo, connessione al database attiva");
        } 
        catch (ClassNotFoundException ex) 
        {
            //Gestione errore.
            System.err.println("Errore durante il caricamento del driver JDBC: " + ex.getMessage());
            return("Errore caricamento driver" + ex.getMessage());
            //throw new SQLException("Errore nel caricamento driver", ex);
        }
    }


    //OP1
    public static String OP1(Scuderia S)
    {
        String nome = S.getNome();
        String sedeCentrale = S.getSedeCentrale();
        try
        {
            connectToDatabase(); //tentivo connessione base dati
        } 
        catch (SQLException ex) //in caso di errore
        {
            System.err.println("Error connecting to database: " + ex.getMessage());
            return("Errore JDBC");
        }
        
        try
        {   
            //Creazione query
            String Scuderia = "INSERT INTO Scuderia (Nome, SedeCentrale) VALUES (?, ?)";

            // Inserire i dati della scuderia

            //crezione statement
            PreparedStatement istruzioneScuderia = connessione.prepareStatement(Scuderia);
            //setting vari valori
            istruzioneScuderia.setString(1, nome);
            istruzioneScuderia.setString(2, sedeCentrale);
            //eseguo update
            istruzioneScuderia.executeUpdate();

            //stampo messaggio di conferma
            System.out.println("QUERY inserita con successo\n");
            // Chiudere la connessione
            connessione.close();
             return("QUERY inserita con successo\n");

        }
        catch(SQLException e)
        {
            System.err.println("Errore INSERT: " + e.getMessage());
                        return("Errore INSERT " + e.getMessage());

        }
    }

    //da inserire SPECIFICATAMENTE in quest'ordine. (tecnicamente l'operazione non funziona se i componenti sono già presenti nel database, ma siccome l'unico modo per inserirli è quest'operazione)
    //che controlla prima di inserirli non c'è nessun problema. altrimenti bisognava implementare un controllo prima della insert di un dato componente e in quel caso non eseguirla (al più facendo un update)
    //(solamente sulla vettura associata da null a questa)
    public static String OP2(Vettura vettura, Componenti Telaio, Componenti Cambio, Componenti Motore)
    {
        try
        {
            connectToDatabase(); //tentivo connessione base dati
        } 
        catch (SQLException ex) //in caso di errore
        {
            System.err.println("Error connecting to database: " + ex.getMessage());
            return null;
        }

        try
        {   

            //{
                //Cambio (pos2)
            if(Cambio.getTipoComponente().equals(TipoComponente.cambio) && (OP7(vettura, Cambio))) //se il tipo cambio è cambio ed è installabile
            {
                //DO NOTHING
            }
            else
            {
                System.err.println("Il componente inserito in prima posizione non è un Telaio , nessuna modifica avvenuta\n");
                connessione.close();
                return("Errore creazione veicolo, controllare compatibilità/possibilità d'installazione");
            }

            //Telaio (pos1)
            if(Telaio.getTipoComponente().equals(TipoComponente.telaio) && (OP7(vettura, Telaio))) //se il telaio è un telaio ed è installabile
            {
                //DO NOTHING
            }
            else
            {
                connessione.close();
                return("Errore creazione veicolo, controllare compatibilità/possibilità d'installazione");
            }
            

            //Motore (pos3)
            if(Motore.getTipoComponente().equals(TipoComponente.motore) && ((OP7(vettura, Motore)))) //se il motore è un motore ed è installabile
            {
                //DO NOTHING                
            }
            else
            {
                System.err.println("Il componente inserito in terza posizione non è un motore, nessuna modifica avvenuta\n");
                connessione.close();
                return("Errore creazione veicolo, controllare compatibilità/possibilità d'installazione");
            }
            //}

                //Creazione query
                String QueryVettura = "INSERT INTO Vettura (ID, NomeScuderia, NGara, Modello) VALUES (?, ?, ?, ?)";

                // Inserire i dati della scuderia

                //crezione statement VETTURA
                PreparedStatement istruzioneVettura = connessione.prepareStatement(QueryVettura);
                //setting vari valori
                istruzioneVettura.setString(1, vettura.getId());
                istruzioneVettura.setString(2, vettura.getNomeScuderia());
                istruzioneVettura.setInt(3, vettura.getNGara());
                istruzioneVettura.setString(4, vettura.getModello());
                istruzioneVettura.executeUpdate();
                //Associamento componenti
                //eseguo update query vettura
                istruzioneVettura.executeUpdate();
                //creo query
                String QueryTelaio = "INSERT INTO Componenti (ID, Tipo, Costo, Datainstallazione, NomeScuderia, NomeVettura, NomeCostruttore, Materiale, Peso, Nmarce, Cilindrata, TipoMotore, Numerocilindri) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                //creo statment 
                PreparedStatement istruzioneTelaio = connessione.prepareStatement(QueryTelaio);
                //associo il cambio alla nuova vettura.
                istruzioneTelaio.setString(1, Telaio.getId());
                istruzioneTelaio.setString(2, (Telaio.getTipoComponente().toString()));
                istruzioneTelaio.setDouble(3, Telaio.getCosto());
                istruzioneTelaio.setDate(4, Telaio.getDataInstallazione());
                istruzioneTelaio.setString(5, Telaio.getNomeScuderia());
                istruzioneTelaio.setString(6, vettura.getId());
                istruzioneTelaio.setString(7, Telaio.getNomeCostruttore());
                istruzioneTelaio.setString(8, Telaio.getMateriale());
                istruzioneTelaio.setInt(9, Telaio.getPeso());
                istruzioneTelaio.setNull(10, 10);
                istruzioneTelaio.setNull(11, 11);
                istruzioneTelaio.setNull(12, 12);
                istruzioneTelaio.setNull(13, 13);
                //eseguo query
                istruzioneTelaio.executeUpdate();

                //creo query
                String QueryMotore = "INSERT INTO Componenti (ID, Tipo, Costo, Datainstallazione, NomeScuderia, NomeVettura, NomeCostruttore, Materiale, Peso, Nmarce, Cilindrata, TipoMotore, Numerocilindri) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                //creo statment 
                PreparedStatement istruzioneMotore = connessione.prepareStatement(QueryMotore);
                //associo il cambio alla nuova vettura.
                istruzioneMotore.setString(1, Motore.getId());
                istruzioneMotore.setString(2, (TipoComponente.motore.toString()));
                istruzioneMotore.setDouble(3, Motore.getCosto());
                istruzioneMotore.setDate(4, Motore.getDataInstallazione());
                istruzioneMotore.setString(5, Motore.getNomeScuderia());
                istruzioneMotore.setString(6, vettura.getId());
                istruzioneMotore.setString(7, Motore.getNomeCostruttore());
                istruzioneMotore.setNull(8, 8);
                istruzioneMotore.setNull(9, 9);
                istruzioneMotore.setNull(10, 10);
                istruzioneMotore.setInt(11, Motore.getCilindrata());
                istruzioneMotore.setString(12, (Motore.getTipoMotore()));
                istruzioneMotore.setInt(13, Motore.getNumeroCilindri());
                //eseguo query
                istruzioneMotore.executeUpdate();

                //creo query
                String QueryCambio = "INSERT INTO Componenti (ID, Tipo, Costo, Datainstallazione, NomeScuderia, NomeVettura, NomeCostruttore, Materiale, Peso, Nmarce, Cilindrata, TipoMotore, Numerocilindri) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                //creo statment 
                PreparedStatement istruzioneCambio = connessione.prepareStatement(QueryCambio);
                //associo il cambio alla nuova vettura.

                istruzioneCambio.setString(1, Cambio.getId());
                istruzioneCambio.setString(2, (Cambio.getTipoComponente().toString()));
                istruzioneCambio.setDouble(3, Cambio.getCosto());
                istruzioneCambio.setDate(4, Cambio.getDataInstallazione());
                istruzioneCambio.setString(5, Cambio.getNomeScuderia());
                istruzioneCambio.setString(6, vettura.getId());
                istruzioneCambio.setString(7, Cambio.getNomeCostruttore());
                istruzioneCambio.setNull(8, 8);
                istruzioneCambio.setNull(9, 9);
                istruzioneCambio.setInt(10, Cambio.getnMarce());
                istruzioneCambio.setNull(11, 11);
                istruzioneCambio.setNull(12, 12);
                istruzioneCambio.setNull(13, 13);
                //eseguo query
                istruzioneCambio.executeUpdate();

            //stampo messaggio di conferma
            System.out.println("Vettura e componenti inseriti con successo\n");
            
            // Chiudere la connessione
            connessione.close();

            return("Vettura e componenti inseriti con successo\n");
        }
        catch(SQLException e)
        {
            System.err.println("Errore INSERT: " + e.getMessage());
            return "errore SQL";
        }
    }

    //OP3
    public static String OP3(Pilota P, Squadra E)
    {
        try
        {
            connectToDatabase(); //tentivo connessione base dati
        } 
        catch (SQLException ex) //in caso di errore
        {
            System.err.println("Error connecting to database: " + ex.getMessage());
            return "Errore connessione DataBase";
        }
        
        try
        {   
            //CONTROLLO GD
            String QueryControlloGD = "SELECT Pilota.NFinanziamenti FROM Squadra" + "\n" +
            "INNER JOIN Pilota ON Pilota.NomeSquadra = Squadra.Nome" + "\n" +
            "WHERE Squadra.Nome = 'TEST1' AND Pilota.NFinanziamenti IS NULL;";

            PreparedStatement STMT = connessione.prepareStatement(QueryControlloGD);
            ResultSet ControlloGD = STMT.executeQuery(QueryControlloGD);

            //SE ESISTE ALMENO UN PILOTA NON GD E IL PILOTA DA INSERIRE NON È GD SI PUÒ PROCEDERE
            if(ControlloGD.next() && P.getNFinanziamenti() == 0)
            {
                return("Il pilota che stai provando ad inserire è un GentleMan driver, ogni squadra ha bisogno di almeno un non GD");
            }


            //Creazione query
            String Pilota = "INSERT INTO Pilota (Nome, Cognome, SSID, Datnas, Nazionalita, NomeSquadra, PrimaLicenza, NLicenze, NFinanziamenti, SommaFinanziamenti) VALUES (?, ?, ?, ? ,? ,?, ?, ?, ?, ?)";

            // Inserire i dati della scuderia

            //crezione statement
            PreparedStatement istruzionePilota = connessione.prepareStatement(Pilota);
            //setting vari valori
            istruzionePilota.setString(1, P.getNome());
            istruzionePilota.setString(2, P.getCognome());
            istruzionePilota.setString(3, P.getSsid());
            istruzionePilota.setDate(4, P.getDatnas());
            istruzionePilota.setString(5, P.getNazionalita());
            istruzionePilota.setString(6, E.getNome());
            istruzionePilota.setDate(7, P.getPrimaLicenza());
            istruzionePilota.setInt(8, P.getNLicenze());
            istruzionePilota.setInt(9, P.getNFinanziamenti());
            istruzionePilota.setDouble(10, P.getSommaFinanziamenti());

            //eseguo update
            istruzionePilota.executeUpdate();

            //stampo messaggio di conferma
            System.out.println("QUERY inserita con successo\n");

            // Chiudere la connessione
            connessione.close();

            return ("Pilota inserito in squadra con successo");
        }
        catch(SQLException e)
        {
            System.err.println("Errore INSERT: " + e.getMessage());
            return("Errore insert");
        }
    }
    
    //OP4 
    public static String OP4(Pilota GD, double Finanziamento)
    {
        try
        {
            connectToDatabase(); //tentivo connessione base dati
        } 
        catch (SQLException ex) //in caso di errore
        {
            System.err.println("Error connecting to database: " + ex.getMessage());
            return ("Erorre JDBC");
        }
        
        try
        {   
            //Creazione query
            String Finanziamento1 = "UPDATE Pilota SET NFinanziamenti = NFinanziamenti + 1 WHERE SSID = " + GD.getSsid();
            String Finanziamento2 = "UPDATE Pilota SET SommaFinanziamenti = SommaFinanziamenti+" +Finanziamento+  " WHERE SSID = " + GD.getSsid();

             // Inserire Finanziamento (aumentiamo NFinanziamento di 1 e La somma del valore indicato)
            PreparedStatement F1 = connessione.prepareStatement(Finanziamento1);
            PreparedStatement F2 = connessione.prepareStatement(Finanziamento2);

            //eseguo update
            F1.executeUpdate();
            F2.executeUpdate();

            System.out.println("Finanziamento somma pari: " +Finanziamento+ "\nDa parte di: " + GD + "\n");

            //stampo messaggio di conferma
            System.out.println("QUERY inserita con successo\n");

            // Chiudere la connessione
            connessione.close();

            return("Finanziamento inserito con successo");
        }
        catch(SQLException e)
        {
            System.err.println("Errore INSERT: " + e.getMessage());
            return("Errore insert");
        }
    }

    //OP5 (iscrizione vettura a una gara)
    public static String OP5(Squadra S, Gara G) //teoricamente il vincolo di integrità è garantito dal fatto che sia NomeGara che NomeSquadra sono primary key dunque non ripetibili.
    {
        try
        {
            connectToDatabase(); //tentivo connessione base dati
        } 
        catch (SQLException ex) //in caso di errore
        {
            System.err.println("Error connecting to database: " + ex.getMessage());
            return("Errore JDBC");
        }
        
        try
        {   
            //Creazione query
            String Gareggiare = "INSERT INTO Gareggiare (NomeGara, NomeSquadra, Punteggio, Squalifica) VALUES (?, ?, ?, ?)";

            // Inserire i dati della gara

            //crezione statement
            PreparedStatement istruzioneGareggiare = connessione.prepareStatement(Gareggiare);
            //setting vari valori

            istruzioneGareggiare.setString(1, G.getNome());
            istruzioneGareggiare.setString(2, S.getNome()); //la query richiede un veicolo. ma ogni squadra ha per l'appunto un veicolo.
            istruzioneGareggiare.setNull(3, 1);
            istruzioneGareggiare.setNull(4, 1);

            
            //eseguo update
            istruzioneGareggiare.executeUpdate();

            //stampo messaggio di conferma
            System.out.println("QUERY inserita con successo\n");

            // Chiudere la connessione
            connessione.close();

            return("Squadra " + S.getNome() + "gareggia in " + G.getNome());
        }
        catch(SQLException e)
        {
            System.err.println("Errore INSERT: " + e.getMessage());
            return("Errore insertimento Squadra/Gara");
        }
    }

            //Vogliamo avere tutte le gare così da poter applica OP6 in loop
            //SELECT Gara.NomeGara FROM Gara;

    //OP6 registrazione risulati da ciasciuna vettura iscritta ad una gara
    public static String OP6singola(String NomeGara, String NomeSquadra, int Punteggio) //versione Punteggio (da implementare versione completa con SELECT Vettura.ID FROM) //-1 in caso non partecipa -2 errore altrimenti punteggio
    {
        try
        {
            connectToDatabase(); //tentivo connessione base dati
        } 
        catch (SQLException ex) //in caso di errore
        {
            System.err.println("Error connecting to database: " + ex.getMessage());
            return("Errore JDBC");
        }
        
        try
        {   
            //controllo che la vettura abbia effettivamente partecipato alla gara (E che questa esista)
            // Creo statement
            Statement recuperoVetturaSquadra = connessione.createStatement();

            // Esecuzione Query
            String Gareggiare = "SELECT Gareggiare.nomeGara, Gareggiare.nomeSquadra FROM Gareggiare" + "\n" +
            "WHERE nomeGara = '" + NomeGara + "'"; //cerca solamente l'unica gara con quella specifica primary key nomegara 
            ResultSet resultSet = recuperoVetturaSquadra.executeQuery(Gareggiare);

            String nomeGara = null;
            String nomeSquadra = null;

            // Recupero dati
            while (resultSet.next()) 
            {
                nomeGara = resultSet.getString("NomeGara");
                nomeSquadra = resultSet.getString("NomeSquadra");
            }

            //controllo che siano corretti
            if(!(nomeGara == NomeGara) && (nomeSquadra == NomeSquadra))
            {   
                System.out.println("Questa Squadra non ha partecipato a questo gara\n");
                connessione.close();
                return "Questa Squadra non ha partecipato a questa gara";
            }
            //else continue

            //Creo query per aggiornare i punti
            String updateGareggiare = "UPDATE Gareggiare SET PunteggioSqualifica = "+ Punteggio +" WHERE NomeGara = '"+ NomeGara + "' AND NomeSquadra = '" + NomeSquadra + "'";

            //inserimento Punteggio
            PreparedStatement istruzioneRisultati = connessione.prepareStatement(updateGareggiare);

            //eseguo update
            istruzioneRisultati.executeUpdate();

            //stampo messaggio di conferma
            System.out.println("QUERY inserita con successo\n");

            // Chiudere la connessione
            connessione.close();
            return ""+Punteggio;
        }
        catch(SQLException e)
        {
            System.err.println("Errore INSERT: " + e.getMessage());
            return "Errore INSERT";
        }
    }

    //OP6 registrazione risulati da ciasciuna vettura iscritta ad una gara
    public static String OP6singola(String NomeGara, String NomeSquadra, String Squalifica) //versione Punteggio (da implementare versione completa con SELECT Vettura.ID FROM) //-1 in caso non partecipa -2 errore altrimenti punteggio
    {
        try
        {
            connectToDatabase(); //tentivo connessione base dati
        } 
        catch (SQLException ex) //in caso di errore
        {
            System.err.println("Error connecting to database: " + ex.getMessage());
        }
        
        try
        {   
            //controllo che la vettura abbia effettivamente partecipato alla gara (E che questa esista)
            // Creo statement
            Statement recuperoVetturaSquadra = connessione.createStatement();

            // Esecuzione Query
            String Gareggiare = "SELECT Gareggiare.nomeGara, Gareggiare.nomeSquadra FROM Gareggiare" + "\n" +
            "WHERE nomeGara = '" + NomeGara + "'"; //cerca solamente l'unica gara con quella specifica primary key nomegara 
            ResultSet resultSet = recuperoVetturaSquadra.executeQuery(Gareggiare);

            String nomeGara = null;
            String nomeSquadra = null;

            // Recupero dati
            while (resultSet.next()) 
            {
                nomeGara = resultSet.getString("NomeGara");
                nomeSquadra = resultSet.getString("NomeSquadra");
            }

            //controllo che siano corretti
            if(!(nomeGara == NomeGara) && (nomeSquadra == NomeSquadra))
            {   
                System.out.println("Questa Squadra non ha partecipato a questo gara\n");
                connessione.close();
                return "-1";
            }
            //else continue

            //Creo query per aggiornare i punti
            String updateGareggiare = "UPDATE Gareggiare SET PunteggioSqualifica = "+ Squalifica +" WHERE NomeGara = '"+ NomeGara + "' AND NomeSquadra = '" + NomeSquadra + "'";

            //inserimento Punteggio
            PreparedStatement istruzioneRisultati = connessione.prepareStatement(updateGareggiare);

            //eseguo update
            istruzioneRisultati.executeUpdate();

            //stampo messaggio di conferma
            System.out.println("QUERY inserita con successo\n");

            // Chiudere la connessione
            connessione.close();
            return Squalifica + "\nInserita con successo\n";
        }
        catch(SQLException e)
        {
            System.err.println("Errore INSERT: " + e.getMessage());
            return "-2";
        }
    }

    //aggiunge punteggio ad ogni vettura che partecipa ad una data Gara
    public static void OP6(String NomeGara)
    {   try
        {
            connectToDatabase(); //tentivo connessione base dati
        } 
        catch (SQLException ex) //in caso di errore
        {
            System.err.println("Error connecting to database: " + ex.getMessage());
        }

        try
        {
            String QueryRicercaVettureDaGara = "SELECT Squadra.Nome FROM Squadra" + "\n" +
            "INNER JOIN Gareggiare ON Gareggiare.NomeSquadra = Squadra.Nome" + "\n" +
            "WHERE Gareggiare.NomeGara = '"+ NomeGara + "'\n" +
            "GROUP BY Squadra.Nome, Gareggiare.NomeGara;"; //query
            PreparedStatement StatementRicercaVettureDaGara = connessione.prepareStatement(QueryRicercaVettureDaGara); //statement
            ResultSet RisultatoRicercaVettureDaGare = StatementRicercaVettureDaGara.executeQuery(QueryRicercaVettureDaGara); //Ottengo risultato della query eseguita da Statement

            List <String> Squadre = new ArrayList<>();

            while(RisultatoRicercaVettureDaGare.next())
            {
                Squadre.add(RisultatoRicercaVettureDaGare.getString("Nome"));
            }
            RisultatoRicercaVettureDaGare.close();
            
            for(String Squadra : Squadre)
            {
                System.out.println(NomeGara);
                OP6singola(NomeGara, Squadra, "'TEST_VALUE'"); //DA INSERIRE USERINPUT IN NULL IN GUI (SIA INT CHE STRING)
            }
            connessione.close();
        }
        catch(SQLException e)
        {
            System.err.println("Errore SELECT " + e.getMessage());
        } 
    }

   
    //OP7 Controllo possibilità installazione componente
    public static boolean OP7(Vettura V, Componenti P)
    {
        try
        {
            connectToDatabase(); //tentivo connessione base dati
        } 
        catch (SQLException ex) //in caso di errore
        {
            System.err.println("Error connecting to database: " + ex.getMessage());
        }
        
        try
        {   
            //Creazione query
            String QueryRicercaComponente = "SELECT * FROM Componenti WHERE NomeVettura = '" +  V.getId() + "' AND Tipo = '" + P.getTipoComponente() +"'";
            Statement RicercaComponente = connessione.createStatement();
            ResultSet ComponenteTrovato = RicercaComponente.executeQuery(QueryRicercaComponente);

            if(ComponenteTrovato.next())
            {
                // Chiudere la connessione
                connessione.close();
                //il componente è già montato. in quanto il risultato non è NULL
                return false;
            }
            else
            {
                // Chiudere la connessione
                connessione.close();
                //il componente non è montato. (risultato null)
                return true;
            }
        }
        catch(SQLException e)
        {
            System.err.println("Errore INSERT: " + e.getMessage());
            return false;
        }
    }

    //stampa di tutti i finanziamenti di ogni scuderia (tramite un array di String sennò esco pazzo)
    public static List<String> OP8()
    {
        try
        {
            connectToDatabase(); //tentivo connessione base dati
        } 
        catch (SQLException ex) //in caso di errore
        {
            System.err.println("Error connecting to database: " + ex.getMessage());
        }
        
        try
        {   
            //restituisco una stringa con result set con il risultato della query

            String QueryCercaFinanziamenti = 
            "SELECT Scuderia.Nome, SUM(Pilota.SommaFinanziamenti) FROM Scuderia" + "\n" +
            "INNER JOIN Vettura ON Vettura.NomeScuderia = Scuderia.Nome" + "\n" +
            "INNER JOIN Squadra ON Squadra.NomeVeicolo = Vettura.ID" + "\n" +
            "INNER JOIN Pilota ON Pilota.NomeSquadra = Squadra.Nome" + "\n" + 
            "GROUP BY Scuderia.Nome;";

            List<String> Finanziamenti = new ArrayList<>();
            PreparedStatement istruzioneCercaFinanziamenti = connessione.prepareStatement(QueryCercaFinanziamenti);
            ResultSet FinanziamentiScuderia = istruzioneCercaFinanziamenti.executeQuery(QueryCercaFinanziamenti);
            String CostruisciStringa = null;
            while(FinanziamentiScuderia.next())
            {
                CostruisciStringa = "("+(FinanziamentiScuderia.getString("Nome") + " :: Valore finanziamenti :: ");
                CostruisciStringa = (CostruisciStringa + FinanziamentiScuderia.getDouble("SUM(Pilota.SommaFinanziamenti)") + ")\n");
                Finanziamenti.add(CostruisciStringa);
            }

            FinanziamentiScuderia.close();
            return Finanziamenti;
        }
        catch(SQLException e)
        {
            System.err.println("Errore INSERT: " + e.getMessage());
            return null;
        }
    }

    //Restituisce il numero di finanziamenti complessivi di una scuderia
    public static List<String> OP9()
    {
        try
        {
            connectToDatabase(); //tentivo connessione base dati
        } 
        catch (SQLException ex) //in caso di errore
        {
            System.err.println("Error connecting to database: " + ex.getMessage());
        }
        
        try
        {   
            //restituisco una stringa con result set con il risultato della query

            String QueryCercaNumeroFinanziamenti = 
            "SELECT Scuderia.Nome, SUM(Pilota.NFinanziamenti) FROM Scuderia" + "\n" +
            "INNER JOIN Vettura ON Vettura.NomeScuderia = Scuderia.Nome" + "\n" +
            "INNER JOIN Squadra ON Squadra.NomeVeicolo = Vettura.ID" + "\n" +
            "INNER JOIN Pilota ON Pilota.NomeSquadra = Squadra.Nome" + "\n" + 
            "GROUP BY Scuderia.Nome;";

            List<String> Finanziamenti = new ArrayList<>();
            PreparedStatement istruzioneCercaFinanziamenti = connessione.prepareStatement(QueryCercaNumeroFinanziamenti);
            ResultSet FinanziamentiScuderia = istruzioneCercaFinanziamenti.executeQuery(QueryCercaNumeroFinanziamenti);
            String CostruisciStringa = null;
            while(FinanziamentiScuderia.next())
            {
                CostruisciStringa = "("+(FinanziamentiScuderia.getString("Nome") + " :: Numero finanziamenti :: ");
                CostruisciStringa = (CostruisciStringa + FinanziamentiScuderia.getDouble("SUM(Pilota.NFinanziamenti)") + ")\n");
                Finanziamenti.add(CostruisciStringa);
            }

            FinanziamentiScuderia.close();
            return Finanziamenti;
        }
        catch(SQLException e)
        {
            System.err.println("Errore INSERT: " + e.getMessage());
            return null;
        }
    }

    //Restituisce una collection di piloti che giocano in casa
    public static List<String> OP10()
    {
        try
        {
            connectToDatabase(); //tentivo connessione base dati
        } 
        catch (SQLException ex) //in caso di errore
        {
            System.err.println("Error connecting to database: " + ex.getMessage());
        }
        
        try
        {   
            //restituisco una stringa con result set con il risultato della query

            String QueryPilotiInCasa =
            "SELECT Pilota.Nome, Pilota.Cognome, Pilota.SSID, Pilota.Nazionalita, Gareggiare.Posizione FROM Pilota" + "\n" +
            "INNER JOIN Circuito ON Circuito.Paese = Pilota.Nazionalita" + "\n" +  //Garantisce che sia "in casa"
            "INNER JOIN Gara ON Gara.IDCircuito = Circuito.ID" + "\n" + 
            "INNER JOIN Gareggiare ON Gareggiare.NomeGara = Gara.Nome" + "\n" + 
            "WHERE Gareggiare.Posizione = 1;";

            List<String> Piloti = new ArrayList<>();
            PreparedStatement STMT = connessione.prepareStatement(QueryPilotiInCasa);
            ResultSet PilotiVincitori = STMT.executeQuery(QueryPilotiInCasa);
            String CostruisciStringa = null;

            while(PilotiVincitori.next())
            {
                CostruisciStringa = "("+(PilotiVincitori.getString("Nome") + " ");
                CostruisciStringa = CostruisciStringa + (PilotiVincitori.getString("Cognome")+ " ");
                CostruisciStringa = CostruisciStringa +  (PilotiVincitori.getString("SSID")+ " ");
                CostruisciStringa = CostruisciStringa + (PilotiVincitori.getString("Nazionalita") + ")\n");
                Piloti.add(CostruisciStringa);
            }

            PilotiVincitori.close();
            connessione.close();
            return Piloti;
        }
        catch(SQLException e)
        {
            System.err.println("Errore INSERT: " + e.getMessage());
            return null;
        }
    }

    //Restituisce un array di Nomi dI Squadre con %GD associata
    public static List<String> OP11()
    {
        try
        {
            connectToDatabase(); //tentivo connessione base dati
        } 
        catch (SQLException ex) //in caso di errore
        {
            System.err.println("Error connecting to database: " + ex.getMessage());
        }
        
        try
        {   
            //restituisco una stringa con result set con il risultato della query

            String QueryPercentualeGD = 
            "SELECT Squadra.Nome ,COUNT(Pilota.SommaFinanziamenti)/COUNT(Pilota.SSID) * 100 AS PercentualeGD FROM Squadra" + "\n" +
            "INNER JOIN Pilota ON Squadra.Nome = Pilota.NomeSquadra" + "\n" +
            "GROUP BY Squadra.Nome;";

            List<String> Squadre = new ArrayList<>();
            PreparedStatement STMT = connessione.prepareStatement(QueryPercentualeGD);
            ResultSet LeggiSquadre = STMT.executeQuery(QueryPercentualeGD);
            String CostruisciStringa = null;

            while(LeggiSquadre.next())
            {
                CostruisciStringa = "("+(LeggiSquadre.getString("Nome") + " ");
                CostruisciStringa = CostruisciStringa + (LeggiSquadre.getString("PercentualeGD") + ")\n");
                Squadre.add(CostruisciStringa);
            }

            LeggiSquadre.close();
            connessione.close();
            return Squadre;
        }
        catch(SQLException e)
        {
            System.err.println("Errore INSERT: " + e.getMessage());
            return null;
        }
    }

    //Restituisce un array di Scuderie con il numero di componenti che hanno creato associato
    public static List<String> OP12()
    {
        try
        {
            connectToDatabase(); //tentivo connessione base dati
        } 
        catch (SQLException ex) //in caso di errore
        {
            System.err.println("Error connecting to database: " + ex.getMessage());
        }
        
        try
        {   
            //restituisco una stringa con result set con il risultato della query

            String QueryScuderieNComponenti = 
            "SELECT Costruttore.RagioneSociale,  COUNT(Componenti.ID) AS NumeroComponenti FROM Componenti" + "\n" +
            "LEFT JOIN Costruttore ON Costruttore.RagioneSociale = Componenti.NomeCostruttore" + "\n" +  //LEFT JOIN AL POSTO DI INNER PER EVENTUALI COSTRUTTORI SENZA COMPONENTI (ma non ha senso credo?)
            "GROUP BY Costruttore.RagioneSociale;";

            List<String> Scuderie = new ArrayList<>();
            PreparedStatement STMT = connessione.prepareStatement(QueryScuderieNComponenti);
            ResultSet LeggiScuderie = STMT.executeQuery(QueryScuderieNComponenti);
            String CostruisciStringa = null;

            while(LeggiScuderie.next())
            {
                CostruisciStringa = "("+(LeggiScuderie.getString("RagioneSociale") + " ");
                CostruisciStringa = CostruisciStringa + (LeggiScuderie.getInt("NumeroComponenti") + ")\n");
                Scuderie.add(CostruisciStringa);
            }

            LeggiScuderie.close();
            connessione.close();
            return Scuderie;
        }
        catch(SQLException e)
        {
            System.err.println("Errore INSERT: " + e.getMessage());
            return null;
        }
    }

    public static List<String> OP13()
    {
        try
        {
            connectToDatabase(); //tentivo connessione base dati
        } 
        catch (SQLException ex) //in caso di errore
        {
            System.err.println("Error connecting to database: " + ex.getMessage());
        }
        
        try
        {   
            //restituisco una stringa con result set con il risultato della query

            String QueryVeicoloPunteggioFinale = 
            "SELECT Squadra.Nome, Squadra.NomeVeicolo, Squadra.PunteggioFinale FROM Squadra" + '\n' +
            "GROUP BY Squadra.NomeVeicolo;";

            List<String> Veicoli = new ArrayList<>();
            PreparedStatement STMT = connessione.prepareStatement(QueryVeicoloPunteggioFinale);
            ResultSet LeggiVeicoli = STMT.executeQuery(QueryVeicoloPunteggioFinale);
            String CostruisciStringa = null;

            while(LeggiVeicoli.next())
            {
                CostruisciStringa = "("+(LeggiVeicoli.getString("Nome") + " ");
                CostruisciStringa = CostruisciStringa +(LeggiVeicoli.getString("NomeVeicolo") + " ");
                CostruisciStringa = CostruisciStringa + (LeggiVeicoli.getInt("PunteggioFinale") + ")\n");
                Veicoli.add(CostruisciStringa);
            }

            LeggiVeicoli.close();
            connessione.close();
            return Veicoli;
        }
        catch(SQLException e)
        {
            System.err.println("Errore INSERT: " + e.getMessage());
            return null;
        }
    }

    public static List<String> OP14()
    {
        try
        {
            connectToDatabase(); //tentivo connessione base dati
        } 
        catch (SQLException ex) //in caso di errore
        {
            System.err.println("Error connecting to database: " + ex.getMessage());
        }
        
        try
        {   
            //restituisco una stringa con result set con il risultato della query

            String QueryVeicoloPunteggioFinale = 
            "SELECT Squadra.Nome, Squadra.NomeVeicolo, Squadra.PunteggioFinale, Componenti.TipoMotore FROM Squadra" + "\n" +
            "INNER JOIN Vettura ON Vettura.ID = Squadra.NomeVeicolo" + "\n" +
            "INNER JOIN Componenti ON Componenti.NomeVettura = Vettura.ID" + "\n" +
            "WHERE Componenti.Tipo = 'motore';";

            List<String> Veicoli = new ArrayList<>();
            PreparedStatement STMT = connessione.prepareStatement(QueryVeicoloPunteggioFinale);
            ResultSet LeggiVeicoli = STMT.executeQuery(QueryVeicoloPunteggioFinale);
            String CostruisciStringa = null;

            while(LeggiVeicoli.next())
            {
                CostruisciStringa = "("+(LeggiVeicoli.getString("Nome") + " ");
                CostruisciStringa = CostruisciStringa + (LeggiVeicoli.getString("NomeVeicolo") + " ");
                CostruisciStringa = CostruisciStringa +(LeggiVeicoli.getString("PunteggioFinale") + " ");
                CostruisciStringa = CostruisciStringa + (LeggiVeicoli.getString("TipoMotore") + ")\n");
                Veicoli.add(CostruisciStringa);
            }

            LeggiVeicoli.close();
            connessione.close();
            return Veicoli;
        }
        catch(SQLException e)
        {
            System.err.println("Errore INSERT: " + e.getMessage());
            return null;
        }
    }

    //restituisce tutte le scuderie con associata il rapporto minuto/punti per ogni gara (media prima tra le squadre e poi questo valore in media per scuderia)
    public static List<String> OP15() 
    {
        try
        {
            connectToDatabase(); //tentivo connessione base dati
        } 
        catch (SQLException ex) //in caso di errore
        {
            System.err.println("Error connecting to database: " + ex.getMessage());
        }
        
        try
        {   
            //restituisco una stringa con result set con il risultato della query

            String QueryMediaScuderie = 
            "SELECT Scuderia.Nome, SUM(Squadra.PunteggioFinale/Gara.Durata)/COUNT(Squadra.Nome) AS MediaTempo FROM Squadra" + "\n" +
            "INNER JOIN Vettura ON Vettura.ID = Squadra.NomeVeicolo" + "\n" +
            "INNER JOIN Scuderia ON Scuderia.Nome = Vettura.NomeScuderia" + "\n" +
            "INNER JOIN Gareggiare ON Gareggiare.NomeSquadra = Squadra.Nome" + "\n" +
            "INNER JOIN Gara ON Gara.Nome = Gareggiare.NomeGara" + "\n" +
            "GROUP BY Scuderia.Nome;";

            List<String> Scuderie = new ArrayList<>();
            PreparedStatement STMT = connessione.prepareStatement(QueryMediaScuderie);
            ResultSet LeggiScuderie = STMT.executeQuery(QueryMediaScuderie);
            String CostruisciStringa = null;

            while(LeggiScuderie.next())
            {
                CostruisciStringa = "("+(LeggiScuderie.getString("Nome") + " ");
                CostruisciStringa = CostruisciStringa + (LeggiScuderie.getString("MediaTempo") + ")\n");
                Scuderie.add(CostruisciStringa);
            }

            LeggiScuderie.close();
            connessione.close();
            return Scuderie;
        }
        catch(SQLException e)
        {
            System.err.println("Errore INSERT: " + e.getMessage());
            return null;
        }
    }


    



    public static void main(String[] args)
    {
        /*
        //OP1("Mercedes", "Italia");
        Vettura v = new Vettura("2037", "Ferrari", 10, "Mercedes X30");
        
        Componenti cambio = new Componenti().newCambio("TEST1", TipoComponente.cambio, 34567.89, Date.valueOf("2023-7-22"), "Ferrari", "MCL36", "Mercedes-Benz AG", 7);
        Componenti motore = new Componenti().newMotore("TEST2", TipoComponente.motore, 12345.67, Date.valueOf("2023-7-20"), "Ferrari", "SF22-D", "Mercedes-Benz AG", 1600, "tipo1", 4);
        Componenti telaio = new Componenti().newTelaio("TEST3", TipoComponente.telaio, 23456.78, Date.valueOf("2023-7-21"), "Ferrari", "RB18", "Mercedes-Benz AG", "Carbonio", 750);

        //OP2(v, cambio, telaio, motore);
        
        Pilota AM = new Pilota("Mario", "Rossi", "125", Date.valueOf("2003-12-12"), "Italia", Date.valueOf("2004-12-12"));
        Pilota PRO = new Pilota("Luigi", "Verdi", "126", Date.valueOf("2003-12-12"), "Italia", 20);
        Pilota GD = new Pilota("Stefano", "Bianchi", "127", Date.valueOf("2004-02-23"), "Italia", Date.valueOf("2020-12-23"), 10, 300000.30);
    
        Squadra S = new Squadra("Ferrari", 224, "1");

        //OP3(AM, S);
        //OP3(PRO, S);
        //OP3(GD, S);
        //OP4(GD, 200);
        Gara gara = new Gara(Date.valueOf("2023-04-14"), "Autodromo Nazionale Monza", 200, TipoGara.asciutta, "Gran Premio dItalia");

        //O
        
        
        
        //OP5(S, gara);

        //OP6singola(gara, S, 100);
        //OP6singola(gara, S, "Palle");
        if(OP7(v,cambio) == true)
        {
            System.out.println("SESSO\n");
        }
        else
        {
            System.out.println("SESSO2\n");
        };

       // OP6("Gran Premio dItalia");

        List <String> TestString = new ArrayList<>();
        /*TestString = OP8();
        System.out.println(TestString);*/

        //System.out.println(OP9());

        //System.out.println(OP10());
        //System.out.println(OP11());
        //System.out.println(OP12());
        //System.out.println(OP13());
        //System.out.println(OP14());
        //System.out.println(OP15());
        //System.out.println(ControlloGD());
        
    }
}