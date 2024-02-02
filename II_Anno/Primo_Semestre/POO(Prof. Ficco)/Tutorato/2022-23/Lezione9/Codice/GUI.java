package gui;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import core.Cavaliere;
import core.Gestore;
import core.Orco;
import core.Personaggio;

public class GUI extends JFrame 
{
	public GUI(String title)
	{
		setTitle(title);
		setSize(300,150);
		setLocation(250,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel mainPanel = buildPanel();
		add(mainPanel);
	}

	private JPanel buildPanel() 
	{
		JPanel mainPanel = new JPanel();
		
		JPanel formPanel = new JPanel();
		
		JLabel numLabel = new JLabel("Dim Lista");
		JTextField numText = new JTextField("",3);
		JButton button = new JButton("Crea");
		
		button.addActionListener((ActionEvent e) -> {
			
			int num = Integer.parseInt(numText.getText());
			System.out.println("\n\nDimensione lista indicata: " + num + "\n\n");
			
			ArrayList<Personaggio> list = new ArrayList<Personaggio>();
			
			Random r = new Random();
			
			for(int i=0;i<num;i++)
			{
				int scelta = r.nextInt(2);
				if(scelta == 0) list.add(new Orco(50));
				else list.add(new Cavaliere(30));
			}
			
			Gestore g = new Gestore();
			g.setPersonaggi(list);
			g.saveFile("personaggi.txt");
		});
		
		formPanel.add(numLabel);
		formPanel.add(numText);
		formPanel.add(button);
		
		mainPanel.add(formPanel);
		
		return mainPanel;
	}
}
