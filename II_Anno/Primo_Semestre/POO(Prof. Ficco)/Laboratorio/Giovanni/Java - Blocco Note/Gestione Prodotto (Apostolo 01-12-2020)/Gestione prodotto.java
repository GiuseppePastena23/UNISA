package gestioneprodotto;
import java.util.Scanner;
public class Gestioneprodotto 
{
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
	String testo;
        int cod, ven;
        String des;
        float pre;
        int sc, sco, agg;
        System.out.println("Inserisci il codice del prodotto");
        cod=in.nextInt();
        System.out.println("Inserisci il prezzo del prodotto");
        pre=in.nextFloat();
        System.out.println("Inserisci il numeri dei prodotti venduti");
        ven=in.nextInt();
        System.out.println("Inserisci la descrizione del prodotto");
        des=in.next();
        prodotto t=new prodotto(cod, pre, ven, des);
        do
        {
            System.out.println("1) Sconto");
            System.out.println("2) Guadagno");
            System.out.println("3) Stampa");
            System.out.println("4) Aggiungi pezzi venduti");
            System.out.println("5) Esci");
            sc=in.nextInt();
            switch(sc)
            {
                case 1:
                   System.out.println("Inserisci lo sconto da fare"); 
                   sco=in.nextInt();
                   t.Sconto(sco);
                break;
                
                case 2:
                    System.out.println("Il guadagno è: " + t.Guadagno());
                break;
                
                case 3:
                    testo=t.toString();
                    System.out.println(testo);
                break;
                
                case 4:
                    System.out.println("Inserisci i pezzi venduti in più");
                    agg=in.nextInt();
                    t.Aggiungi(agg);
                break;
                
                case 5:
                    System.out.println("Uscita");
                break;
                
                default:
                    System.out.println("Scelta non riconosciuta");
                break;
            }
        }while(sc!=5);
    }
}