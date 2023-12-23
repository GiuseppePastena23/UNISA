import javax.swing.*;

public class Semplice extends JFrame {
	
	public Semplice (String titolo) {
		super(titolo);
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Semplice frame = new Semplice("Titolo");
		
		frame.setVisible(true);
	}
}