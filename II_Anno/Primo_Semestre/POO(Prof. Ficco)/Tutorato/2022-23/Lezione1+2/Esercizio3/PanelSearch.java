package gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import core.LocaliManager;

public class PanelSearch extends JPanel 
{
	private JTextField textField;
	private JButton search;
	private LocaliManager m;
	
	public PanelSearch()
	{
		this.m = LocaliManager.createManager();
		buildPanel();
	}
	
	private void buildPanel()
	{
		this.textField = new JTextField(20);
		this.search = new JButton("Search");
		
		this.search.addActionListener(new Search(m,this.textField));
		
		add(this.textField);
		add(this.search);
	}
}
