package core;

import eccezioni.MotoreException;
import interfacce.Auto;

//4 Punti
public class Macchina extends Autovettura 
{
	private int matricola;
	private String targa;
	private int numMarce;
	
	//Utilizzato per la GUI
	public Macchina(String tipo, int numRuote, int cilindrata, String colore ) 
	{
		super(tipo, numRuote, cilindrata, colore);
		this.matricola = cont;
		this.targa = "";
		this.numMarce = 0;
	}
	
	public Macchina(String targa, int numMarce, String tipo, int numRuote, int cilindrata, String colore) 
	{
		super(tipo, numRuote, cilindrata, colore);
		this.matricola = cont;
		this.targa = targa;
		this.numMarce = numMarce;
	}

	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public int getNumMarce() {
		return numMarce;
	}

	public void setNumMarce(int numMarce) {
		this.numMarce = numMarce;
	}

	@Override
	public String toString() {
		return "Macchina [matricola=" + matricola + ", targa=" + targa + ", numMarce=" + numMarce + "]";
	}

	/*
	 La variabile di tipo interfaccia (Auto) può contenere il riferimento ad un oggetto di una classe
	 che implementa l'interfaccia (Auto);
	 */
	public void Accendi(Auto a) throws MotoreException 
	{
		if(((Autovettura) a).isStatoMotore()) throw new MotoreException();
		else
		{
			((Autovettura) a).setStatoMotore(true);
			System.out.println("Auto accesa!\n\n");
		}

	}

	@Override
	public void Spegni(Auto a) throws MotoreException 
	{
		if(! ((Autovettura) a).isStatoMotore()) throw new MotoreException("Motore spento!");
		else
		{
			((Autovettura) a).setStatoMotore(false);
			System.out.println("Auto spenta!\n\n");
		}

	}
	
	public void Avanti()
	{
		if(super.isStatoMotore()) System.out.println("La macchina si muove in avanti\n\n");
		else System.out.println("Macchina spenta\n\n");
	}
	
	public void Indietro()
	{
		if(super.isStatoMotore()) System.out.println("La macchina si muove in retromarcia\n\n");
		else System.out.println("Macchina spenta\n\n");
	}
}
