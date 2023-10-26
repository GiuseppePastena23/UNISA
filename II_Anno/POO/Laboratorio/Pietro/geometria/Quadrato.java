public class Quadrato {
	double lato;
	//Costruttore
	public Quadrato (double lato) {
		this.lato = lato;
	}
	//Metodi di calcolo
	double calcoloArea() {
		return (lato * lato);
	}
	double calcoloPerimetro() {
		return (lato * 4);
	}
}