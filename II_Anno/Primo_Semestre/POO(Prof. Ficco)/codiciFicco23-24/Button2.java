//broke
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class Button2 extends JFrame {
	private JButton b1 = new JButton("Button 1");
	JButton b2 = new JButton("Button 2");
	private JTextField txt = new JTextField(10);
	public Button2() {
		super("2 pulsanti");
		setSize(400, 300);
		JPanel p = new JPanel();
		ActionListener listener = new ClickListener();
		b1.addActionListener(listener);
		b2.addActionListener(new ClickListener());
		p.add(b1);
		p.add(b2);
		p.add(txt);
	}
	public static void main(String[] args){
		JFrame frame = new Button2();
		frame.show();
	}
}