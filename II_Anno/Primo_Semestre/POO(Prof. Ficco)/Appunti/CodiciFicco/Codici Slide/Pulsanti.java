import javax.swing.*;

public class Pulsanti extends JFrame {
	
	JButton pulsanteUno = new JButton("Pulsante uno");
	JButton pulsanteDue = new JButton("Pulsante due");
	
	public Pulsanti() {
		super("Prova pulsanti"); //JFrame con titolo
		setSize(300, 80);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel pannello = new JPanel();
		pannello.add(pulsanteUno);
		pannello.add(pulsanteDue);
		setContentPane(pannello);
		show();		//deprecated
	}
	
	public static void main(String[] args) {
		Pulsanti test = new Pulsanti();
		
		//test.setVisible(true);
	}
	
}