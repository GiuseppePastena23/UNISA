package core;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Botnet extends Malware 
{
	private ArrayList<String> listIPs;
	
	public Botnet(String appName, int level, GregorianCalendar releaseDate) 
	{
		super(appName, level, releaseDate);
		this.listIPs = new ArrayList<String>();
	}

	public ArrayList<String> getListIPs() {
		return listIPs;
	}

	public void setListIPs(ArrayList<String> listIPs) {
		this.listIPs = listIPs;
	}

	
	public String toString() {
		return "Botnet [" + super.toString() + "]";
	}

	public void doAction(String messageActionDone) 
	{
		System.out.println("Azioni malevoli da parte di: " + this.getClass().getSimpleName() + " " + messageActionDone);
	}
}
