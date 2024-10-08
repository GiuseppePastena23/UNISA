package gestionebiglietti;
import java.util.Scanner;
public class Gestionebiglietti
{
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        String nomeF, codice;
        float costo;
        int nBiglietti, aggbig, sc, stato, combig;
        System.out.println("Inserisci il codice");
        codice=in.next();
        System.out.println("Inserisci il nome della fermata");
	nomeF=in.next();
	System.out.println("Inserisci il costo");
	costo=in.nextFloat();
	System.out.println("Inserisci il numero dei biglietti nel distributore");
	nBiglietti=in.nextInt();
	distributorebiglietti d=new distributorebiglietti(codice, nomeF, nBiglietti, costo);
	do
	{
            System.out.println("1) Ricarica");
            System.out.println("2) Vendita");	
            System.out.println("3) Ripara");
            System.out.println("4) Stampa");
            System.out.println("5) Esci");
            sc=in.nextInt();
            switch(sc)
            {
		case 1:
                    System.out.println("Aggiungi i biglietti");
                    aggbig=in.nextInt();
                    if((nBiglietti+aggbig)>1000)
                        System.out.println("Capienza insufficiente");
                    else
			nBiglietti=d.ricarica(aggbig);
                    System.out.println("Ci sono: " + nBiglietti + " biglietti");
		break;
		
		case 2:
                    if(d.getStato()==0)
                        System.out.println("Il distributore è spento");
                    else
                    {
			System.out.println("Inserisci i biglietti da comprare");	
			combig=in.nextInt();
			if(d.getnBiglietti()<combig)
                            System.out.println("Biglietti insufficienti");
			else
                            System.out.println("Il costo totale è: " + d.vendi(combig));
                    }
		break;
                
                case 3:
                    d.ripara();
                break;
                
                case 4:
                    System.out.println(d.toString());
                break;
                
                case 5:
                    System.out.println("Uscita");
                break;
                
                default:
                    System.out.println("SCELTA SCONOSCIUTA");
            }
	}while(5!=0);
    }
}