package core;

import eccezioni.MotoreException;
import interfacce.Auto;

/*5 Punti*/
public abstract class Autovettura implements Auto 
{
	String tipo;
	int numRuote;
	int cilindrata;
	String colore;
	boolean statoMotore;
	
	protected static int cont = 0;
	
	public Autovettura(String tipo, int numRuote, int cilindrata, String colore) 
	{
		this.tipo = tipo;
		this.numRuote = numRuote;
		this.cilindrata = cilindrata;
		this.colore = colore;
		this.statoMotore = false;
		this.cont ++;
	}


	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public int getNumRuote() {
		return numRuote;
	}



	public void setNumRuote(int numRuote) {
		this.numRuote = numRuote;
	}



	public int getCilindrata() {
		return cilindrata;
	}



	public void setCilindrata(int cilindrata) {
		this.cilindrata = cilindrata;
	}



	public String getColore() {
		return colore;
	}



	public void setColore(String colore) {
		this.colore = colore;
	}



	public boolean isStatoMotore() {
		return statoMotore;
	}



	public void setStatoMotore(boolean statoMotore) {
		this.statoMotore = statoMotore;
	}

	public String toString() {
		return "Autovettura [tipo=" + tipo + ", numRuote=" + numRuote + ", cilindrata=" + cilindrata + ", colore="
				+ colore + ", statoMotore=" + statoMotore + "]";
	}
	
	public abstract void Spegni(Auto a) throws MotoreException;

}
