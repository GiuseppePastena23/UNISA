package geometria;

public class Quadrato {
	double lato;
	//Costruttore
	public Quadrato (double lato) {
		this.lato = lato;
	}
	//Metodi di calcolo
	public double calcoloArea() {
		return (lato * lato);
	}
	public double calcoloPerimetro() {
		return (lato * 4);
	}
}