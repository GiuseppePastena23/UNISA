package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import core.Studente;
import core.StudentiManager;

import java.util.Arrays;
import java.util.List;

public class PrintStudenti implements ActionListener 
{
	private List<Studente> studenti;
	
	

	public PrintStudenti(List<Studente> studenti) 
	{
		this.studenti = studenti;
	}


	public void actionPerformed(ActionEvent e) 
	{
		Studente[] arrayStudenti = this.studenti.toArray(new Studente[this.studenti.size()]);
		
		Arrays.sort(arrayStudenti,(o1, o2) -> {return Studente.compareByEta(o1,o2);});
		
		System.out.println("\n\nStampa studenti ordinati per eta'\n\n");
		for(Studente s : arrayStudenti) System.out.println(s);
	}

}
