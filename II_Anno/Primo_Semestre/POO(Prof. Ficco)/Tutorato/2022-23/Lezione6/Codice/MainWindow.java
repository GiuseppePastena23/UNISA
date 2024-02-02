package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame 
{
	public MainWindow(String title)
	{
		this.setTitle(title);
		this.setSize(450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(250, 200);
		JPanel panel = new MainPanel();
		this.add(panel);
	}
}
