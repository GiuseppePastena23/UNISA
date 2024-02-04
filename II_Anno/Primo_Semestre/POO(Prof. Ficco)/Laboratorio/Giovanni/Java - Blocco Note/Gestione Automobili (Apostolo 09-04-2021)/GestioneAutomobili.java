package GestioneAutomobili;

import java.util.ArrayList;
import java.util.Scanner;

public class GestioneAutomobili {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sc, km, i;
        String targa, modello, colore, testo;
        ArrayList<Automobili> a = new ArrayList <> ();
        do {
            System.out.println("0) Uscita");
            System.out.println("1) Aggiungi Auto");
            System.out.println("2) Stampa Auto");
            System.out.println("3) Aggiorna kilometri");
            System.out.println("---------------------------");
            sc=in.nextInt();
            switch(sc) {
                case 0:
                    System.out.println("Uscita");
                break;
                
                default:
                    System.out.println("SCELTA SCONOSCIUTA");
                break;
                
                case 1:
                    System.out.println("Inserisci la targa");
                    targa=in.next();
                    System.out.println("Inserisci il modello");
                    modello=in.next();
                    System.out.println("Inserisci il colore");
                    colore=in.next();
                    System.out.println("Inserisci i kilometri effettuati");
                    km=in.nextInt();
                    a.add(new Automobili(targa, modello, colore, km));
                break;
                
                case 2:
                    for(i=0;i<a.size();i++)
                    {
                        testo=a.get(i).toString();
                        System.out.println(testo);
                    }
                break;
            }
        } while(sc!=0);
    }
}