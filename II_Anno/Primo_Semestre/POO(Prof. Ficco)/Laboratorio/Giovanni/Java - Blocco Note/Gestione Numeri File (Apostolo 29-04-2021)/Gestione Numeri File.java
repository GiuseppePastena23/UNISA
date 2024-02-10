package gestione.numeri;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
public class GestioneNumeri 
{
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
        Scanner in = new Scanner(System.in);
        int numero, totale=0, scelta, i;
        char risp;
        do
        {
            System.out.println("1)Inserisci - 2)Aggiungi - 3)Somma - 4)Ordina - 5)LetturaOrdina - 0) Fine");
            scelta = in.nextInt();
            switch(scelta)
            {
                case 1: 
                    // apertura file x inserimento 
                    PrintWriter fscrivi = new PrintWriter("numeri.txt");
                    do
                    {
                        System.out.print("Inserisci numero: ");
                        numero = in.nextInt();                     
                        // scrittura nel file
                        fscrivi.println(numero);  
                        System.out.print("Altro inserimento [s/n]");
                        risp = in.next().charAt(0);
                    }
                    while ((risp == 's') || (risp == 'S'));
                    // chiusura file
                    fscrivi.close();
                break;    
    
                case 2: 
                    // apertura file x aggiunta 
                    FileWriter aggiungi = new FileWriter("numeri.txt", true);
                    PrintWriter faggiungi = new PrintWriter(aggiungi);
                    do
                    {
                        System.out.print("Inserisci numero : ");
                        numero = in.nextInt();                     
                        faggiungi.println(numero);  
                        System.out.print("Altro inserimento [s/n]");
                        risp = in.next().charAt(0);
                    }
                    while ((risp == 's') || (risp == 'S'));
                    // chiusura file
                    faggiungi.close();
                break;
                
                case 3:
                    // apertura file x lettura
                    FileReader fleggi = new FileReader("numeri.txt");
                    // abbinamento scanner lettore al file fleggi      
                    Scanner lettore = new Scanner(fleggi);
                    int somma = 0;
                    while (lettore.hasNext())
                    {
                        numero = lettore.nextInt();
                        System.out.println("Numero = " + numero);
                        somma = somma + numero;
                    }
                    System.out.println("Somma = " + somma);
                    // chiusura file
                    fleggi.close();
                break;
                
                case 4:
                    FileReader flegg = new FileReader("numeri.txt");
                    Scanner lettor = new Scanner(flegg);
                    ArrayList <Integer> numeri = new ArrayList <>();
                    while(lettor.hasNext())
                    {
                        numero = lettor.nextInt();
                        numeri.add(numero);
                    }
                    Collections.sort(numeri);
                    PrintWriter fordina = new PrintWriter("ordina.txt");
                    for(i=0;i<numeri.size();i++)
                    {
                        fordina.println(numeri.get(i));
                    }
                    fordina.close();
                break;
                
                case 5:
                    FileReader foleggi = new FileReader("ordina.txt");
                    Scanner lettoreo = new Scanner(foleggi);
                    i=0;
                    while (lettoreo.hasNext())
                    {
                        i++;
                        System.out.println("Numero " + i + " = " + lettoreo.nextInt());
                    }
                    foleggi.close();
                break;
            }
        }while (scelta != 0);          
    }
}