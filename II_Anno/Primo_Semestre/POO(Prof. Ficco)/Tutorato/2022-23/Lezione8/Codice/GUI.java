package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import core.Malware;

public class GUI extends JFrame 
{
	private ArrayList<Malware> listMalware;
	
	public GUI(String message,ArrayList<Malware> listMalware)
	{
		this.listMalware = listMalware;
		setTitle(message);
		setSize(250,150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel mainPanel = buildPanel();
		add(mainPanel);
	}
	
	public JPanel buildPanel()
	{
		JPanel mainPanel = new JPanel();
		//mainPanel.setBackground(Color.BLACK);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(3,1));
		
		JButton b1 = new JButton("Stampa Livello");
		b1.addActionListener(new StampaLivelloListener(this.listMalware,Malware.MEDIO));
		
		JButton b2 = new JButton("Stampa Ordinata");
		b2.addActionListener(new StampaOrderedListener(this.listMalware));
		
		JButton b3 = new JButton("Stampa Count");
		b3.addActionListener(new StampaCountListener(this.listMalware,2022));
		
		buttonPanel.add(b1);
		buttonPanel.add(b2);
		buttonPanel.add(b3);
		
		mainPanel.add(buttonPanel);
		
		return mainPanel;
	}
}
