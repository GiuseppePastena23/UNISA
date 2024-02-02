package core;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.function.Consumer;
import java.util.function.Predicate;

import exception.SalvataggioControllatoException;
import interfacce.StudentiOperations;

public class StudentiManager implements StudentiOperations
{
	private List<Studente> studenti;

	public StudentiManager() 
	{
		this.studenti = new Vector<Studente>();
	}

	public boolean add(Studente s) 
	{
		if(this.studenti.contains(s)) return false;
		else this.studenti.add(s);
		
		return true;
	}

	public boolean remove(Studente s) 
	{
		if(! this.studenti.contains(s))
		{
			this.studenti.add(s);
			return true;
		}
		else return false;
	}

	public boolean addCorso(Studente s, Corso c) 
	{
		if(s.getCorsi().contains(c)) return false;
		else
		{
			for(int i = 0; i < this.studenti.size(); i++) 
				if(this.studenti.get(i).equals(s))
				{
					this.studenti.get(i).getCorsi().add(c);
					break;
				}
			
			return true;
		}
	}

	public List<Studente> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Studente> studenti) {
		this.studenti = studenti;
	}
	
	public void saveOnFile(String fileName) throws SalvataggioControllatoException
	{
		PrintWriter out = null;
		
		try
		{
			out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
			
			for(Studente s : this.studenti) out.println(s);
			
			out.close();
		}
		catch(EOFException e)
		{
			System.out.println("End of stream!");
			out.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			out.close();
		}
	}
	
	public static void printStudByCond(List<Studente> list,Predicate<Studente> pred,Consumer<Studente> cons)
	{
		for(Studente s : list) if(pred.test(s)) cons.accept(s);
	}

}
