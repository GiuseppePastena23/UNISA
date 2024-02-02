package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import core.Autobus;
import core.Treno;
import core.Veicolo;

public class VeicoliGUI extends JFrame 
{
	private ArrayList<Veicolo> veicoli;
	
	public VeicoliGUI(ArrayList<Veicolo> veicoli)
	{
		this.veicoli = veicoli;
		setSize(450,250);
		setLocation(300,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(buildPanel());
	}
	
	private JPanel buildPanel()
	{
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(1,2));
		
		JTextArea infoArea = new JTextArea();
		infoArea.setEditable(false);
		
		
		JButton treni = new JButton("Treni in ritardo");
		treni.addActionListener((ActionEvent e)->{
			
			//Ripulisco la text Area dall'eventuale output precedente
			infoArea.setText("");
			
			Predicate<Veicolo> pred = t -> t instanceof Treno && ((Treno) t).getMinutiRitardo() >= 60;
			
			Consumer<Veicolo> cons = t ->  {
				
				String res = ((Treno) t).toString() + "\n";
				infoArea.append(res);
			
			};
			
			
			this.veicoli.stream().filter(pred).forEach(cons);
		});
		
		JButton autobus = new JButton("Autobus con posti");
		autobus.addActionListener((ActionEvent e) -> {
			
			//Ripulisco la text Area dall'eventuale output precedente
			infoArea.setText("");
			
			Predicate<Veicolo> pred = a -> a instanceof Autobus && ((Autobus) a).getPostiSedere() >= 30;
			
			int conteggio = (int) this.veicoli.stream().filter(pred).count();
			
			String ris = "Numero di autobus con almeno 30 posti a sedere: " + conteggio;
			infoArea.append(ris);
		});
		
		
		buttonsPanel.add(treni);
		buttonsPanel.add(autobus);
		
		mainPanel.add(buttonsPanel,BorderLayout.NORTH);
		mainPanel.add(infoArea,BorderLayout.CENTER);
		
		return mainPanel;
	}
}
