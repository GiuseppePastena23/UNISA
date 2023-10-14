package gestione.parole;
import java.util.Scanner;
import java.io.*;
import java.lang.String;
public class GestioneParole 
{
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
        Scanner in = new Scanner(System.in);
        int scelta, cont;
        char risp;
        String parola, par;
        do
        {
            System.out.println("1)Inserisci - 2)Aggiungi - 3)Lettura - 4)Ricerca - 5)Parole Lunghe 5 - 0)Fine");
            scelta = in.nextInt();
            switch(scelta)
            {
                case 1: 
                    // apertura file x inserimento 
                    PrintWriter fscrivi = new PrintWriter("parole.txt");
                    do
                    {
                        System.out.print("Inserisci parola: ");
                        parola = in.next();                     
                        // scrittura nel file
                        fscrivi.println(parola);
                        System.out.print("Altro inserimento [s/n]");
                        risp = in.next().charAt(0);
                    }
                    while ((risp == 's') || (risp == 'S'));
                    // chiusura file
                    fscrivi.close();
                break;
   
                case 2:
                    // apertura file x aggiunta
                    FileWriter aggiungi = new FileWriter("parole.txt", true);
                    PrintWriter faggiungi = new PrintWriter(aggiungi);
                    do
                    {
                        System.out.print("Inserisci parola: ");
                        parola = in.next();
                        faggiungi.println(parola);
                        System.out.print("Altro inserimento [s/n]");
                        risp = in.next().charAt(0);
                    }
                    while ((risp == 's') || (risp == 'S'));
                    // chiusura file
                    faggiungi.close();
                break;
                
                case 3:
                    // apertura file x lettura
                    FileReader fleggi = new FileReader("parole.txt");
                    // abbinamento scanner lettore al file fleggi
                    Scanner lettore = new Scanner(fleggi);
                    while (lettore.hasNext())
                    {
                        parola = lettore.next();
                        System.out.println("Parola = " + parola);
                    }
                    fleggi.close();
                break;
                
                case 4:
                    // apertura file x lettura
                    FileReader fleggir = new FileReader("parole.txt");
                    // abbinamento scanner lettore al file fleggi
                    Scanner lettorer = new Scanner(fleggir);
                    cont=0;
                    System.out.println("Inserisci la parola da ricercare");
                    par = in.next();
                    while(lettorer.hasNext())
                    {
                        parola = lettorer.next();
                        if(par.equals(parola))
                            cont++;
                    }
                    System.out.println("Ci sono " + cont + " parole uguali");
                break;    
                    
                case 5:
                    // apertura file x lettura
                    FileReader fleggiri = new FileReader("parole.txt");
                    // abbinamento scanner lettore al file fleggi      
                    Scanner lettorei = new Scanner(fleggiri);
                    System.out.println("Parole più lunghe di 5 caratteri: ");
                    while(lettorei.hasNext())
                    {
                        parola = lettorei.next();
                        if(parola.length()>5)
                            System.out.println(parola);
                    }
                break;
                
                default:
                    System.out.println("Parola SCONOSCIUTA");
            }
        }while(scelta != 0);
    }
}