package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import core.DipendentiManager;

public class LoadData implements ActionListener {

	private DipendentiManager m;
	
	public LoadData(DipendentiManager m)
	{
		this.m = m;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		this.m.readLavoratori("Dipendente.txt");
		System.out.println("Lavoratori caricati da file");
	}

}
