package test;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

import core.Autovettura;
import core.Camion;
import core.Macchina;

//3 Punti
public class Test {

	public static void main(String[] args) 
	{
		ArrayList<Autovettura> lista = new ArrayList<Autovettura>();
		
		Camion c1 = new Camion(2.0, 0, 8000, "T10001T", 6, "Camion", 6, 2000, "Rosso");
		Camion c2 = new Camion(1.5, 0, 5000, "T20002T", 5, "Camion", 6, 2000, "Blu");
		c1.setLimVel(100);
		c2.setLimVel(130);
		c2.setPesoMax(5001);
		
		Macchina m1 = new Macchina("T30003T", 5, "Macchina", 4, 1200, "Verde");
		Macchina m2 = new Macchina("T40004T", 5, "Macchina", 4, 1400, "Grigio");
		
		lista.add(c1);
		lista.add(c2);
		lista.add(m1);
		lista.add(m2);
		
		PrintWriter out = null;
		
		try
		{
			out = new PrintWriter(new BufferedWriter(new FileWriter("autovetture.txt")));
			
			for(Autovettura a : lista) out.println(a);
			out.close();
		}
		catch(EOFException e)
		{
			System.out.println("Fine stream\n\n");
			out.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			out.close();
		}
		
		
		System.out.println("Stampo matricola dei Camion con espressione lambda\n\n");
		
		Predicate<Autovettura> pred = a -> a instanceof Camion;
		
		Consumer<Autovettura> block = (a) -> {
			
			Macchina app = (Macchina) a;
			System.out.println(app.getMatricola());
		};
		
		printMatricolaCamion(lista,pred,block);
		
		System.out.println("\n\nStampo numero di Camion con peso maggiore di 5t e limite velocita' maggiore di 80\n\n");
		
		Predicate<Autovettura> cond = (a) -> a instanceof Camion && ((Camion ) a).getPesoMax() > 5000 &&  ((Camion ) a).getLimVel() > 80;
		
		System.out.println(countCamionByCondition(lista,cond));
		
		System.out.println("\n\nStampo numero di Macchine con almeno 6 marce\n\n");
		
		printMacchineByMarce(lista,6);
	}
	
	public static void printMatricolaCamion(ArrayList<Autovettura> auto,Predicate<Autovettura> cond,Consumer<Autovettura> block)
	{
		for(Autovettura a : auto) if(cond.test(a)) block.accept(a);
	}
	
	public static int countCamionByCondition(ArrayList<Autovettura> auto,Predicate<Autovettura> cond)
	{
		return (int) auto.stream().filter(cond).count();
	}
	
	public static void printMacchineByMarce(ArrayList<Autovettura> auto,int numMarce)
	{
		auto.stream().filter(a -> a instanceof Macchina && ((Macchina) a).getNumMarce() >= numMarce).forEach(System.out::println);
	}

}
