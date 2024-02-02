package core;

public class Autobus extends Veicolo 
{
	private int postiSedere;
	
	public Autobus(int postiSedere) 
	{
		super("Autobus");
		this.postiSedere = postiSedere;
	}


	public int getPostiSedere() {
		return postiSedere;
	}



	public void setPostiSedere(int postiSedere) {
		this.postiSedere = postiSedere;
	}

	

	public String toString() 
	{
		return "Autobus [postiSedere=" + postiSedere + ", " + super.toString() + "]";
	}


	public void printDetailedInfo() 
	{
		System.out.println(this);
	}

}
