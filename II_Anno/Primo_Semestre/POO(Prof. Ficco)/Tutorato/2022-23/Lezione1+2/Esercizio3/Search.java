package gui;

import core.LocaliManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class Search implements ActionListener {

	private LocaliManager manager;
	private JTextField text;
	
	public Search(LocaliManager m,JTextField text)
	{
		this.text = text;
		this.manager = m;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		this.manager.printPizzerieByPizza(this.text.getText());
	}

}
