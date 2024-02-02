package test;

import java.util.ArrayList;

import core.Autobus;
import core.Treno;
import core.Veicolo;
import gui.VeicoliGUI;

public class Test {

	public static void main(String[] args) 
	{
		ArrayList<Veicolo> veicoli = new ArrayList<Veicolo>();
		
		Treno t1 = new Treno(65);
		Treno t2 = new Treno(60);
		
		Autobus a1 = new Autobus(40);
		Autobus a2 = new Autobus(50);
		
		veicoli.add(a1);
		veicoli.add(a2);
		veicoli.add(t1);
		veicoli.add(t2);
		
		VeicoliGUI gui = new VeicoliGUI(veicoli);
		gui.setVisible(true);
	}
}
