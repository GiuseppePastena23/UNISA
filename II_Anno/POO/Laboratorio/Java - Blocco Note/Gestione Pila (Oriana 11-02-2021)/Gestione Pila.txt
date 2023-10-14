package gestione.pila;
import java.util.Scanner;
public class GestionePila 
{
    public static void main(String[] args) 
    {
        Scanner in=new Scanner(System.in);
        int num, dim;
        System.out.println("Inserisci quanto è grande la pila");
        dim=in.nextInt();
        Pila p=new Pila(dim);
        int sc;
        do
        {
            System.out.println("1) Inserisci un elemento");
            System.out.println("2) Elimina un elemento");
            System.out.println("3) Stampa");
            System.out.println("5) Esci");
            sc=in.nextInt();
            switch(sc)
            {
                case 1:
                    if(p.getD()==dim)
                        System.out.println("Pila piena");
                    else
                    {
                        System.out.println("Inserisci l'elemento");
                        num=in.nextInt();
                        p.inserisci(num);
                    }
                break;
             
                case 2:
                    p.elimina();
                break;
             
                case 3:
                    System.out.println("La pila è :\n"+p.toString());
                break;
             
                case 4:
                    System.out.println("L'elemento top è: "+p.top());
                break;
                
                case 5:
                    System.out.println("Uscita");
                break;
             
                default:
                    System.out.println("SCELTA NON RICONOSCIUTA");
            }
        }while(sc!=5);
    } 
}