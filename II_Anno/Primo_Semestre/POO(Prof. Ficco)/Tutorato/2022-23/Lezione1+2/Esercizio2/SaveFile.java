package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import core.DipendentiManager;

public class SaveFile implements ActionListener 
{
	private DipendentiManager m;
	
	public SaveFile(DipendentiManager m) {
		this.m = m;
	}



	@Override
	public void actionPerformed(ActionEvent e) 
	{
		System.out.println("Salvo i lavorati su file");
		this.m.saveLavoratori("Dipendenti.txt");

	}

}
