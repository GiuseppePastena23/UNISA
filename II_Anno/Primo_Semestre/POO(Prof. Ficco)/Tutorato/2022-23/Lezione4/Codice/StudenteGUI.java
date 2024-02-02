package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class StudenteGUI extends JFrame
{
	private JPanel mainPanel;
	
	public StudenteGUI(String title)
	{
		setTitle(title);
		setSize(450, 400);
		setLocation(350,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
