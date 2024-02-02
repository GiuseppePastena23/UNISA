package core;

import eccezioni.PositionException;
import interfacce.PersMaster;

public abstract class Personaggio implements PersMaster
{
	private static int cont = 0;
	
	private int id;
	private String tipo;
	private int energia;
	private int posIniziale;
	private int posGioco;
	private int rotazione;
	
	public Personaggio(String tipo,int posIniziale)
	{
		this.id = cont++;
		this.tipo = tipo;
		this.energia = 100;
		this.posIniziale = posIniziale;
		this.posGioco = posIniziale;
		this.rotazione = 0;
	}
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public int getEnergia() {
		return energia;
	}



	public void setEnergia(int energia) {
		this.energia = energia;
	}



	public int getPosIniziale() {
		return posIniziale;
	}



	public void setPosIniziale(int posIniziale) {
		this.posIniziale = posIniziale;
	}



	public int getPosGioco() {
		return posGioco;
	}



	public void setPosGioco(int posGioco) {
		this.posGioco = posGioco;
	}



	public int getRotazione() {
		return rotazione;
	}



	public void setRotazione(int rotazione) {
		this.rotazione = rotazione;
	}


	public void Ruota(int g) 
	{
		if(g > 0)
		{
			int newRot = (this.getRotazione() + g) % 360;
			this.setRotazione(newRot);
		}
	}

	public void Avanti(int s) throws PositionException 
	{
		if(s > 0)
		{
			int newPos = this.getPosGioco() + s;
			if(newPos > 100) throw new PositionException();
			else this.setPosGioco(newPos);
		}
	}

	public void Indietro(int s) throws PositionException 
	{
		if(s > 0)
		{
			int newPos = this.getPosGioco() - s;
			if(newPos < 0) throw new PositionException();
			else this.setPosGioco(newPos);
		}
	}
	
	public abstract void Colpisci(Personaggio pers);

	public String toString() {
		return "Personaggio [id=" + id + ", tipo=" + tipo + ", energia=" + energia + ", posIniziale=" + posIniziale
				+ ", posGioco=" + posGioco + ", rotazione=" + rotazione + "]";
	}

}
