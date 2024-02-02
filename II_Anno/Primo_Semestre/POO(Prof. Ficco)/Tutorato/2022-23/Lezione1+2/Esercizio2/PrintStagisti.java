package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import core.DipendentiManager;
import core.Stagista;

public class PrintStagisti implements ActionListener 
{
	private DipendentiManager m;
	
	
	public PrintStagisti(DipendentiManager m) 
	{
		this.m = m;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		ArrayList<Stagista> stagisti = this.m.getStagisti();
		for(Stagista s : stagisti) System.out.println(s);

	}

}

