package test;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import core.Cavaliere;
import core.Gestore;
import core.Orco;
import core.Personaggio;
import gui.GUI;

public class Test 
{

	public static void main(String[] args) 
	{
		//Test della GUI
		GUI gui = new GUI("Prova - 02/02/2023");
		gui.setVisible(true);
		
		Gestore g = Gestore.creaGestore();
		
		//Esercizio 2
		System.out.println("\n\nPrint id di tutti gli Orchi\n\n");
		
		Predicate<Personaggio> pred = p -> p instanceof Orco;
		
		Consumer<Personaggio> block = p -> System.out.println(((Orco) p).getIdClass());
		
		printId(g.getPersonaggi(),pred,block);
		
		//Esercizio 3
		System.out.println("\n\nConteggio dei Cavalieri con la condizione richiesta\n\n");
		
		pred = p -> p.getEnergia() > 50 && p.getPosGioco() < 50;
		
		countByCond(g.getPersonaggi(),pred,Cavaliere.class);
		
		System.out.println("\n\nStampa id univoco di ogni Calavaliere data la condizione richiesta\n\n");
		
		pred = p -> p.getEnergia() > 70;
		
		Function<Personaggio,Integer> func = p -> ((Cavaliere) p).getIdClass();
		
		printIdByTipo(g.getPersonaggi(),pred,Cavaliere.class,func);
	}
	
	public static void printId(ArrayList<Personaggio> list, Predicate<Personaggio> pred, Consumer<Personaggio> block)
	{
		for(Personaggio p : list) if(pred.test(p)) block.accept(p);
	}
	
	public static <T> void countByCond(ArrayList<Personaggio> list, Predicate<Personaggio> pred,Class<T> classe)
	{
		System.out.println(list.stream().filter(classe::isInstance).filter(pred).count());
	}
	
	public static <T> void printIdByTipo(ArrayList<Personaggio> list, Predicate<Personaggio> pred,Class<T> classe,Function<Personaggio,Integer> func)
	{
		list.stream().filter(pred).filter(classe::isInstance).map(func).forEach(System.out::println);
	}
}
