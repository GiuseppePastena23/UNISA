//Esercizio della lezione 26(Layout), slide 32
import javax.swing.*;
import java.awt.*;

public class LoginInterface extends JFrame {
	private JTextField usernameField;
	private JPasswordField passwordField;
	
	public LoginInterface() {
		setTitle("Login");
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setLayout(new BorderLayout());
		
		JLabel usernameLabel = new JLabel("User:");
		JLabel passwordLabel = new JLabel("Password:");
		usernameField = new JTextField(20);
		passwordField = new JPasswordField(20);
		
		JPanel loginPanel = new JPanel(new GridLayout(2, 2));
		
		loginPanel.add(usernameLabel);
		loginPanel.add(usernameField);
		loginPanel.add(passwordLabel);
		loginPanel.add(passwordField);
		
		add(loginPanel, BorderLayout.CENTER);
		
		JButton loginButton = new JButton("OK");
		add(loginButton, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		LoginInterface login = new LoginInterface();
		login.setVisible(true);
	}
}