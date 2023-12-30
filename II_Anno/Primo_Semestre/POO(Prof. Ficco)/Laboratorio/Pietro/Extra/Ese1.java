//Scrivere un programma che crei una classe Persona con nome ed età come attributi
//Creare due istanze di Persona, settare gli attributi con il costruttore e stampare nome ed età

//import java.util.Scanner;

class Persona {
	String name;
	int age;
	
	public Persona (String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName () {
		return name;
	}
	
	public int getAge () {
		return age;
	}
}

public class Ese1 {
	public static void main (String[] args) {
		Persona p1 = new Persona ("Pietro D'Antuono", 20);
		Persona p2 = new Persona ("Olivier Giroud", 37);
		System.out.println (p1.getName () + " ha " + p1.getAge () + " anni");
		System.out.println (p2.getName () + " ha " + p2.getAge () + " anni");
	}
}