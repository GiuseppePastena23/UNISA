package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import core.StudentiManager;
import exception.SalvataggioControllatoException;

public class SaveStudenti implements ActionListener 
{
	private StudentiManager m;
	
	public SaveStudenti(StudentiManager m)
	{
		this.m = m;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		System.out.println("\n\nSalvo gli studenti su file\n\n");
		
		try 
		{
			this.m.saveOnFile("studenti.txt");
		} 
		catch (SalvataggioControllatoException e1) 
		{
			e1.printStackTrace();
		}

	}

}
