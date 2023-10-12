public class Area
  {
    public static void main (String[] args)
  {
    Triangolo t1 = new Triangolo (10, 5);
    System.out.println("L'Area e': " + t1.calcolo());
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

