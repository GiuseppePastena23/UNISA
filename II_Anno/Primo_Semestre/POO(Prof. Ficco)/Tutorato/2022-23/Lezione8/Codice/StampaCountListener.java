package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.function.Predicate;

import core.Malware;

public class StampaCountListener implements ActionListener {
	
	private ArrayList<Malware> listMalware;
	private int year;
	
	
	public StampaCountListener(ArrayList<Malware> listMalware,int year) 
	{
		this.listMalware = listMalware;
		this.year = year;
	}

	public void actionPerformed(ActionEvent e) 
	{
		System.out.println("\n\nOperazione 3\n\n");
		
		Predicate<Malware> pred = m -> m.getReleaseDate().get(GregorianCalendar.YEAR) == this.year;
		System.out.println(this.listMalware.stream().filter(pred).count());
	}

}
