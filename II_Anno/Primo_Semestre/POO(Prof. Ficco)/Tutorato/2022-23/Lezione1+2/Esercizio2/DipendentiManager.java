package core;
import java.util.*;

import interfacce.FileManager;

import java.io.*;

public class DipendentiManager implements FileManager
{
	
	private ArrayList<Dipendente> dipendenti;
	
	public DipendentiManager() {
		
		this.dipendenti = new ArrayList<Dipendente>();
	}

	public ArrayList<Dipendente> getDipendenti() {
		return dipendenti;
	}

	public void setDipendenti(ArrayList<Dipendente> dipendenti) {
		this.dipendenti = dipendenti;
	}
	
	public ArrayList<Stagista> getStagisti()
	{
		ArrayList<Stagista> list = new ArrayList<Stagista>();
		
		for(int i=0; i<this.dipendenti.size(); i++)
		{
			if(this.dipendenti.get(i) instanceof Stagista) list.add((Stagista) this.dipendenti.get(i));
		}
		
		return list;
	}
	
	public void printDipendentiBySalario(int soglia)
	{
		for(int i=0; i<this.dipendenti.size() ;i++)
		{
			Dipendente app = this.dipendenti.get(i);
			if(app.calcolaStipendio() > soglia) System.out.println(app);
		}
	}

	@Override
	public void readLavoratori(String fileName) 
	{
		String fileNameS = "Indeterminato" + fileName;
		
		try
		{
			String nome = "";
			BufferedReader in = new BufferedReader(new FileReader(fileNameS));
			
			while((nome = in.readLine()) != null)
			{
				String cognome = in.readLine();
				int id = Integer.parseInt(in.readLine());
				float salario = Float.parseFloat(in.readLine());
				
				Indeterminato i = new Indeterminato(nome,cognome,id,salario);
				this.dipendenti.add(i);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public void saveLavoratoriSerializable(String fileName) 
	{
		try
		{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
			
			out.writeObject(this.dipendenti);
			
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
	public void saveLavoratori(String fileName) 
	{
		PrintWriter out = null;
		
		try
		{
			out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
			
			for(Dipendente d : this.dipendenti)
			{
				String nome = d.getNome();
				String cognome = d.getCognome();
				int id = d.getId();
				double salario = d.getSalario();
				
				out.println(nome);
				out.println(cognome);
				out.println(id);
				out.println(salario);
				
				if(d instanceof Determinato) out.println(((Determinato) d).getScadenza().toString());
				else if(d instanceof Stagista)
				{
					Dipendente supervisore = ((Stagista) d).getSupervisor();
					
					String nomes = supervisore.getNome();
					String cognomes = supervisore.getCognome();
					int ids = supervisore.getId();
					double salarios = supervisore.getSalario();
					
					out.println(nomes);
					out.println(cognomes);
					out.println(ids);
					out.println(salarios);
					
					if(supervisore instanceof Determinato) out.println(((Determinato) supervisore).getScadenza().toString());
				}
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
}
