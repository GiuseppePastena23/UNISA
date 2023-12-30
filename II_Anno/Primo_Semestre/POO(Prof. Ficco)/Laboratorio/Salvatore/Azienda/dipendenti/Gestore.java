package dipendenti;

import java.util.List;
import java.util.ArrayList;

import java.util.Scanner;

public class Gestore 
{
    private static List<Dipendente> Dipendenti = new ArrayList<>();

    public List<Dipendente> getStagisti()
    {
        List<Dipendente>Stagisti = new ArrayList<>();

        for(Dipendente dipendente : Stagisti) //se un dipendente è uno stagista aggiungilo a stagisti
        {
            if(dipendente instanceof Stagista)
            {
                Stagista stagista = (Stagista)dipendente; //downcasting
                Stagisti.add(stagista);
            }
            //else do nothing
        }

        return(Stagisti);
    }

    public void StampaLavoratori(int soglia) //se un dipendente ha un salario maggiore di soglia allora stampalo
    {
        for(Dipendente dipendente : Dipendenti)
        {
            if(dipendente.getSalario() >= soglia)
            {
                System.out.println(dipendente);
            }
        }
    }

    public void readLavoratori(String fileName)
    {
        //creo oggetto Scanner che leggerà ogni riga
        Scanner leggiLavoratori = new Scanner(fileName);
        String LineaAttuale;

        //finchè hai righe
        while(leggiLavoratori.hasNextLine())
        {
            //leggi e stampa
            LineaAttuale = leggiLavoratori.nextLine();
            System.out.println(LineaAttuale);
        }
        //poi chiude
        leggiLavoratori.close();
    }

    public void saveLavoratori(String fileName)
    {
        //creo oggetto Scanner che leggerà ogni riga
        Scanner leggiLavoratori = new Scanner(fileName);
        String LineaAttuale;
        Dipendente dipendente;
        String nome;
        String cognome;
        String codFis;
        String salario;

        //finchè hai righe
        while(leggiLavoratori.hasNextLine())
        {
            /*leggi e salva
            nome = extractValue(leggiLavoratori.nextLine(), "Nome");
            LineaAttuale = leggiLavoratori.nextLine();
            cognome = extractValue(lines[0], "Cognome");
            LineaAttuale = leggiLavoratori.nextLine();
            codFis = extractValue(lines[0], "CodFis");
            LineaAttuale = leggiLavoratori.nextLine();
            salario = Float.parseFloat(extractValue(lines[0], "Salario"));
            //Dipendenti.add();*/
        }
        //poi chiude
        leggiLavoratori.close();
    }
}