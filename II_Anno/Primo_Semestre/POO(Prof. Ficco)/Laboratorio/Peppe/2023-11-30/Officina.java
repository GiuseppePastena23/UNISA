package officina;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Officina{
	
	private ArrayList<SchedaAuto> schede;
	private int numeroSchedeTotali;
	private FileWriter file;
	private PrintWriter pFile;
	private FileReader rFile;
	private String nomeFile;

	public Officina(String nomeFile)
	{
		this.nomeFile = nomeFile;
		schede = new ArrayList<>();
		numeroSchedeTotali = 0;
		
	}
	
	public void inserisciScheda(SchedaAuto scheda){
		schede.add(scheda);
		numeroSchedeTotali++;
	}

	public void cancellaScheda(SchedaAuto scheda){
		schede.remove(scheda);
	}

	public bool ricercaScheda(SchedaAuto scheda){
		return schede.contains(scheda);
	}

	public int getAutoOfficina()
	{
		return schede.size();
	}

	public int getTotaleAutoOfficina()
	{
		return numeroSchedeTotali;
	}

	public void toFile()
	{
		file = new FileWriter(nomeFile, true);
		pFile = new PrintWriter(file);
		for(SchedaAuto scheda: schede)
		{
			pFile.println(scheda.getId() + " " + scheda.getTarga() + " " + scheda.getModello() + " " + scheda.getStato() + " " + scheda.getDataArrivo());
		}
		pFile.close();
	}

	public void toFile(StatoVeicolo stato)
	{	
		file = new FileWriter(nomeFile, true);
		pFile = new PrintWriter(file);
		for (SchedaAuto scheda : schede)
		{	
			if(scheda.getStato().equals(stato))
			{
				pFile.println(scheda.getId() + " " + scheda.getTarga() + " " + scheda.getModello() + " " + scheda.getDataArrivo() + " " + scheda.getStato());
			}
		}
		pFile.close();
	}

	public void fromFile(String fileName)
	{
		rFile = new FileReader(fileName);
		Scanner lettore = new Scanner(rFile);

		while(lettore.hasNext())
		{	
			String[] parti = lettore.next();
			schede.add(new SchedaAuto(Integer.parseInt(parti[0]), parti[1], parti[2], parti[3]. parti[4], parti[5]));
		}

		rFile.close();
	}

	public void cancellaConsegnati()
	{
		for(SchedeAuto scheda : schede)
		{
			if(scheda.getStato().equals(statoVeicolo.Consegnato))
			{
				schede.remove(scheda);
			}
		}
	}
}
