package gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame 
{
	private JPanel mainPanel;
	
	public MainWindow(String titleApp)
	{
		this.mainPanel = new PanelSearch();
		setBackground(Color.BLUE);
		setSize(500,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(titleApp);
		setResizable(false);
		add(this.mainPanel);
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}
}
