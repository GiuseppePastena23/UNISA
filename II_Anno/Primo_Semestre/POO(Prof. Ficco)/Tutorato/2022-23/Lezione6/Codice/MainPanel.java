package gui;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import core.Autovettura;
import core.Camion;
import core.Macchina;

public class MainPanel extends JPanel 
{
	private ArrayList<Autovettura> auto;
	
	public MainPanel()
	{
		auto = new ArrayList<Autovettura>();
		buildPanel();
	}
	
	private void buildPanel()
	{
		JLabel tipoLabel = new JLabel("Tipo Autovettura:");
		JComboBox tipo = new JComboBox();
		tipo.addItem("Macchina");
		tipo.addItem("Camion");
		
		JLabel ruoteLabel = new JLabel("Numero ruote");
		JComboBox ruoteBox = new JComboBox();
		ruoteBox.addItem("4");
		ruoteBox.addItem("6");
		ruoteBox.addItem("8");
		
		JLabel cilindrataLabel = new JLabel("Cilindrata:");
		JTextField cilindrata = new JTextField("",12);
		
		JLabel coloreLabel = new JLabel("Colore:");
		JTextField colore = new JTextField("",12);
		
		add(tipoLabel);
		add(tipo);
		add(ruoteLabel);
		add(ruoteBox);
		add(cilindrataLabel);
		add(cilindrata);
		add(coloreLabel);
		add(colore);
		
		JButton button = new JButton("Aggiungi");
		button.addActionListener((ActionEvent e) -> {
			
			String tip = (String) tipo.getSelectedItem();
			int route = Integer.parseInt((String) ruoteBox.getSelectedItem());
			int cil = Integer.parseInt(cilindrata.getText());
			String col = colore.getText();
			
			Autovettura app = null;
			
			if(tip.equalsIgnoreCase("Camion"))
			{
				app = new Camion(tip,route,cil,col);
			}
			else if(tip.equalsIgnoreCase("Macchina"))
			{
				app = new Macchina(tip,route,cil,col);
			}
			
			this.auto.add(app);
			
			for(Autovettura a : this.auto) System.out.println(a);
			
		});
		
		add(button);
	}
}
