-package figure;

public class Triangolo_esteso extends Triangolo {
  private double l2;
  private double l3;

  public Triangolo_esteso(double base, double altezza, double l2, double l3){
    super(base, altezza);
    this.l2 = l2;
    this.l3 = l3;
  }

  public double perimetro(){
    return base + l2 + l3;
  }
}

