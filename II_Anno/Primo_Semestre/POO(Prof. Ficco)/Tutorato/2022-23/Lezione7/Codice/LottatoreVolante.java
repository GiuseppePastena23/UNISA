package core;

import eccezioni.IllegalActionException;
import eccezioni.StatLowerException;

public class LottatoreVolante extends Lottatore 
{

	public LottatoreVolante(int puntiVita, int attacco, int difesa) 
	{
		super(puntiVita, attacco, difesa);
		if(this.attacco <= this.difesa) throw new StatLowerException();
	}

	public String toString() {
		return "LottatoreVolante [" + super.toString() + "]";
	}
	
	public boolean fusione(Player two) throws IllegalActionException 
	{
		throw new IllegalActionException("Fusione non disponibile!");
	}

	public boolean attaccoAereo(Player other) throws IllegalActionException 
	{
		if(this.puntiVita > 0 && other.puntiVita > 0 && this.attacco >= other.difesa)
		{
			other.puntiVita = other.puntiVita - this.attacco;
			
			if(other.puntiVita <= 0) this.numUccisioni++;
			
			return true;
		}
		else throw new IllegalActionException("Attacco volante fallito!");
	}
}
