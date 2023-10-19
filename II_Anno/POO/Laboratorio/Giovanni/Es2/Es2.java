import java.lang.String;
import java.util.Scanner;

public class Es2
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        String Nome;
        int sc, Mat, per = 0, i;
        
        Studente[] S = new Studente[5];
        
        do
        {
            System.out.println("1) Registrazione");
            System.out.println("2) Stampa");	
            System.out.println("3) Esci");
            sc=in.nextInt();
            switch(sc)
            {
                case 1:
                    System.out.println("Inserisci il nome dello studente");
                    Nome = in.next();
                    System.out.println("Inserisci la matricola dello studente");
                    Mat = in.nextInt();
                    S[per] = new Studente(Nome, Mat);
                    per++;
                break;
                        
                case 2:
                    if(per == 0)
                        System.out.println("Nessun Studente");
                    else
                    {
                        System.out.println("Ci sono: " + per + " Studenti");
                        for(i = 0;i < per;i++)
                            System.out.println((i+1) + ") " + S[i].toString());
                    }
                    System.out.println(" ");
                break;
                      
                case 3:
                    System.out.println("Uscita");
                break;
                        
                default:
                    System.out.println("SCELTA SCONOSCIUTA");
            }
        }while(sc != 3;
    }    
}
