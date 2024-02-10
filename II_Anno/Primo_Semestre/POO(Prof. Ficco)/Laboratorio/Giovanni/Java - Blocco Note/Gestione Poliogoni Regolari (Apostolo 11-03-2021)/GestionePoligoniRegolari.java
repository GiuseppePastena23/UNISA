package gestionepoligoniregolari;
import java.util.Scanner;
public class GestionePoligoniRegolari 
{
    public static void main(String[] args) 
    {
        Scanner in=new Scanner (System.in);
        Triangolo t;
        Quadrato q;
        Pentagono p;
        int sc;
        double lato;
        do
        {
            System.out.println("0) Uscita");
            System.out.println("1) Perimetro Triangolo");
            System.out.println("2) Perimetro Quadrato");
            System.out.println("3) Perimetro Pentagono");
            System.out.println("4) Area Triangolo");
            System.out.println("5) Area Quadrato");
            System.out.println("6) Area Pentagono");
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
                    System.out.println("Inserire lato del triangolo");
                    lato=in.nextDouble();
                    t=new Triangolo(lato);
                    System.out.println("Il perimetro del triangolo è " + t.perimetro());
                break;
            
                case 2:
                    System.out.println("Inserire lato del quadrato");
                    lato=in.nextDouble();
                    q=new Quadrato(lato);
                    System.out.println("Il perimetro del quadrato è " + q.perimetro());
                break;
            
                case 3:
                    System.out.println("Inserire lato del pentagono");
                    lato=in.nextDouble();
                    p=new Pentagono(lato);
                    System.out.println("Il perimetro del pentagono è " + p.perimetro());
                break;
            
                case 4:
                    System.out.println("Inserire lato del triangolo");
                    lato=in.nextDouble();
                    t=new Triangolo(lato);
                    System.out.println("L'area del triangolo è " + t.area());
                break;
            
                case 5:
                    System.out.println("Inserire lato del quadrato");
                    lato=in.nextDouble();
                    q=new Quadrato(lato);
                    System.out.println("L'area del quadrato è " + q.area());
                break;
            
                case 6:
                    System.out.println("Inserire lato del pentagono");
                    lato=in.nextDouble();
                    p=new Pentagono(lato);
                    System.out.println("Il perimetro del pentagono è " + p.area());
                break;
            }
        }while(sc!=0);
    }
}