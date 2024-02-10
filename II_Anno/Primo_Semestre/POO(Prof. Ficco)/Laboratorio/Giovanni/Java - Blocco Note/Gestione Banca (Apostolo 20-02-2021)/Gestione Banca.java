package gestionebanca;
import java.util.Scanner;
public class GestioneBanca 
{
    public static void main(String[] args) 
    {
        Scanner in=new Scanner(System.in);
        int per=0, imp, i, c=0;
        String nome, cognome;
        char o='c';
        Banca[] b=new Banca[5];
        int sc;
        do
        {
            System.out.println("0) Esci");
            System.out.println("1) Entrata Cliente");
            System.out.println("2) Stampa Elenco Clienti");
            System.out.println("3) Uscita Cliente ");
            System.out.println("4) Ricerca Cliente per Cognome");
            System.out.println("5) Uscita Cliente (In fila)");
            sc=in.nextInt();
            switch(sc)
            {
                case 1:
                    if(per==5)
                        System.out.println("Banca Piena");
                    else
                    {
                        System.out.println("Inserisci il nome");
                        nome=in.next();
                        System.out.println("Inserisci il cognome");
                        cognome=in.next();
                        do{
                            System.out.println("Inserisci il tipo di operazione da fare (v o p)");
                            o=in.next().charAt(0);
                        }while(o!='v' && o!='p');
                        System.out.println("Inserisci l'importo");
                        imp=in.nextInt();
                        b[per]=new Banca(nome, cognome, o, imp);
                        per++;
                    }
                    System.out.println(" ");
                break;
             
                case 2:
                    if(per==0)
                        System.out.println("Banca Vuota");
                    else
                    {
                        System.out.println("Ci sono: " + per + " persone");
                        for(i=0;i<per;i++)
                            System.out.println((i+1) + ") " + b[i].toString());
                    }
                    System.out.println(" ");
                break;
             
                case 3:
                    if(per==0)
                        System.out.println("Banca Vuota");
                    else
                    {
                        for(i=0;i<per-1;i++)
                            b[i]=b[i+1];
                        per--;
                    }
                    System.out.println(" ");
                break;
             
                case 4:
                    if(per==0)
                        System.out.println("Banca Vuota");
                    else
                    {
                        System.out.println("Inserisci il cognome da ricercare");
                        cognome=in.next();
                        c=0;
                        for(i=0;i<per;i++)
                        {
                            if(cognome.equals(b[i].getCognome()))
                            {
                                System.out.println("Si trova nella posizione " + i);
                                c++;
                            }
                        }
                        if(c==0)
                            System.out.println("Persona non trovata");
                    }
                    System.out.println(" ");
                break;
                
                case 5:
                    if(per==0)
                        System.out.println("Banca Vuota");
                    else
                    {
                        do{
                        System.out.println("Quale Cliente si è scocciato?");
                        c=in.nextInt();
                        if(c>per)
                            System.out.println("Posizione Non Riconosciuta");
                        }while(c>per);
                        for(i=c;i<per-1;i++)
                            b[i]=b[i+1];
                        per--;
                    }
                    System.out.println(" ");
                break;
                
                case 0:
                    System.out.println("Uscita");
                break;
             
                default:
                    System.out.println("SCELTA NON RICONOSCIUTA");
            }
        }while(sc!=0);
    }
}