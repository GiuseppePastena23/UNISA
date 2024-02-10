package poligoni;
import java.util.Scanner;
public class Poligoni {

    public static void main(String[] args){
       int scelta, pol;
       int n1, n2, n3;
       int p;
       boolean b=true;
       boolean a=true;
       Scanner s = new Scanner(System.in);
       while (b)
       {
         System.out.println("Che tipo di poligono vuoi costruire?");
         System.out.println("1 quadrato");
         System.out.println("2 triangolo");
         System.out.println("3 per uscire");
         System.out.println("Fai una scelta");
         scelta =s.nextInt();
       
         if(scelta == 1)
         {
             System.out.println("QUADRATO");
             System.out.println("Dammi il lato del quadrato");
             n1 =s.nextInt();
             quadrato t = new quadrato(n1);
             p = t.perimetro();
             System.out.println("Perimetro = " + p);
             b=false;
         }
         else if(scelta == 2)
         {
             while(a)
             {
                 System.out.println("1 isoscele");
                 System.out.println("2 equilatero");
                 System.out.println("3 scaleno");
                 System.out.println("4 per uscire");
                 System.out.println("Fai una scelta");
                 pol =s.nextInt();
             if(pol==1)
             {
                 System.out.println("TRIANGOLO ISOSCELE");
                 System.out.println("Dammi il lato obliquo triangolo");
                 n1 =s.nextInt();
                 System.out.println("Dammi la base del triangolo");
                 n2 =s.nextInt();
                 triangolo t = new triangolo(n1, n2);
                 p = t.perimetro();
                 System.out.println("Perimetro = " + p);
                 a=false;
                 b=false;
             }
             else if(pol==2)
             {
                 System.out.println("TRIANGOLO EQUILATERO");
                 System.out.println("Dammi il lato triangolo");
                 n1 =s.nextInt();         
                 triangolo t = new triangolo(n1);
                 p = t.perimetro();
                 System.out.println("Perimetro = " + p);
                 b=false;
                 a=false;
             }
            else if(pol==3)
            {
                 System.out.println("TRIANGOLO SCALENO");
                 System.out.println("Dammi il primo lato del triangolo");
                 n1 =s.nextInt();
                 System.out.println("Dammi il secondo lato del triangolo");
                 n2 =s.nextInt();   
                 System.out.println("Dammi il terzo lato del triangolo");
                 n3 =s.nextInt();
                 triangolo t = new triangolo(n1,n2,n3);
                 p = t.perimetro();
                 System.out.println("Perimetro = " + p);
                 b=false;
                 a=false;
            }
            else if(pol==4)
            {
                 System.out.println("EXIT");
                 System.exit(0);
             }
             else       
                 System.out.println("SCELTA SCONOSCIUTA");
            }
         }
         else if(scelta == 3)
         {
             System.out.println("EXIT");
             System.exit(0);
         }
         else
             System.out.println("SCELTA SCONOSCIUTA");
        }
    }
}