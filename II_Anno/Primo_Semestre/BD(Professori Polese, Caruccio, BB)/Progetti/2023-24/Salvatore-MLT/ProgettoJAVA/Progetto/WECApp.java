package Progetto;

import javax.management.RuntimeErrorException;
import javax.swing.*;
import java.awt.*;
import Progetto.ClassiQuery.*;
import java.sql.*;

import java.util.List;
import java.util.ArrayList;

public class WECApp extends JFrame
{
    //VerifiedStringToInt
    public static int VSTI(String s)
    {
        if(s == null)
        {
            return 0;
        }
        //else
        return Integer.parseInt(s);
    }

    public static double VSTD(String s)
    {
        if(s == null)
        {
            return 0;
        }
        //else
        return Double.parseDouble(s);
    }

    public WECApp() 
    {
        super("wecapp");
        setSize(800,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(15,1));
        
        String[] NomeOperazioni = 
        {
            "OP1: Registrazione di una scuderia",
            "OP2: Inserimento dei dati di un’autovettura, compresi i componenti di cui è composta;",
            "OP3. Aggiunta di un nuovo pilota ad un equipaggio;",
            "OP4: Registrazione di un finanziamento per una scuderia;",
            "OP5: Iscrizione di una vettura ad una gara;",
            "OP6: Registrazione del risultato conseguito da ciascuna vettura iscritta ad una gara;",
            "OP7: Verifica della possibilità di montare un componente su una vettura ;",
            "OP8: Per ciascuna scuderia, stampare la somma totale dei finanziamenti ricevuti;",
            "OP9: Stampa annuale delle scuderie che hanno partecipato al campionato compreso il numero di finanziamenti;",
            "OP10: Visualizzare i piloti che hanno vinto nel «circuito di casa» (es: un pilota italiano che vince su un circuito italiano);",
            "OP11: Per ciascuna scuderia, visualizzare la percentuale di gentleman driver di cui si compone l’equipaggio;",
            "OP12: Stampa mensile dei costruttori compreso il numero di componenti che ha fornito;",
            "OP13: Stampa della classifica finale dei punti conseguiti da tutte le vetture;",
            "OP14: Stampa delle classifiche finali di punti per tipo di motore;",
            "OP15: Stampare un report che elenchi ciascuna scuderia sulla base del rapporto punti/minuti di gara, mediando tra le macchine appartenenti a ciascuna scuderia;"
        };

        JButton[] arrayButtons = new JButton[15];
        for (int i = 0; i < 15; i++) 
        {
           arrayButtons[i] = new JButton(NomeOperazioni[i]);
           giveOperation(arrayButtons[i], i);
        }  
        for (JButton button : arrayButtons)
        {
            panel.add(button);
        }


        add(panel);
        setVisible(true);
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    //restituisce 0 --> SI & 1 --> NO
    private static int paneScelta (String InputQuestionMessage) 
    {
        Object[] options = {"SI", "NO"};
        return JOptionPane.showOptionDialog
        (
                null,
                InputQuestionMessage, //cosa chiedere all user
                "Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0] // Default selection (SI)
        );
    }


    private static String input(String campo) {
        return JOptionPane.showInputDialog(campo);
    }

    public static void giveOperation(JButton b, int index) 
    {
        final int FinalIndex = index + 1;
        b.addActionListener(e -> {
        switch (FinalIndex) 
        {
            case 1: //AGGIUNTA SCUDERIA
            {
                Scuderia scuderia; // nome, sedeCentrale
                String nome = input("nome scuderia"), sedeCentrale = input("sede centrale scuderia");
                scuderia = new Scuderia(nome, sedeCentrale);
                String stato = OP.OP1(scuderia);
                JOptionPane.showMessageDialog(null, stato);
                break;
            }
            
            case 2: //AUTOVETTURA + 3 COMPONENTI
            {
                // inserisci vettura
                Vettura vettura; // String id, String nomeScuderia, int nGara, String modello
                String idVettura = input("idVettura");
                String nomeScuderia = input("nomeScuderia");
                String nGara = input("nGara");
                String modello = input("modello");
                vettura = new Vettura(idVettura, nomeScuderia, VSTI(nGara), modello);
                Componenti telaio = null;
                Componenti cambio = null;
                Componenti motore = null;

                // inserimento telaio (opzionale)
                if(paneScelta("Vuoi inserire un Telaio?") == 0)
                {
                    String ID = input("ID");
                    Componenti.TipoComponente TipoComponente = Componenti.TipoComponente.telaio;
                    String Costo = input("Costo");
                    String Datainstallazione = input ("Datainstallazione");
                    String NomeScuderia = input ("NomeScuderia");
                    String NomeVettura = idVettura;
                    String NomeCostruttore = input ("NomeCostruttore");
                    String Materiale = input ("Materiale");
                    String Peso = input ("Peso"); 

                    telaio = Componenti.newTelaio 
                    (
                        ID, TipoComponente, VSTD(Costo),
                        Date.valueOf(Datainstallazione), NomeScuderia, NomeVettura,
                        NomeCostruttore, 
                        Materiale, VSTI(Peso)
                    );

                    
                }
                //else do nothing

                // inserimento cambio (opzionale)
                if(paneScelta("Vuoi inserire un Cambio?") == 0)
                {
                    String ID = input("ID");
                    Componenti.TipoComponente TipoComponente = Componenti.TipoComponente.cambio;
                    String Costo = input("Costo");
                    String Datainstallazione = input ("Datainstallazione");
                    String NomeScuderia = input ("NomeScuderia");
                    String NomeVettura = idVettura;
                    String NomeCostruttore = input ("NomeCostruttore");
                    String Nmarce = input("Nmarce");
 
                    cambio = Componenti.newCambio
                    (
                        ID, TipoComponente, VSTD(Costo),
                        Date.valueOf(Datainstallazione), NomeScuderia, NomeVettura,
                        NomeCostruttore, 
                        VSTI(Nmarce)
                    );
                    
                }
                //else do nothing
                
                // inserimento cambio (opzionale)
                if(paneScelta("Vuoi inserire un Motore?") == 0)
                {
                    String ID = input("ID");
                    Componenti.TipoComponente TipoComponente = Componenti.TipoComponente.motore;
                    String Costo = input("Costo");
                    String Datainstallazione = input ("Datainstallazione");
                    String NomeScuderia = input ("NomeScuderia");
                    String NomeVettura = idVettura;
                    String NomeCostruttore = input ("NomeCostruttore");
                    String Cilindrata = input ("Cilindrata");
                    String TipoMotore = input ("TipoMotore");
                    String NumeroCilindri = input ("NumeroCilindri");
 
                    motore = Componenti.newMotore
                    (
                        ID, TipoComponente, VSTD(Costo),
                        Date.valueOf(Datainstallazione), NomeScuderia, NomeVettura,
                        NomeCostruttore,
                        VSTI(Cilindrata), TipoMotore,VSTI(NumeroCilindri)
                    );
                    
                }

                String stato = OP.OP2(vettura, telaio, cambio, motore);
                //else do nothing
                JOptionPane.showMessageDialog(null, stato);

                

                
                break;
            }
            
            case 3: //AGGIUNTA PILOTA AD EQUIPAGGIO
            {
                // inserisci pilota
                String tipoPilota = input("Inserisci tipo pilota: PRO, AM, GD");
                Pilota pilota = null;
                String nomeSquadra;

                // campi comuni
                String nome, cognome, ssid, datnas, nazionalita;
                // Data datnas = new Date("YYYY-MM-DD");                
                
                nome = input("nome");
                cognome = input("cognome");
                ssid = input("ssid");
                datnas = input("Data di Nascita");
                nazionalita = input("nazionalita");
                
                
                // PRO
                // int nLicenze
                if (tipoPilota.equals("PRO")) {
                    String nLicenze = input("nLicenze");
                    pilota = new Pilota(nome, cognome, ssid, Date.valueOf(datnas), nazionalita, VSTI(nLicenze));
                }

                // AM
                // Date primaLicenza
                else if (tipoPilota.equals("AM")) {
                    String primaLicenza = input("primaLicenza");
                    pilota = new Pilota(nome, cognome, ssid, Date.valueOf(datnas), nazionalita, Date.valueOf(primaLicenza));
                }

                // GD
                // Date primaLicenza, int nFinanziamenti, double SommaFinanziamenti
                else if (tipoPilota.equals("GD")) {
                    String primaLicenza = input("primaLicenza");
                    String nFinanziamenti = input("nFinanziamenti");
                    String sommaFinanziamenti = input("sommaFinanziamenti");
                    pilota = new Pilota(nome, cognome, ssid, Date.valueOf(datnas), nazionalita, Date.valueOf(primaLicenza), VSTI(nFinanziamenti), VSTD(sommaFinanziamenti));
                }
                else {
                    JOptionPane.showMessageDialog(null, "Tipo pilota non esiste");
                    throw new RuntimeException("Tipo pilota non esiste");
                }
            

                nomeSquadra = input("nomeSquadra");
    
                String stato = OP.OP3(pilota, nomeSquadra);
                JOptionPane.showMessageDialog(null, stato);
                break;
            }
            
            case 4: //REGISTRAZIONE FINANZIAMENTO PER UNA SCUDERIA
            {
                String SSIDpilota = input("SSIDpilota");
                String finanziamento = input("finanziamento");
                String stato = OP.OP4(SSIDpilota, VSTD(finanziamento));
                JOptionPane.showMessageDialog(null, stato);
                break;
            }
            
            case 5: //ISCRIZIONE SQUADRA -> GARA
            {
                String Nome = input("Nome");
                String PunteggioFinale = input("PunteggioFinale");
                String NomeVeicolo = input("NomeVeicolo");
                Squadra squadra = new Squadra(Nome,VSTI(PunteggioFinale),NomeVeicolo);
                
                String NomeGara = input("NomeGara");
               
                String stato = OP.OP5(squadra ,NomeGara);
                break;
            }
        
            case 6: //REGISTRAZIONE RISULTATI VETTURE PER X GARA
            {
                String NomeGara = input("NomeGara");
                String PunteggioSqualifica = input("Punteggio/Squalifica");
                
                String stato = OP.OP6(NomeGara, PunteggioSqualifica);
                //OP6 gestisce internamente se è stringa o intero molto figo
                JOptionPane.showMessageDialog(null, stato);
                break;
            }
            case 7: //BOOLEAN. CONTROLLO CHE VETTURA X PUÒ INSTALLARE COMPONENTE Y
            {
                String IDVettura = input("ID Vettura");
                String TipoComponenteS = input("TipoComponente");

                
                boolean stato = OP.OP7(IDVettura, TipoComponenteS);

                JOptionPane.showMessageDialog(null, stato ? "" : "non " + "si puo montare");
                break;
            }
    
            case 8: //STAMPA SOMMA FINANZIAMENTI DI OGNI SCUDERIA
            {
                ArrayList<String> list = new ArrayList<>(OP.OP8());
                JOptionPane.showMessageDialog(null, list);
                break;
            }
            
            case 9: //STAMPA NFINANZIAMENTI DI OGNI SCUDERIA
            {
                ArrayList<String> list = new ArrayList<>(OP.OP9());
                JOptionPane.showMessageDialog(null, list);
                break;
            }
            case 10: //STAMPA PILOTI VINCITORI IN CASA
            {
                ArrayList<String> list = new ArrayList<>(OP.OP10());
                JOptionPane.showMessageDialog(null, list);
                break;
            }
            case 11: //STAMPA % GD TUTTE SQUADRE
            {
                ArrayList<String> list = new ArrayList<>(OP.OP11());
                JOptionPane.showMessageDialog(null, list);
                break;
            }
            case 12: //STAMPA TUTTI COSTRUTTORI + NComponenti
            {
                ArrayList<String> list = new ArrayList<>(OP.OP12());
                JOptionPane.showMessageDialog(null, list);
                break;
            }
            case 13: //STAMPA CLASSIFICA FINIALE TUTTE VETTURE
            {
                ArrayList<String> list = new ArrayList<>(OP.OP13());
                JOptionPane.showMessageDialog(null, list);
                break;
            }
            case 14: //STAMPA CLASSIFICHE FINALI DI PUNTI PER TIPO MOTORE
            {
                ArrayList<String> list = new ArrayList<>(OP.OP14());
                JOptionPane.showMessageDialog(null, list);
                break;
            }
            case 15: //STAMPA REPORT
            {
                ArrayList<String> list = new ArrayList<>(OP.OP15());
                JOptionPane.showMessageDialog(null, list);
                break;
            }
            
            default: 
            {
                throw new RuntimeException("Operazione " + index + " non implementata");
            }
        }
        });
    }
    

    public static void main(String[] args) 
    {
        new WECApp();
    }
}