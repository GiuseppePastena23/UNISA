package figure;

public class Triangolo
{
  private double base;
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
  
  @Override
  public String toString() 
  {
  	return String.valueOf(calcolo());	 
  }
}
