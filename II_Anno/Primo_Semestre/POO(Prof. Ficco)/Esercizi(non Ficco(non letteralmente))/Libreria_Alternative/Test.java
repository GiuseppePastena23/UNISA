package it.unisa.test;

import java.util.*;

import it.unisa.libreria.*;

public class Test {
	public static void main(String[] args) {
		Libreria lib = new Libreria();
//		lib.aggiungiLibro(new LibroScolastico("Scienze della terra", "Zanichelli", 300, Arrays.asList("1","2","3","4"), "Universita", "Uni", "CD1"));
//		lib.aggiungiLibro(new LibroScolastico("Basi di dati", "Atzeni", 700, Arrays.asList("1","2","3","4"), "Universita", "Uni", "AtzeniCD"));
//		lib.aggiungiLibro(new Volume("Cospirazioni", "Contrada", 540, Arrays.asList("1","2","3","4"), "Treccani", "Editore"));
//		lib.aggiungiLibro(new LibroScolastico("Cossimani per noi", "Trebbiacani", 123, Arrays.asList("1","2","3","5","7"), "Primaria", "Terza", "CD1"));
//		lib.aggiungiLibro(new Volume("Che ci faccio qui", "Daniele", 456, Arrays.asList("1","2","3","4"), "Mainente", "Rossella"));
//		System.out.println(lib.libriToString());
		lib.loadFromFile("libreria.txt");
		GUI gui = new GUI(lib);
		gui.setVisible(true);
	}
}
