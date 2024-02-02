package core;

public class Cavaliere extends Personaggio 
{

	private static int countClass = 0;
	private int idClass;
	
	
	public Cavaliere(int posIniziale) 
	{
		super("Cavaliere", posIniziale);
		this.idClass = countClass++;
	}
	
	public int getIdClass() {
		return idClass;
	}
	

	public void setIdClass(int idClass) {
		this.idClass = idClass;
	}


	public void Colpisci(Personaggio pers) 
	{
		if(pers.getEnergia() > 0) pers.setEnergia(pers.getEnergia() - 1);
	}

	public String toString() {
		return "Cavaliere [idClass=" + idClass + ", " + super.toString() + "]";
	}

}
