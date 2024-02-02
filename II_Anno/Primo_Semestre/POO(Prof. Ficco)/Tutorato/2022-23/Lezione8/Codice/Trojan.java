package core;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import exception.MalwareException;

public class Trojan extends Malware 
{
	private ArrayList<Malware> appToInstall;

	public Trojan(String appName, int level, GregorianCalendar releaseDate) 
	{
		super(appName, level, releaseDate);
		this.appToInstall = new ArrayList<Malware>();
	}

	public ArrayList<Malware> getAppToInstall() {
		return appToInstall;
	}

	public void setAppToInstall(ArrayList<Malware> appToInstall) {
		this.appToInstall = appToInstall;
	}

	public String toString() {
		return "Trojan [" + super.toString() + "]";
	}

	public void doAction(String messageActionDone) 
	{
		System.out.println("Azioni malevoli da parte di: " + this.getClass().getSimpleName() + " " + messageActionDone);
	}

	boolean installMalwares() throws MalwareException
	{
		if(this.appToInstall.size() > 0) return true;
		else throw new MalwareException();
	}
}
