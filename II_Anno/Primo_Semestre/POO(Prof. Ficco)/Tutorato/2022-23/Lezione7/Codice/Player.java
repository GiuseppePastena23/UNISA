package core;

import intefacce.ComandiAvanzati;
import intefacce.ComandiBase;

public abstract class Player implements ComandiBase, ComandiAvanzati
{
	protected int puntiVita;
	protected int attacco;
	protected int difesa;
	protected int numUccisioni;
	
	public Player(int puntiVita, int attacco, int difesa) 
	{
		this.puntiVita = puntiVita;
		this.attacco = attacco;
		this.difesa = difesa;
		this.numUccisioni = 0;
	}

	public Player(int puntiVita, int attacco, int difesa, int numUccisioni) 
	{
		this.puntiVita = puntiVita;
		this.attacco = attacco;
		this.difesa = difesa;
		this.numUccisioni = numUccisioni;
	}

	public int getPuntiVita() {
		return puntiVita;
	}

	public void setPuntiVita(int puntiVita) {
		this.puntiVita = puntiVita;
	}

	public int getAttacco() {
		return attacco;
	}

	public void setAttacco(int attacco) {
		this.attacco = attacco;
	}

	public int getDifesa() {
		return difesa;
	}

	public void setDifesa(int difesa) {
		this.difesa = difesa;
	}

	public int getNumUccisioni() {
		return numUccisioni;
	}

	public void setNumUccisioni(int numUccisioni) {
		this.numUccisioni = numUccisioni;
	}

	public String toString() {
		return "Player [puntiVita=" + puntiVita + ", attacco=" + attacco + ", difesa=" + difesa + ", numUccisioni="
				+ numUccisioni + "]";
	} 
	
}
