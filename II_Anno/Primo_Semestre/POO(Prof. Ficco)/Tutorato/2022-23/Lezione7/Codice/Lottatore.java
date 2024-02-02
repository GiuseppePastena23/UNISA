package core;

import eccezioni.IllegalActionException;

public class Lottatore extends Player 
{

	public Lottatore(int puntiVita, int attacco, int difesa) 
	{
		super(puntiVita*2, attacco*4, difesa);
	}

	public boolean attacco(Player other) 
	{
		if(this.attacco > other.difesa && this.puntiVita > 0 && other.puntiVita > 0)
		{
			int damage = this.attacco * 2;
			other.puntiVita = other.puntiVita - damage;
			
			if(other.puntiVita <= 0) this.numUccisioni++;
			return true;
		}
		else return false;
	}

	public void potenziamento() 
	{
		if(this.numUccisioni > 5 && this.puntiVita > 0)
		{
			this.difesa = this.difesa * 2;
			this.numUccisioni = 0;
		}

	}

	public boolean fusione(Player two) throws IllegalActionException 
	{
		
		if(! (two instanceof Lottatore && this.puntiVita > 0 && two.puntiVita > 0)) throw new IllegalActionException();
		else
		{
			int totPuntiVita = this.puntiVita + two.puntiVita;
			int attaccoTot = this.attacco + two.puntiVita;
			int difesaTot = two.difesa;
			
			this.puntiVita = totPuntiVita;
			this.attacco = attaccoTot;
			this.difesa = difesaTot;
			this.numUccisioni = 0;
			
			two = null;
			
			return true;
		}
	}

	public boolean attaccoAereo(Player other) throws IllegalActionException 
	{
		throw new IllegalActionException("Lottatore non attacca in modo aereo!");
	}

	public String toString() {
		return "Lottatore [" + super.toString() + "]";
	}
	
	
}
