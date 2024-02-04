package gestionelistatrue;
import java.util.Scanner;
public class GestioneListaTrue 
{
    public static void main(String[] args) 
    {
        Scanner in=new Scanner(System.in);
        int num, dim, pos=0;
        System.out.println("Inserisci quanto è grande la lista");
        dim=in.nextInt();
        ListaTrue l=new ListaTrue(dim);
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
                    System.out.println("Inserisci la posizione in cui vuoi inserire il valore");
                    pos=in.nextInt();
                    System.out.println("Inserisci l'elemento");
                    num=in.nextInt();
                    l.inserisci(num, pos, dim);
                break;
                
                case 2:
                    System.out.println("Inserisci la posizione del valore da cancellare");
                    pos=in.nextInt();
                    l.elimina(pos,dim);
                break;
                
                case 3:
                    System.out.println(l.toString(dim));
               break;
            }
        }while(sc!=4);
    }
}