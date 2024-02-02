package tester;
import java.util.Date;

import core.*;

import java.util.ArrayList;

public class Tester1 {

	public static void main(String[] args) 
	{
		Date d = new Date(2023, 10, 22);
		Determinato l1 = new Determinato("Antonio", "Rossi", 1, 1200.0,d);
		Indeterminato l2 = new Indeterminato("Carlo", "Conti", 2, 900);
		Stagista l3 = new Stagista("Davide", "Rossi", 3, 1100,l1);
		
		ArrayList<Dipendente> list = new ArrayList<Dipendente>();
		list.add(l1);
		list.add(l2);
		list.add(l3);
		
		DipendentiManager m = new DipendentiManager();
		m.setDipendenti(list);
		
		
		System.out.println("Stampo tutti i dipendenti con salario > 1000");
		m.printDipendentiBySalario(1000);
		
		System.out.println("\n\nStampo tutti i dipendenti stagisti");
		ArrayList<Stagista> stag = m.getStagisti();
		for(Dipendente d1 : stag) System.out.println(d1);
		
		System.out.println("\n\nSalvataggio Dipendenti");
		m.saveLavoratori("Dipendenti.txt");
		
		System.out.println("\n\nLoad Dipendenti");
		m.readLavoratori("Dipendente.txt");
		
		System.out.println("\n\nStampo tutti i dipendenti caricati dopo la lettura\n\n");
		ArrayList<Dipendente> dipendenti = (ArrayList<Dipendente>) m.getDipendenti();
		for(Dipendente d1 : dipendenti) System.out.println(d1);
	}

}
