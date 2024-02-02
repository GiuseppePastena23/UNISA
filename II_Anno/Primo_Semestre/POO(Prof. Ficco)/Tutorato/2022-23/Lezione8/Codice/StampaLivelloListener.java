package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.function.Predicate;

import core.Malware;

public class StampaLivelloListener implements ActionListener 
{
	private ArrayList<Malware> listMalware;
	private int level;
	
	
	public StampaLivelloListener(ArrayList<Malware> listMalware,int level) 
	{
		this.listMalware = listMalware;
		this.level = level;
	}

	public void actionPerformed(ActionEvent e) 
	{
		System.out.println("\n\nOperazione 1\n\n");
		
		Predicate<Malware> pred = m -> m.getLevel() == this.level;
		this.listMalware.stream().filter(pred).forEach(System.out::println);
	}

}
