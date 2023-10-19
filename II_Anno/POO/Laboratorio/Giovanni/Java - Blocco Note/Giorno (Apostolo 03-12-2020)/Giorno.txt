package pgiorno;
import java.util.Scanner;
public class Pgiorno
{
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        float temmax, temmin, sco, magg;
        int numgio, sc;
        String testo;
        System.out.println("Inserisci il numero del giorno");
        numgio=in.nextInt();
        System.out.println("Inserisci la temperatura massima");
        temmax=in.nextFloat();
        System.out.println("Inserisci la temperatura minima");
        temmin=in.nextFloat();
        giorno g=new giorno(numgio, temmax, temmin);
        do
        {
            System.out.println("1) Scostamento");
            System.out.println("2) Stampa");	
            System.out.println("3) Stampa temperatura massima");
            System.out.println("4) Media temperatura");
            System.out.println("5) Esci");
            sc=in.nextInt();
            switch(sc)
            {
                case 1:
                    sco=g.scostamento();
                    System.out.println("Lo scostamento è: "+sco);
                break;
                                
                case 2:
                    testo=g.toString();
                    System.out.println(testo);
                break;
                                
                case 3:
                    System.out.println("Inserire la temperatura da confrontare");
                    magg=in.nextFloat();
                    g.stampaMaggiore(magg);
                break;
                                
                case 4:
                    System.out.println("La temperatura media è: " + g.mediaG());
                break;
                                
                case 5:
                    System.out.println("Uscita");
                break;
                                      
                default:
                    System.out.println("SCELTA SCONOSCIUTA");
            }
        }while(sc!=5);
    }
}  