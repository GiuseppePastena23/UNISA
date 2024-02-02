package core;

import java.util.HashMap;

public class Pizzeria extends Locale
{
	private HashMap<String,Integer> menu;

	public Pizzeria(String nome, String indirizzo, int numPosti) 
	{
		super(nome, indirizzo, numPosti);
		this.menu = new HashMap<String,Integer>();
	}

	public HashMap<String, Integer> getMenu() {
		return menu;
	}

	public void setMenu(HashMap<String, Integer> menu) {
		this.menu = menu;
	}

	@Override
	public String toString() {
		return "Pizzeria [menu=" + menu + " " + super.toString() + "]";
	}
	
	public boolean prenotazione(int numPersone) 
	{
		int numPostiDisp = this.getNumPosti();
		
		if((numPostiDisp - numPersone) >= 0) 
		{
			this.setNumPosti(this.getNumPosti() - numPersone);
			return true;
		}
		else return false;
	}
}
