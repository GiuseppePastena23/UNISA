package core;

import eccezioni.IllegalActionException;

public class Mago extends Player 
{
	protected int livMagia;
	
	
	public Mago(int puntiVita, int attacco, int difesa) 
	{
		super(puntiVita, attacco, difesa);
		this.livMagia = 50;
	}

	public boolean attacco(Player other) 
	{
		if(this.attacco >= other.getDifesa() && this.puntiVita > 0 && other.getPuntiVita() > 0)
		{
			int damage = this.attacco + this.livMagia;
			other.setPuntiVita(other.getPuntiVita() - damage);
			
			if(other.getPuntiVita() <= 0) this.numUccisioni++;
			return true;
		}
		else if(this.puntiVita > 0 && other.getPuntiVita() > 0)
		{
			int reverseDamage = other.getDifesa() - this.attacco;
			this.puntiVita = this.puntiVita - reverseDamage;
			
			if(this.puntiVita <= 0) other.setNumUccisioni(other.getNumUccisioni() + 1);
			return false;
		}
		else return false;
	}

	public void potenziamento() 
	{
		if(this.numUccisioni > 10 && this.puntiVita > 0)
		{
			this.difesa = this.difesa * 4;
			this.attacco = this.attacco * 2;
			this.livMagia = this.livMagia + 50;
			this.numUccisioni = 0;
		}

	}

	public boolean fusione(Player two) throws IllegalActionException 
	{
		throw new IllegalActionException("Fusione non consentita!");
	}

	public boolean attaccoAereo(Player other) throws IllegalActionException 
	{
		throw new IllegalActionException("Mago non attacca in modo aereo!");
	}

	@Override
	public String toString() {
		return "Mago [livMagia=" + livMagia + ", " + super.toString() + "]";
	}
	
	
}
