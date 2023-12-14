package geometria;

public class ExtendedTriangle extends Triangolo {
    private double l1;
    private double l2;
    private double l3;
    
    public ExtendedTriangle(double base, double altezza, double l1, double l2, double l3) {
        super(base, altezza);
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
    }

    public double perimetro() {
        return l1 + l2 + l3;
    }
}
