package geometria;

public class Cerchio {
	double raggio;
	//Costruttore
	public Cerchio (double raggio) {
		this.raggio = raggio;
	}
	//Metodi di calcolo
	public double calcoloArea () {
		return (Math.PI * raggio * raggio);
	}
	public double calcoloCirconferenza () {
		return (Math.PI * 2 * raggio);
	}
}
