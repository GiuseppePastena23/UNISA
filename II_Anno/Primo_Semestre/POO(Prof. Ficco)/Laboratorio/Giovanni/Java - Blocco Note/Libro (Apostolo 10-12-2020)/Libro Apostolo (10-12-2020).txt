package biblioteca;
import java.util.Scanner;
public class Biblioteca
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		int cod, numcop;
		String titolo;
		float prezzo;
		System.out.println("Inserisci il codice");
		cod=in.nextInt();
		System.out.println("Inserisci il numero delle copie");
		numcop=in.nextINt();
		System.out.println("Inserisci il titolo");
		titolo=in.next();
		System.out.println("Inserisci il prezzo");
		prezzo=in.nextFloat();
		libro l=new libro(cod, titolo, numcop, prezzo);
		do
     		{
            		System.out.println("1) Stampa");
           		System.out.println("2) Prestito");	
           		System.out.println("3) Reso");
			System.out.println("4) Esci");
			sc=in.nextInt();
            		switch(sc)
            		{
                		case 1:
                    			System.out.println(l.toString());
                		break;
                                
                		case 2:
					l.prestito();
                		break;
                                	
				case 3:
                    			l.reso();
                		break;
                                
                		case 4:
					System.out.println("Uscita");
                    		break;
			
				default:
					System.out.println("SCELTA SCONOSCIUTA");
			}
		}while(sc!=4);