package geometria;

public class Triangolo {
	double base, altezza, l2, l3;
	//Costruttore
	public Triangolo (double base, double altezza, double l2, double l3) {
		this.base = base;
		this.altezza = altezza;
		this.l2 = l2;
		this.l3 = l3;
	}
	//Metodi di calcolo
	public double calcoloArea() {
		return ((base * altezza) / 2);
	}
	public double calcoloPerimetro() {
		return (base + l2 + l3);
	}
}