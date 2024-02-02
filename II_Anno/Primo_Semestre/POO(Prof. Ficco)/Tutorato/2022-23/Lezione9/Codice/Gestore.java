package core;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Gestore 
{
	private ArrayList<Personaggio> personaggi;
	
	public Gestore()
	{
		this.personaggi = new ArrayList<Personaggio>();
	}
	
	public ArrayList<Personaggio> getPersonaggi() {
		return personaggi;
	}

	public void setPersonaggi(ArrayList<Personaggio> personaggi) {
		this.personaggi = personaggi;
	}

	public static Gestore creaGestore()
	{
		Orco o1 = new Orco(50);
		Cavaliere c1 = new Cavaliere(10);
		Orco o2 = new Orco(100);
		Cavaliere c2 = new Cavaliere(40);
		Orco o3 = new Orco(25);
		Cavaliere c3 = new Cavaliere(50);
		
		ArrayList<Personaggio> list = new ArrayList<Personaggio>();
		list.add(o1);
		list.add(o2);
		list.add(o3);
		list.add(c1);
		list.add(c2);
		list.add(c3);
		
		Gestore g = new Gestore();
		g.setPersonaggi(list);
		
		return g;
	}
	
	public void saveFile(String fileName)
	{
		PrintWriter out = null;
		
		try
		{	out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
			
			for(Personaggio p : this.personaggi) out.println(p);
		
			out.close();
		}
		catch(EOFException e)
		{
			System.out.println(e.getMessage());
			out.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			out.close();
		}
	}
	
	public int get_Pos(Personaggio pers)
	{
		return pers.getPosGioco();
	}
	
	public ArrayList<String> get_Pos_all()
	{
		ArrayList<String> list = new ArrayList<String>();
		
		for(Personaggio p : this.personaggi)
		{
			String formatted = p.getPosGioco() + ";" + p.getId();
			list.add(formatted);
		}
		
		return list;
	}
	
	public String get_Type(Personaggio pers)
	{
		return pers.getTipo();
	}
}
