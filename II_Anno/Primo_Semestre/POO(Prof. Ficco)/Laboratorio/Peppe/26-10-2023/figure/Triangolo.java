package figure;

public class Triangolo
{
  protected double base;
  private double altezza;
  
  public Triangolo(double base, double altezza)
  {
    this.base = base;
    this.altezza = altezza;
  }
  
  public double calcolo()
  {
    return ((base * altezza) / 2);
  }
  

}

