package voto_studenti;
import java.util.Scanner;
public class Voto_studenti
{
    public static void main(String[] args)
    {
	Scanner in=new Scanner(System.in);
	String nome;
	int sc;
	System.out.println("Inserisci il nome");
	nome=in.next();
	studente s=new studente(nome);
	do
	{
	    System.out.println("1) Inserisci voto");
            System.out.println("2) Voto Massimo");	
            System.out.println("3) Stampa");
	    System.out.println("4) Media");
	    System.out.println("5) Insufficienze");
	    System.out.println("6) Esci");
	    sc=in.nextInt();
	    switch(sc)
	    {
		case 1:
		    if(s.getN()<10)
		    {
		        System.out.println("Inserisci il voto");
		        s.inserisciVoto(in.nextInt());
		    }
		    else
			System.out.println("Vettore Full");
		break;

		case 2:
		    System.out.println("Il voto massimo è: " + s.votoMassimo());
		break;
	
		case 3:
		    System.out.println(s.toString());
		break;

		case 4:
		    if(s.promosso()>=6)
			System.out.println("Promosso, la media è: " + s.promosso());
		    else
			System.out.println("Bocciato, la media è: " + s.promosso());
		break;

		case 5:
		    System.out.println("Lo studente ha: " + s.insufficienze());
		break;
		
		case 6:
		    System.out.println("Uscita");
		break;

		default:
		    System.out.println("SCELTA SCONOSCIUTA");
	    }
	}while(sc!=6);
    }
}

