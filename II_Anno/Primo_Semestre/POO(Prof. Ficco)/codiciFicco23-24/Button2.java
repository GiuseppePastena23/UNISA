import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
/*import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;*/

public class Button2 extends JFrame {
	private JButton b1 = new JButton("Button 1");
	JButton b2 = new JButton("Button 2");
	private JTextField txt = new JTextField(10);
	public Button2() {
		super("2 pulsanti");
		setSize(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	//added
		JPanel p = new JPanel();
		
		//Classe interna
		class ClickListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				System.out.println("I was clicked.");	
			}
		}
		
		//Due modi diversi per aggiungere un nuovo clickListener al pulsante
		ActionListener listener = new ClickListener();	//quando usa variabili o oggetti interi di Button2, deve essere aggiunta come classe interna
		b1.addActionListener(listener);
		b2.addActionListener(new ClickListener());
		p.add(b1);
		p.add(b2);
		p.add(txt);
		
		add(p);	//analogo a setContentPane (Ficco aveva dimenticato di inserirlo)
	}
	public static void main(String[] args){
		JFrame frame = new Button2();
		frame.setVisible(true);	//instead of show()
	}
}