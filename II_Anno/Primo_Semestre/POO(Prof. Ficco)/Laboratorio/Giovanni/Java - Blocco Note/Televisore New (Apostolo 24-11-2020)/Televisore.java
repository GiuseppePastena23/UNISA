package televisore;
import java.util.Scanner;
public class Televisore 
{
    public static void main(String[] args) 
    {
        int scelta, stato=0, vol=0, can=1, appcan=1;
        Scanner s = new Scanner(System.in);
        televisione t = new televisione();
        do
        {
            System.out.println("1) Accendi");
            System.out.println("2) Spegni");
            System.out.println("3) Aumenta Volume");
            System.out.println("4) Diminuisci Volume");
            System.out.println("5) Cambia Canale");
            System.out.println("6) Aumenta Canale");
            System.out.println("7) Diminuisci Canale");
            System.out.println("8) Stampa Tutto");
            System.out.println("9) Esci");
            scelta=s.nextInt();
            switch(scelta)
            {
                case 1:
                    stato=t.accendi(stato);
                break;
               
                case 2: 
                    stato=t.spegni(stato);
                break;
                
                case 3: 
                    if(stato==1)
                        vol=t.aumvol(vol);
                    else
                        System.out.println("La televisione è spenta");
                    System.out.println("Il volume è: "+vol);
                break;
                
                case 4: 
                    if(stato==1)
                        vol=t.dimvol(vol);
                    else
                        System.out.println("La televisione è spenta");
                    System.out.println("Il volume è: "+vol);
                break;
                
                case 5: 
                   if(stato==1)
                    {
                        System.out.println("Scegli il canale, ora e' il canale: " + can); 
                        appcan=s.nextInt(); 
                        if(appcan>30)
                            System.out.println("Il canale massimo e' 30");
                        else
                        {
                            if(appcan<1)
                                System.out.println("Il canale minimo è 1");
                            else
                                can=t.camcan(appcan); 
                        }
                    }
                    else
                        System.out.println("Il televisore e' spento");
                break;
                
                case 6: 
                    if(stato==1)
                        can=t.aumcan(can);
                    else
                        System.out.println("Il televisore e' spento");
                    System.out.println("Ora e' il canale: " + can);
                break;
                
                case 7:
                    if(stato==1)
                        can=t.dimcan(can);
                    else
                        System.out.println("Il televisore e' spento");
                    System.out.println("Ora e' il canale: " + can);
                break;
                
                case 8:
                    System.out.println("Lo stato è: " +t.getStato());
                    System.out.println("Il volume è: " +t.getVolume());
                    System.out.println("Il canale è: " +t.getCanale());
                break;
                
                case 9:
                    System.out.println("Spegnimento");
                break;
                default: 
                    System.out.println("Scelta Sconosciuta");
            }
        }while(scelta!=9);
    }
}