//Crea una classe Cerchio con un attributo raggio, accessibile e modificabile
//Calcola area e circonferenza del cerchio

class Cerchio {
	double raggio;
	
	public Cerchio (double raggio) {
		this.raggio = raggio;
	}
	
	public double getRaggio () {
		return raggio;
	}
	
	public void setRaggio (double raggio) {
		this.raggio = raggio;
	}
	
	public double calcoloArea () {
		return (Math.PI * raggio * raggio);
	}
	
	public double calcoloCirconferenza () {
		return (Math.PI * 2 * raggio);
	}
}

public class Ese3 {
	public static void main (String[] args) {
		Cerchio c1 = new Cerchio (5);
		System.out.println ("Informazioni del cerchio:");
		System.out.println ("Raggio: " + c1.getRaggio ());
		System.out.println ("Circonferenza: " + c1.calcoloCirconferenza ());
		System.out.println ("Area: " + c1.calcoloArea ());
		c1.setRaggio (8);
		System.out.println ("Informazioni del cerchio:");
		System.out.println ("Raggio: " + c1.getRaggio ());
		System.out.println ("Circonferenza: " + c1.calcoloCirconferenza ());
		System.out.println ("Area: " + c1.calcoloArea ());
	}
}