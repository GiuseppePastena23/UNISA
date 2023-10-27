package geometria;

public class Triangolo {
	public double base, altezza, l1, l2, l3;
	//Costruttore
	public Triangolo (double base, double altezza) {
		this.base = base;
		this.altezza = altezza;
	}
	public double calcoloArea() {
		return ((base * altezza) / 2);
	}
}