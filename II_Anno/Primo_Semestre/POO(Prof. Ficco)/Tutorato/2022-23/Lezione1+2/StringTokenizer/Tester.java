import java.util.Vector;

public class Tester {

	public static void main(String[] args) 
	{
		Soldato s1 = new Soldato("Markov",1);
		Soldato s2 = new Soldato("Charlie",5);
		
		SoldatoScelto s3 = new SoldatoScelto("Alpha",10,"Cecchino",5);
		SoldatoScelto s4 = new SoldatoScelto("Beta",11,"Pilota terrestre",10);
		
		Vector<Soldato> list = new Vector<Soldato>();
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s1);
		
		EsercitoManager manager = new EsercitoManager();
		manager.setSoldati(list);
		
		manager.saveSoldati("soldati.txt");
		
		System.out.println("\n\nStampa soldati dalla lista\n\n");
		for(Soldato s : manager.getSoldati()) System.out.println(s);
		
		System.out.println("\n\nStampa soldati con l'aiuto di StringTokenizer\n\n");
		manager.readSoldati("soldati.txt");

	}

}
