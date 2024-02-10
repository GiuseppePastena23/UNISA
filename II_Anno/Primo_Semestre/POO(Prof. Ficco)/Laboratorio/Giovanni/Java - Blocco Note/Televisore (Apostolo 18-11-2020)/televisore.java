package televisore;
import java.util.Scanner;
public class Televisore 
{
    public static void main(String[] args) 
    {
        int scelta, acc=0, vol=0, can=1, appcan;
        Scanner s = new Scanner(System.in);
        do
        {
            System.out.println("1) Accendi");
            System.out.println("2) Spegni");
            System.out.println("3) Aumenta Volume");
            System.out.println("4) Diminuisci Volume");
            System.out.println("5) Cambia Canale");
            System.out.println("6) Per uscire");
            scelta=s.nextInt();
            switch(scelta)
            {
                case 1: 
                    accendi t=new accendi(acc); 
                    acc=t.accensione(); 
                break;
                
                case 2: 
                    spegni sp=new spegni(acc); 
                    acc=sp.spegnimento(); 
                    
                break;
                
                case 3: 
                    if(acc==1)
                    {
                        aumvol av=new aumvol(vol); 
                        vol=av.aumenta();
                        System.out.println("Ora il volume e': " + vol);
                    }
                    else
                    {
                        System.out.println("Il televisore e' spento");
                    } 
                break;
                
                case 4: 
                    if(acc==1)
                    {
                        dimvol dv=new dimvol(vol);
                        vol=dv.diminuisce();
                        System.out.println("Ora il volume e': " + vol);
                    }
                    else
                    {
                        System.out.println("Il televisore e' spento");
                    }
                break;
                
                case 5: 
                    if(acc==1)
                    {
                        System.out.println("Scegli il canale, ora e' il canale: " + can); 
                        appcan=s.nextInt(); 
                        if(appcan>30)
                        {
                            System.out.println("Il canale massimo e' 30");
                        }
                        else
                        {
                            if(appcan<1)
                            {
                                System.out.println("Il canale minimo è 1");
                            }
                            else
                            {
                                camcan cc=new camcan(appcan); 
                                can=cc.cambia();
                            }
                        }
                    }
                    else
                    {
                        System.out.println("Il televisore e' spento");
                    }
                break;
                
                case 6: 
                    System.out.println("Uscita effettuata"); 
                break;
                
                default: 
                    System.out.println("Scelta non riconosciuta");
                
            }
        }while(scelta!=6);
    }
}