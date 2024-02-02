package core;

public class Treno extends Veicolo 
{
	private int minutiRitardo;
	
	public Treno(int minutiRitardo)
	{
		super("Treno");
		this.minutiRitardo = minutiRitardo;
	}
	
	
	public int getMinutiRitardo() {
		return minutiRitardo;
	}



	public void setMinutiRitardo(int minutiRitardo) {
		this.minutiRitardo = minutiRitardo;
	}


	public String toString() 
	{
		return "Treno [minutiRitardo=" + minutiRitardo + ", " + super.toString() + "]";
	}


	public void printDetailedInfo() 
	{
		System.out.println(this);
	}
}
