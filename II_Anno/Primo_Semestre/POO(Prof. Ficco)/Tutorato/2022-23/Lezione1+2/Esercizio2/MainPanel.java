package gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import core.DipendentiManager;

public class MainPanel extends JPanel 
{
	private DipendentiManager manager;
	
	public MainPanel()
	{
		this.manager = new DipendentiManager();
		buildPanel();
	}
	
	private void buildPanel()
	{
		this.setLayout(new GridLayout(2,1));
		
		JPanel up = new JPanel();
		up.setBackground(Color.RED);
		
		JButton load = new JButton("Carica File");
		JButton save = new JButton("Salva File");
		JButton stag = new JButton("Print Stagisti");
		
		load.addActionListener(new LoadData(this.manager));
		save.addActionListener(new SaveFile(this.manager));
		stag.addActionListener(new PrintStagisti(this.manager));
		
		up.add(load);
		up.add(save);
		up.add(stag);
		
		this.add(up);
		
		JPanel downPanel = new JPanel();
		downPanel.setBackground(Color.BLUE);
		
		JButton b3 = new JButton("Search");
		JTextField text = new JTextField(10);
		
		b3.addActionListener(new PrintDip(this.manager,text));
		
		downPanel.add(b3);
		downPanel.add(text);
		add(downPanel);
	}
}
