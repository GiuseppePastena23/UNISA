package core;

public class Paninoteca extends Locale
{
	private int numPaniniDisp;
	private int numBirreDisp;
	
	public Paninoteca(String nome, String indirizzo, int numPosti, int numPaniniDisp, int numBirreDisp) {
		super(nome, indirizzo, numPosti);
		this.numPaniniDisp = numPaniniDisp;
		this.numBirreDisp = numBirreDisp;
	}

	public int getNumPaniniDisp() {
		return numPaniniDisp;
	}

	public void setNumPaniniDisp(int numPaniniDisp) {
		this.numPaniniDisp = numPaniniDisp;
	}

	public int getNumBirreDisp() {
		return numBirreDisp;
	}

	public void setNumBirreDisp(int numBirreDisp) {
		this.numBirreDisp = numBirreDisp;
	}

	@Override
	public String toString() {
		return "Paninoteca [numPaniniDisp=" + numPaniniDisp + ", numBirreDisp=" + numBirreDisp + " "
				+ super.toString() + "]";
	}

	public boolean prenotazione(int numPersone) 
	{
		int numPostiDisp = this.getNumPosti();
		
		if((numPostiDisp - numPersone) >= 0 && (this.numPaniniDisp - numPersone) >= 0) 
		{
			super.setNumPosti(super.getNumPosti() - numPersone);
			this.numPaniniDisp = this.numPaniniDisp - numPersone;
			return true;
		}
		else return false;
	}
}
