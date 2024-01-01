package Progetto;

import Progetto.ClassiQuery.*;
import Progetto.ClassiQuery.Componenti.TipoComponente; //java devi morire
import Progetto.ClassiQuery.Componenti.Tipocilindrata;
import java.sql.Date;

import java.sql.*;

public class Test
{
    //dichiarazione connessione
    private static Connection connessione;

    //funzione connessione alla base dati
    private static void connectToDatabase() throws SQLException 
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
        } 
        catch (ClassNotFoundException ex) 
        {
            //Gestione errore.
            System.err.println("Errore durante il caricamento del driver JDBC: " + ex.getMessage());
            throw new SQLException("Errore nel caricamento driver", ex);
        }
    }

    //OP1
    public static void OP1(String nome, String sedeCentrale)
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
        }
        catch(SQLException e)
        {
            System.err.println("Errore INSERT: " + e.getMessage());
        }
    }

    //da inserire SPECIFICATAMENTE in quest'ordine.
    public static void OP2(Vettura vettura, Componenti Cambio, Componenti Telaio, Componenti Motore)
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
            String QueryVettura = "INSERT INTO Vettura (ID, NomeScuderia, NGara, Modello) VALUES (?, ?, ?, ?)";

            // Inserire i dati della scuderia

            //crezione statement VETTURA
            PreparedStatement istruzioneVettura = connessione.prepareStatement(QueryVettura);
            //setting vari valori
            istruzioneVettura.setString(1, vettura.getId());
            istruzioneVettura.setString(2, vettura.getNomeScuderia());
            istruzioneVettura.setInt(3, vettura.getNGara());
            istruzioneVettura.setString(4, vettura.getModello());
 
            //Associamento componenti
            //{
                //Cambio (pos1)
            if(Cambio.getTipoComponente().equals(TipoComponente.cambio)) //se il tipo cambio è cambio
            {
                //creo query
                String QueryCambio = "INSERT INTO Componenti (ID, Tipo, Costo, Datainstallazione, NomeScuderia, NomeVettura, NomeCostruttore, Materiale, Peso, Nmarce, Cilindrata, Tipocilindrata, Numerocilindri) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                //creo statment 
                PreparedStatement istruzioneCambio = connessione.prepareStatement(QueryCambio);
                //associo il cambio alla nuova vettura.
                istruzioneCambio.setString(6, Cambio.getId());
            }
            else if(Cambio.getTipoComponente().equals(null))
            {
                //non fare nulla
            }
            else
            {
                System.err.println("Il componente inserito in prima posizione non è un cambio, nessuna modifica avvenuta\n");
            }

            //Telaio (pos2)
            if(Telaio.getTipoComponente().equals(TipoComponente.telaio)) //se il telaio è un telaio
            {
                //creo query
                String QueryTelaio = "INSERT INTO Componenti (ID, Tipo, Costo, Datainstallazione, NomeScuderia, NomeVettura, NomeCostruttore, Materiale, Peso, Nmarce, Cilindrata, Tipocilindrata, Numerocilindri) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                //creo statment 
                PreparedStatement istruzioneCambio = connessione.prepareStatement(QueryTelaio);
                //associo il cambio alla nuova vettura.
                istruzioneCambio.setString(6, Telaio.getId());
            }
            else if(Cambio.getTipoComponente().equals(null))
            {
                //non fare nulla
            }
            else
            {
                System.err.println("Il componente inserito in seconda posizione non è un telaio, nessuna modifica avvenuta\n");
            }

            //Motore (pos3)
            if(Motore.getTipoComponente().equals(TipoComponente.motore)) //se il motore è un motore
            {
                //creo query
                String QueryMotore = "INSERT INTO Componenti (ID, Tipo, Costo, Datainstallazione, NomeScuderia, NomeVettura, NomeCostruttore, Materiale, Peso, Nmarce, Cilindrata, Tipocilindrata, Numerocilindri) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                //creo statment 
                PreparedStatement istruzioneMotore = connessione.prepareStatement(QueryMotore);
                //associo il cambio alla nuova vettura.
                istruzioneMotore.setString(6, Telaio.getId());
            }
            else if(Cambio.getTipoComponente().equals(null))
            {
                //non fare nulla
            }
            else
            {
                System.err.println("Il componente inserito in terza posizione non è un motore, nessuna modifica avvenuta\n");
            }
            //}

            //eseguo update
            istruzioneVettura.executeUpdate();

            //stampo messaggio di conferma
            System.out.println("QUERY inserita con successo\n");

            // Chiudere la connessione
            connessione.close();
        }
        catch(SQLException e)
        {
            System.err.println("Errore INSERT: " + e.getMessage());
        }
    }

    //OP3
    public static void OP3(Pilota P, Squadra E)
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
            String Pilota = "INSERT INTO Pilota (Nome, Cognome, SSID, Datnas, Nazionalita, NomeSquadra, PrimaLicenza, NLicenze) VALUES (?, ?, ?, ? ,? ,?, ?, ?)";

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
            //eseguo update
            istruzionePilota.executeUpdate();

            //stampo messaggio di conferma
            System.out.println("QUERY inserita con successo\n");

            // Chiudere la connessione
            connessione.close();
        }
        catch(SQLException e)
        {
            System.err.println("Errore INSERT: " + e.getMessage());
        }
    }
    

    public static void main(String[] args)
    {
        //OP1("Mercedes", "Italia");
        Vettura v = new Vettura("10", "Mercedes", 10, "Mercedes X30");
        
        Componenti cambio = new Componenti().newCambio("C1234567890", TipoComponente.cambio, 34567.89, Date.valueOf("2023-7-22"), "McLaren", "MCL36", "McLaren Racing", 7);
        Componenti motore = new Componenti().newMotore("M1234567890", TipoComponente.motore, 12345.67, Date.valueOf("2023-7-20"), "Ferrari", "SF22-D", "Ferrari", 1600, Tipocilindrata.tipo1, 4);
        Componenti telaio = new Componenti().newTelaio("T1234567890", TipoComponente.telaio, 23456.78, Date.valueOf("2023-7-21"), "Red Bull", "RB18", "Red Bull Racing", "Carbonio", 750);

        OP2(v, cambio, telaio, motore);
        
        Pilota P = new Pilota("Mario", "Rossi", "125", Date.valueOf("2003-12-12"), "Italiano", Date.valueOf("2004-12-12"), 20);
    }
}