package core;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

//Punti 6
public class ListaPacchiNatale extends ListaPacchi
{
	private int numPacchiInseriti;

	public ListaPacchiNatale(GregorianCalendar dataCreazione, GregorianCalendar dataConsegna) 
	{
		super(dataCreazione, dataConsegna);
		this.numPacchiInseriti = 0;
	}


	public int getNumPacchiInseriti() {
		return numPacchiInseriti;
	}



	public void setNumPacchiInseriti(int numPacchiInseriti) {
		this.numPacchiInseriti = numPacchiInseriti;
	}



	public boolean Aggiungi(Pacco d)
	{
		if(super.getListaPacchi().contains(d)) return false;
		else if(super.getDataConsegna().before(d.getDataArrivo())) return false;
		else
		{
			super.getListaPacchi().add(d);
			this.numPacchiInseriti++;

			return true;
		}
	}

	public boolean Modifica(GregorianCalendar data) 
	{
		if(GregorianCalendar.getInstance().after(data)) return false;
		else
		{
			super.setDataConsegna(data);
			return true;
		}
	}

	public boolean Rimuovi(Pacco d)
	{
		if(! super.getListaPacchi().contains(d)) return false;
		else 
		{
			super.getListaPacchi().remove(d);
			this.numPacchiInseriti--;
			return true;
		}
	}

	public void saveListaToFile(String fileName)
	{
		PrintWriter out = null;

		try
		{
			out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));

			for(Pacco p : super.getListaPacchi()) out.println(p);

			out.close();
		}
		catch(EOFException e)
		{
			System.out.println("Fine Stream");
			out.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
			out.close();
		}
	}

	public static void printDataLambda(List<Pacco> listaPacchi, Predicate<Pacco> tester, Consumer<Pacco> block)
	{

		for(Pacco p : listaPacchi) if(tester.test(p)) block.accept(p);
	}
}
