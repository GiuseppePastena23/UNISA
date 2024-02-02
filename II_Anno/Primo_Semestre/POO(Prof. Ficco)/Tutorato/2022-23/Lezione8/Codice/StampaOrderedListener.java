package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;

import core.Malware;

public class StampaOrderedListener implements ActionListener 
{
	private ArrayList<Malware> listMalware;
	
	public StampaOrderedListener(ArrayList<Malware> listMalware) 
	{
		this.listMalware = listMalware;
	}

	public void actionPerformed(ActionEvent e) 
	{
		System.out.println("\n\nOperazione 2\n\n");
		
		Comparator<Malware> comp = (m1,m2) -> {return m1.getReleaseDate().compareTo(m2.getReleaseDate());};
		this.listMalware.stream().sorted(comp).forEach(System.out::println);
		
		System.out.println("\n\n");
		
		//Soluzione alternativa senza espressioni lambda
		this.listMalware.stream().sorted(Malware::compareDate).forEach(System.out::println);
		
		//Invertendo m1 ed m2 si può ottenere l'ordinamento crescente o decrescente 

	}

}
