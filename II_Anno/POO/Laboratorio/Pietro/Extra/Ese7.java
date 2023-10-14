//Classe TrafficLight con attributi colore e durata
//E metodi per cambiare colore e controllare che sia rosso o verde

class TrafficLight {
	private String color;
	private int duration;
	//Costruttore
	public TrafficLight (String color, int duration) {
		this.color = color;
		this.duration = duration;
	}
	//Cambio e controllo del colore
	public void changeColor (String newColor) {
		color = newColor;
	}
	public boolean isRed() {
		return color.equals ("red");	//controlla che le due stringhe siano uguali carattere per carattere
	}
	public boolean isGreen() {
		return color.equals ("green");
	}
	//Operazioni sulla durata
	public int getDuration() {
		return duration;
	}
	public void setDuration (int duration) {
		this.duration = duration;
	}
}

public class Ese7 {
	public static void main (String[] args) {
		TrafficLight tl1 = new TrafficLight ("red", 30);
		
		System.out.println ("The light is red: " + tl1.isRed());
		System.out.println ("The light is green: " + tl1.isGreen());
		
		tl1.changeColor ("green");
		
		System.out.println ("The light is now green: " + tl1.isGreen());
		System.out.println ("The light duration is: " + tl1.getDuration());
		tl1.setDuration (20);
		System.out.println ("The light duration is now: " + tl1.getDuration());
	}
}