package gestioneterreno;
import java.util.Scanner;
public class Gestioneterreno
{
    public static void main(String[] args)
    {
	Scanner in=new Scanner(System.in);
	int n, perc, sc, pos=0;
	boolean ind;
	double renditamq, estensione, med=0;
	String codice, cod;
	int i=0;
	System.out.println("Inserisci quanti terreni");
	n=in.nextInt();
	terreno[] t=new terreno[n];
	for(i=0;i<n;i++)
	{
	    System.out.println("Inserisci il codice del terreno / " + (i+1));
	    codice=in.next();
	    System.out.println("Inserisci l'estensione del terreno / " + (i+1));
	    estensione=in.nextDouble();
	    System.out.println("Inserisci la percentuale edificabile del terreno / " + (i+1));
	    perc=in.nextInt();
	    System.out.println("Inserisci la rendita in metri quadrati del terreno / " + (i+1));
	    renditamq=in.nextDouble();
	    t[i]=new terreno(codice, estensione, perc, renditamq);
	}
        do
	{
            System.out.println("1) Stampa dati del terreno max m^2");
            System.out.println("2) Stampa rendita media");	
            System.out.println("3) Stampa rendita totale e numero di metri quadrati di un terreno");
	    System.out.println("4) Controllo percentuale edificabile");
            System.out.println("5) Esci");
            sc=in.nextInt();
            switch(sc)
            {
		case 1:
                    double max=t[i].edificabile();
                    for(i=1;i<n;i++)
                    {
                        if(t[i].edificabile()>max)
                        {
                            max=t[i].edificabile();
                            pos=i;
                        }
                    }
                    System.out.println(t[pos].toString());
		break;
		
		case 2:
                    for(i=0;i<n;i++)
                    {
                        med=med+t[i].getRenditamq();
                    }
                    System.out.println("La media è: " + med/n);
		break;
                
                case 3:
                    System.out.println("Inserisci il codice del terreno da stampare");
                    cod=in.next();
                    ind=false;
                    for(i=0;i<n;i++)
                    {
                        if(cod==t[i].getCodice())
                        {
                            System.out.println(t[i].toString());
                            ind=true;
                        }
                    }
                    if(ind==false)
                        System.out.println("Terreno non trovato");
                break;

		case 4;
		    ind=false
		    for(i=0;i<n;i++)
		    {
			if(t[i].getPercentualeedificabile()>50 && t[i].getPercentualeedificabile()<80)
			{
			    System.out.println(t[i].toString());
			    ind=true;
			}
		    }
		    if(ind==false)
			System.out.println("Terreno/i non trovato/i");
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