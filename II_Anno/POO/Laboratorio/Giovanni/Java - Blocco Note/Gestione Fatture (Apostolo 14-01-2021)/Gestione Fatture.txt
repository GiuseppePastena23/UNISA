package gestione_fatture;
import java.util.Scanner;
public class Gestione_fatture
{
    public static void main(String[] args)
    {
	Scanner in=new Scanner(System.in);
        int numero, deg, dem, dpg, dpm, sc, n, gm, mm, p=0, nf, gmm=0;
        double importo, maximp;
        int i=0;
	System.out.println("Inserisci quante fatture");
	n=in.nextInt();
        fatture[] f=new fatture[n];
        for(i=0;i<n;i++)
	{
	    System.out.println("Inserisci l'importo della fattura / " + (i+1));
	    importo=in.nextDouble();
	    System.out.println("Inserisci il giorno di emissione / " + (i+1));
	    deg=in.nextInt();
	    System.out.println("Inserisci il mese di emissione / " + (i+1));
	    dem=in.nextInt();
	    System.out.println("Inserisci il giorno di pagamento / " + (i+1));
	    dpg=in.nextInt();
	    System.out.println("Inserisci il mese di pagamento / " + (i+1));
	    dpm=in.nextInt();
            f[i]=new fatture(n, importo, deg, dem, dpg, dpm);
	}
        do
	{
            System.out.println("1) ");
            System.out.println("2) Stampa giorni mancanti al pagamento");	
            System.out.println("3) Stampa dei dati con l'importo massimo");
            System.out.println("4) Esci");
            sc=in.nextInt();
            switch(sc)
            {
		case 1:
                    
		break;
		
		case 2:
                    System.out.println("Inserisci il numero della fattura");
                    nf=in.nextInt();
                    System.out.println("Inserisci il giorno");
                    gm=in.nextInt();
                    System.out.println("Inserisci il mese");
                    mm=in.nextInt();
                    i=0;
                    if(mm<=12)
                    {
                        switch(mm)
                        {
                            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                                gmm=31;
                            break;
            
                            case 2:
                                System.out.println("Inserisci qualsiasi numero se è un anno bisestile");
                                i=in.nextInt();
                                if(i==0)
                                    gmm=28;
                                else
                                    gmm=29;
                            break;
            
                            case 4: case 6: case 9: case 11:
                                gmm=30;
                        }
                        if(gm<=gmm)
                            f[nf].numeroGiorni(gm, mm, gmm);
                        else
                            System.out.println("Giorno incorretto"); 
                    }
                    else
                        System.out.println("Mese incorretto");
		break;
                
                case 3:
                    maximp=f[p].getImporto();
                    for(i=0;i<n;i++)
                    {
                        if(maximp<f[i].getImporto())
                        {
                            maximp=f[i].getImporto();
                            p=i;
                        }
                    }
                    System.out.println(f[p].toString());
                break;

                case 4:
                    System.out.println("Uscita");
                break;
                
                default:
                    System.out.println("SCELTA SCONOSCIUTA");
            }
	}while(sc!=4);
    }
}