import java.util.Scanner;

public class Area
  {
    public static void main (String[] args)
    {
      System.out.println("Scegli Figura:\n 1. Quadrato\n 2. Triangolo");

      Scanner scan = new Scanner(System.in);

      int scelta = scan.nextInt();

      switch(scelta)
      {
        case 1:
          System.out.println("Inserisci il lato del Quadrato:");
          double lato = scan.nextDouble();

          Quadrato q1 = new Quadrato(lato);
          System.out.println("Area del Quadrato:");
          System.out.println(q1.calcoloArea());
          break;
        case 2:
          System.out.println("Inserisci l'altezza del Triangolo:");
          double altezza = scan.nextDouble();
          System.out.println("inserisci la base del Triangolo:");
          double base = scan.nextDouble();

          Triangolo t1 = new Triangolo(altezza, base);
          System.out.println("Area del triangolo:");
          System.out.println(t1.calcolo());
          break;

      }

    }
  }

class Triangolo
{
  double base;
  double altezza;
  
  public Triangolo(double base, double altezza)
  {
    this.base = base;
    this.altezza = altezza;
  }
  
  double calcolo()
  {
    return ((base * altezza) / 2);
  }
}

class Quadrato
{
  double lato;

  public Quadrato(double lato)
  {
    this.lato = lato;
  }

  double calcoloArea()
  {
    return (lato * lato);
  }

}

