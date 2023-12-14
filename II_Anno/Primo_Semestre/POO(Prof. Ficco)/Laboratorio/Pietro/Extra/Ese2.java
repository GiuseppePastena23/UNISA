//Crea una classe Cane con nome e razza e creane due istanze usando il costruttore
//Modifica gli attributi con i metodi Set e stampa i nuovi valori

class Cane {
	String name;
	String breed;
	
	public Cane (String name, String breed) {
		this.name = name;
		this.breed = breed;
	}
	
	public String getName () {
		return name;
	}
	
	public String getBreed () {
		return breed;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public void setBreed (String breed) {
		this.breed = breed;
	}
}

public class Ese2 {
	public static void main (String[] args) {
		Cane c1 = new Cane ("Bill", "Billdog");
		Cane c2 = new Cane ("Jocob", "Labrador");
		c1.setBreed ("Bulldog");
		c2.setName ("Jacob");
		System.out.println (c1.getName () + " è un " + c1.getBreed ());
		System.out.println (c2.getName () + " è un " + c2.getBreed ());
	}
}