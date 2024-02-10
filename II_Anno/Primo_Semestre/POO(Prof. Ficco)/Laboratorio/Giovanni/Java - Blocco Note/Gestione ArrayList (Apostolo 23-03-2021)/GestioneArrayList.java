package gestionearraylist;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class GestioneArrayList {
	public static void main(String[] args) {
		ArrayList <String> Persone = new ArrayList <>();
		Scanner in = new Scanner(System.in);
		int i, cont = 0;
		String app, nome;
		Persone.add("Giovanni");
		Persone.add("Daniele");
		Persone.add("Vincenzo");
		System.out.println(Persone);
		Persone.add(1, "Raffaele");
		System.out.println(Persone);
		Persone.set(0, "Giovanna");
		System.out.println(Persone);
		Persone.remove(3);
		System.out.println(Persone);
		Collections.sort(Persone);
		System.out.println(Persone);
		for(i = 0; i < Persone.size(); i++) {
			app = Persone.get(i);
			System.out.println("Persona n " + i + " = " + app);
		}
		if(!Persone.isEmpty()) {
			System.out.println("Inserire il nome");
			nome = in.next();
			for(i = 0; i < Persone.size(); i++) {
				if(nome.equals(Persone.get(i))) {
					cont++;
					System.out.println("Persona trovata alla posizione: " + i);
				}
			}
			if(cont == 0)
				System.out.println("Persona non trovata");
		}
		Persone.clear();
		if(! Persone.isEmpty())
			System.out.println("Array Pieno");
		else
			System.out.println("Array Vuoto");
	}
}