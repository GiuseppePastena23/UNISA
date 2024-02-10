package gestionemetodi;
import java.util.Scanner;
public class GestioneMetodi 
{
    public static float Divisione(float a, float b)
    {
        return a/b;
    }
    
    public static void main(String[] args) 
    {
        Scanner in=new Scanner(System.in);
        Operazioni o=new Operazioni();
        int sc, a, b;
        do
        {
            System.out.println("0) Uscita");
            System.out.println("1) Somma");
            System.out.println("2) Differenza");
            System.out.println("3) Prodotto");
            System.out.println("4) Divisione");
            System.out.println("5) Potenza");
            sc=in.nextInt();
            switch(sc)
            {
                case 0:
                    System.out.println("Uscita");
                break;
                
                default:
                    System.out.println("SCELTA SCONOSCIUTA");
                break;
                
                case 1:
                    System.out.println("Inserisci per la somma");
                    a=in.nextInt();
                    b=in.nextInt();
                    System.out.println("La somma è: " + o.Somma(a, b)); //Chiamata al metodo associato all'oggeto (o)
                break;
            
                case 2:
                    System.out.println("Inserisci per la differenza");
                    a=in.nextInt();
                    b=in.nextInt();
                    System.out.println("La differenza è: " + o.Differenza(a, b)); //Chiamata al metodo associato all'oggeto (o)
                break;
                
                case 3:
                    System.out.println("Inserisci per il prodotto");
                    a=in.nextInt();
                    b=in.nextInt();
                    System.out.println("Il prodotto è: " + Operazioni.Prodotto(a, b)); //Chiamata metodo statico per nome classe
                break;
                
                case 4:
                    System.out.println("Inserisci per la divisione");
                    a=in.nextInt();
                    b=in.nextInt();
                    System.out.println("La divisione è: " + Divisione(a, b)); //Chiamata metodo statico nel main senza nome del main
                break;
                
                case 5:
                    System.out.println("Inserisci per la potenza");
                    a=in.nextInt();
                    b=in.nextInt();
                    System.out.println("La potenza è: " + Math.pow(a, b)); //Chiamata metodo statico della classe Math
                break;
            }
        }while(sc!=0);
    }
}

CLASSE

package gestionemetodi;
public class Operazioni 
{
    private float a;
    private float b;
    
    public float Somma(float a, float b)
    {
        this.a=a;
        this.b=b;
        return this.a+this.b;
    }
    
    public float Differenza(float a, float b)
    {
        this.a=a;
        this.b=b;
        return this.a-this.b;
    }
    
    public static float Prodotto(float a, float b)
    {
        return a*b;
    }
}