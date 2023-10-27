package geometria;
//import Triangolo;

public class TriangoloEsteso extends Triangolo {
	public double b, l2, l3;
	//Costruttore
	public TriangoloEsteso (double b, double h, double l2, double l3) {
		super(b, h);
		this.b = b;
		this.l2 = l2;
		this.l3 = l3;
	}
	public double calcoloPerimetro() {
		return (b + l2 + l3);
	}
}