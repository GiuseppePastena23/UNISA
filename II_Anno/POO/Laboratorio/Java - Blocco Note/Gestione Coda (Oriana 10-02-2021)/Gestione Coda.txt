package gestionecoda;
import java.util.Scanner;
public class GestioneCoda 
{
    public static void main(String[] args) 
    {
        Scanner in=new Scanner(System.in);
        int num, dim;
        System.out.println("Inserisci quanto è grande la coda");
        dim=in.nextInt();
        Coda c=new Coda(dim);
        int sc;
        do
        {
            System.out.println("1) Inserisci un elemento");
            System.out.println("2) Elimina un elemento");
            System.out.println("3) Stampa");
            System.out.println("4) Esci");
            sc=in.nextInt();
            switch(sc)
            {
                case 1:
                    if(c.getGra()==5)
                        System.out.println("Coda piena");
                    else
                    {
                        System.out.println("Inserisci l'elemento");
                        num=in.nextInt();
                        c.inserisci(num);
                    }
                break;
             
                case 2:
                    c.elimina();
                break;
             
                case 3:
                    System.out.println("La pila è :\n" + c.toString());
                break;
             
                case 4:
                    System.out.println("Uscita");
                break;
             
                default:
                    System.out.println("SCELTA NON RICONOSCIUTA");
            }
        }while(sc!=4);
    }
}