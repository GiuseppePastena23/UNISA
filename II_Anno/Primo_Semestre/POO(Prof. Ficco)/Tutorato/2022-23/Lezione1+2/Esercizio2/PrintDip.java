package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

import core.DipendentiManager;

public class PrintDip implements ActionListener {

	private DipendentiManager m;
	private JTextField salarioField;
	
	public PrintDip(DipendentiManager m, JTextField salarioField)
	{
		this.m = m;
		this.salarioField = salarioField;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		String salarioString = this.salarioField.getText();
		
		if(salarioString == null || salarioString.equals("")) return;
		
		int salarioParsed = Integer.parseInt(salarioString);
		this.m.printDipendentiBySalario(salarioParsed);
	}

}

