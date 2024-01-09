//Esercizio della lezione 26(Layout), slide 33
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class ContactInterface extends JFrame {
	private JTextField nameField;
	private JTextField phoneField;
	private JTextField surnameField;
	private JTextField emailField;
	
	public ContactInterface() {
		setTitle("Test");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel newContact = new JPanel(new BorderLayout());
		newContact.setBorder(new TitledBorder("Nuovo Contatto"));
		
		JPanel infos = new JPanel(new GridLayout(6, 2));
		infos.setBorder(new TitledBorder("InfoContatto"));
		JLabel nameLabel = new JLabel("Nome:");
		nameField = new JTextField(20);
		JLabel phoneLabel = new JLabel("Telefono:");
		phoneField = new JTextField(15);
		JLabel surnameLabel = new JLabel("Cognome:");
		surnameField = new JTextField(20);
		JLabel emailLabel = new JLabel("E-mail:");
		emailField = new JTextField(30);
		JRadioButton male = new JRadioButton("Uomo");
		JRadioButton female = new JRadioButton("Donna");
		
		ButtonGroup sex = new ButtonGroup();	//esclusivamente logico
		sex.add(male);
		sex.add(female);
		
		infos.add(nameLabel);
		infos.add(nameField);
		infos.add(phoneLabel);
		infos.add(phoneField);
		infos.add(surnameLabel);
		infos.add(surnameField);
		infos.add(emailLabel);
		infos.add(emailField);
		
		infos.add(male);
		infos.add(new JLabel());
		infos.add(female);
		infos.add(new JLabel());				  
		
		JPanel actions = new JPanel();
		actions.setBorder(new TitledBorder("Azioni"));
		actions.setLayout(new FlowLayout());
		JButton search = new JButton("Cerca");
		JButton insert = new JButton("Inserisci");
		JButton cancel = new JButton("Cancella");
		actions.add(search);
		actions.add(insert);
		actions.add(cancel);
		
		newContact.add(infos, BorderLayout.CENTER);
		newContact.add(actions, BorderLayout.SOUTH);
		
		add(newContact);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new ContactInterface());
	}
	
}