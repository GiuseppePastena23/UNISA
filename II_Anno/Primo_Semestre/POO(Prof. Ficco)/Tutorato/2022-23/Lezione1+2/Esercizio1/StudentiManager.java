import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class StudentiManager implements EsameManager, FileManager
{
	private ArrayList<Studente> studenti;	

	public StudentiManager() 
	{
		this.studenti = new ArrayList<Studente>();
	}
	
	public List<Studente> getStudentiByEsame(Esame e)
	{
		List<Studente> app = new ArrayList<Studente>();
		
		for(int i=0; i < this.studenti.size() ; i++)
		{
			Studente studente = this.studenti.get(i);
			
			if(studente.getElencoEsami().contains(e)) app.add(studente);
		}
		
		for(Studente studente : this.studenti)
		{
			if(studente.getElencoEsami().contains(e)) app.add(studente);
		}
		
		return app;
	}
	
	public void printInfoDSA()
	{
		for(Studente studente : this.studenti)
		{
			if(studente instanceof StudenteDSA) System.out.println(studente);
		}
	}
	
	public List<StudenteDSA> getStudentiByPat(String key)
	{
		List<StudenteDSA> app = new ArrayList<StudenteDSA>();
		
		for(Studente studente : this.studenti)
		{
			if(studente instanceof StudenteDSA)
			{
				if(((StudenteDSA) studente).getPatologia().contains(key)) app.add((StudenteDSA) studente);
			}
		}
		
		return app;
	}

	public ArrayList<Studente> getStudenti() {
		return studenti;
	}

	public void setStudenti(ArrayList<Studente> studenti) {
		this.studenti = studenti;
	}

	public boolean addEsame(Esame e, Studente s) 
	{
		if(e.getVoto() < 18) return false;
		else
		{
			for(int i=0;i < this.studenti.size(); i++)
			{
				if(this.studenti.get(i).equals(s))
				{
					boolean ris = this.studenti.get(i).insertEsame(e);
					return ris;
				}
			}
		}
		return false;
	}

	@Override
	public void storeDSA(String fileName) 
	{
		
		ArrayList<StudenteDSA> list = (ArrayList<StudenteDSA>) this.getStudentiByPat("");
		
		try
		{
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
			
			for(int i=0; i<list.size() ;i++)
			{
				out.println(list.get(i));
			}
			
			out.close();
		}
		catch (EOFException e)
		{
			System.out.println("Fine stream");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void store(String fileName) 
	{
		
		try
		{
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
			
			for(int i=0; i<this.studenti.size() ;i++)
			{
				if(! (this.studenti.get(i) instanceof StudenteDSA)) out.println(this.studenti.get(i));
			}
			
			out.close();
		}
		catch (EOFException e)
		{
			System.out.println("Fine stream");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
