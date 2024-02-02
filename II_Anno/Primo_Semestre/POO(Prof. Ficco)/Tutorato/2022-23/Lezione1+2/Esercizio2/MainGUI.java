package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainGUI extends JFrame 
{
	private JPanel mainPanel;
	
	public MainGUI(String title)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(title);
		setSize(300,200);
		setLocation(250,250);
		this.mainPanel = new MainPanel();
		add(this.mainPanel);
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}
	
	
}
