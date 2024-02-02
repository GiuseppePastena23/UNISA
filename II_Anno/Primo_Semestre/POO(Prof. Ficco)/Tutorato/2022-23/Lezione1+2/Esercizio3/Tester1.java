package test;

import core.Paninoteca;
import core.Locale;
import core.Pizzeria;
import core.LocaliManager;

import java.io.IOException;
import java.util.*;

public class Tester1 {

	public static void main(String[] args) throws IOException 
	{
		Paninoteca p1 = new Paninoteca("Panino Figo", "Via della fame n. 7", 30, 40, 20);
		Paninoteca p2 = new Paninoteca("Paniniamo", "Via del cibo n. 22", 10, 20, 10);

		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("Margherita", 7);
		map.put("Diavola", 8);
		
		HashMap<String,Integer> map2 = new HashMap<String,Integer>();
		map2.put("Mais", 5);
		map2.put("Diavola", 6);
		
		Pizzeria p3 = new Pizzeria("Speedy Pizza", "Corso degli alberghi", 20);
		p3.setMenu(map);
		Pizzeria p4 = new Pizzeria("Pizziamo", "Corso Europa", 0);
		p4.setMenu(map2);
		
		HashMap<Integer,Locale> list = new HashMap<Integer,Locale>();
		list.put(p1.hashCode(),p1);
		list.put(p2.hashCode(),p2);
		list.put(p3.hashCode(),p3);
		list.put(p4.hashCode(),p4);
		
		LocaliManager manager = new LocaliManager();
		manager.setLocali(list);
		
		manager.printInfo();
		System.out.println("\n\n");

		Paninoteca p5 = new Paninoteca("Panino Figo", "Via della fame n. 7", 0, 0, 0);
		manager.registraLocale(p5);
		manager.printInfo();
		System.out.println("\n\n");
		
		Paninoteca p6 = new Paninoteca("Pub&Beer", "Via del grano n. 22", 20, 20, 20);
		manager.registraLocale(p6);
		manager.printInfo();
		System.out.println("\n\n");
		
		String key = "Diavola";
		System.out.println("Pizzerie che preparano la pizza: " + key + "\n");
		
		manager.printPizzerieByPizza(key);
		
		System.out.println("\n\n");
		manager.prenotazione(4, p6);
		manager.printInfo();
		System.out.println("\n\n");
		manager.prenotazione(4, p4);
		manager.printInfo();
		System.out.println("\n\n");
		manager.prenotazione(16, p6);
		manager.printInfo();
		System.out.println("\n\n");
		manager.prenotazione(1, p6);
		manager.printInfo();
		System.out.println("\n\n");
		
		System.out.println("Salvo tutti i locali senza posti a sedere");
		manager.saveLocaliFull("locali_full.txt");
		
		System.out.println("\n\nAggiungo paninoteche e pizzerie da file");
		manager.readPizzerie("Pizzerie.txt");
		manager.readPaninoteche("Paninoteche.txt");
		manager.printInfo();
		
		System.out.println("\n\nRi-Aggiungo paninoteche e pizzerie da file");
		manager.readPizzerie("Pizzerie.txt");
		manager.readPaninoteche("Paninoteche.txt");
		manager.printInfo();
	}

}
