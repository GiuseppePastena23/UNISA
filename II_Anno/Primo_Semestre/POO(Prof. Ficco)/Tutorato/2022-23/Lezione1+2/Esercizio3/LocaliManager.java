package core;
import java.util.Map;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import interfacce.LocaleOptions;

public class LocaliManager implements LocaleOptions
{
	public Map<Integer,Locale> locali;
	
	public LocaliManager()
	{
		this.locali = new HashMap<Integer,Locale>();
	}

	public Map<Integer,Locale> getLocali() {
		return locali;
	}

	public void setLocali(Map<Integer,Locale> locali) {
		this.locali = locali;
	}

	public void prenotazione(int numPersone, Locale l) 
	{
		boolean res = l.prenotazione(numPersone);
		
		if(res) System.out.println("Prenotazione per: " + numPersone + " persone effettuata presso: " + l.getNome());
		else System.out.println("Impossibile prenotare presso: " + l.getNome());
		
	}

	public void printInfo() 
	{
		Iterator<Integer> it = this.locali.keySet().iterator();
		
		while(it.hasNext()) System.out.println(this.locali.get(it.next()));
	}

	public void registraLocale(Locale l) 
	{
		if(this.locali.containsKey(l.hashCode()))
		{
			System.out.println("Locale già registrato!");
		}
		else
		{
			this.locali.put(l.hashCode(),l);
			System.out.println("Locale registrato!");
		}
	}
	
	public void printPizzerieByPizza(String Pizza)
	{
		Iterator<Integer> it = this.locali.keySet().iterator();
		while(it.hasNext())
		{
			Locale app = this.locali.get(it.next());
			if(app instanceof Pizzeria)
			{
				HashMap<String,Integer> menu = ((Pizzeria) app).getMenu();
				if(menu.containsKey(Pizza))
				{
					System.out.println((Pizzeria)app);
					System.out.println("Prezzo pizza: " + menu.get(Pizza));
				}
			}
		}
	}
	
	public void saveLocaliFull(String fileName)
	{
		PrintWriter out = null;
		
		try
		{
			out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
			
			Iterator<Integer> it = this.locali.keySet().iterator();
			
			while(it.hasNext())
			{
				Locale l = this.locali.get(it.next());
				if(l.getNumPosti() == 0) out.println(l);
			}
			
			out.close();
		}
		catch (EOFException e)
		{
			System.out.println("Fine stream");
			out.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			out.close();
		}
	}
	
	public void readPaninoteche(String fileName) throws IOException
	{
		
		BufferedReader in = null;
		
		try
		{
			in = new BufferedReader(new FileReader(fileName));
			
			String nome = new String();
			
			while((nome = in.readLine()) != null)
			{
				String indirizzo = in.readLine();
				int posti = Integer.parseInt(in.readLine());
				int panini = Integer.parseInt(in.readLine());
				int birre = Integer.parseInt(in.readLine());
				
				Paninoteca p = new Paninoteca(nome,indirizzo,posti,panini,birre);
				this.locali.put(p.hashCode(), p);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			in.close();
		}
	}
	
	public void readPizzerie(String fileName) throws IOException
	{
		
		BufferedReader in = null;
		
		try
		{
			in = new BufferedReader(new FileReader(fileName));
			
			String nome = new String();
			
			while((nome = in.readLine()) != null)
			{
				String indirizzo = in.readLine();
				int posti = Integer.parseInt(in.readLine());
				
				Pizzeria p = new Pizzeria(nome,indirizzo,posti);
				this.locali.put(p.hashCode(), p);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			in.close();
		}
	}
	
	public static LocaliManager createManager()
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
		
		return manager;
	}
}
