package test;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import core.Botnet;
import core.Malware;
import core.Trojan;
import gui.GUI;

public class Test {

	public static void main(String[] args) 
	{
		ArrayList<Malware> malware = new ArrayList<Malware>();
		
		Trojan t1 = new Trojan("Installer v1",Malware.LIEVE,new GregorianCalendar(2021,GregorianCalendar.JULY,20));
		Trojan t2 = new Trojan("Installer Strong",Malware.GRAVE,new GregorianCalendar(2022,GregorianCalendar.JUNE,15));
		
		Botnet b1 = new Botnet("Botnet POO",Malware.LIEVE,new GregorianCalendar(2023,GregorianCalendar.JANUARY,28));
		Botnet b2 = new Botnet("Botnet BD",Malware.MEDIO,new GregorianCalendar(2023,GregorianCalendar.JANUARY,28));
		
		malware.add(b1);
		malware.add(t2);
		malware.add(t1);
		malware.add(b2);
		
		GUI gui = new GUI("Malware info",malware);
		gui.setVisible(true);

	}

}
