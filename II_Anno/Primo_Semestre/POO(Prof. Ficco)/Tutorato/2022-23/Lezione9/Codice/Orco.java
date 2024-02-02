package core;

public class Orco extends Personaggio 
{
	private static int countClass = 0;
	private int idClass;
	
	
	public Orco(int posIniziale) 
	{
		super("Orco", posIniziale);
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
		return "Orco [idClass=" + idClass + ", " + super.toString() + "]";
	}

}
