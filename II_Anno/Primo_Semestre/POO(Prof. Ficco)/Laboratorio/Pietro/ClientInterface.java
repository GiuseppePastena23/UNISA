//Esercizio della lezione26(Layout), slide 34
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class ClientInterface extends JFrame {
	
	private JTextField nameField;
	private JTextField surnameField;
	private JTextField emailField;
	private JTextField phoneField;
	private JTextField studyTitleField;
	
	public ClientInterface() {
		setTitle("Test");
		setSize(320, 560);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel client = new JPanel(new BorderLayout());
		client.setBorder(new TitledBorder("Cliente"));
		
		JLabel request = new JLabel("Richiesta Occupazione");
		
		JPanel layoutHelper = new JPanel(new GridLayout(3, 1));
		
		JPanel info = new JPanel(new GridLayout(4, 2));
		info.setBorder(new TitledBorder("Informazioni Personali"));
		JLabel nameLabel = new JLabel("Nome:");
		nameField = new JTextField(20);
		JLabel surnameLabel = new JLabel("Cognome:");
		surnameField = new JTextField(20);
		JLabel emailLabel = new JLabel("E-mail:");
		emailField = new JTextField(30);
		JLabel phoneLabel = new JLabel("Telefono:");
		phoneField = new JTextField(15);
		info.add(nameLabel);
		info.add(nameField);
		info.add(surnameLabel);
		info.add(surnameField);
		info.add(emailLabel);
		info.add(emailField);
		info.add(phoneLabel);
		info.add(phoneField);
		
		JPanel formation = new JPanel(new BorderLayout());
		formation.setBorder(new TitledBorder("Formazione Personale"));
		JLabel english = new JLabel("Conoscenza lingua inglese");
		JPanel formationHelper1 = new JPanel(new GridLayout(2, 2));
		JRadioButton opt1 = new JRadioButton("Ottimo");
		JRadioButton opt2 = new JRadioButton("Buono");
		JRadioButton opt3 = new JRadioButton("Sufficiente");
		JRadioButton opt4 = new JRadioButton("Scarso");
		ButtonGroup group = new ButtonGroup();
		group.add(opt1);
		group.add(opt2);
		group.add(opt3);
		group.add(opt4);
		formationHelper1.add(opt1);
		formationHelper1.add(opt2);
		formationHelper1.add(opt3);
		formationHelper1.add(opt4);
		JPanel formationHelper2 = new JPanel(new GridLayout(1, 2));
		JLabel studyTitleLabel = new JLabel("Titolo di studio:");
		studyTitleField = new JTextField(20);
		formationHelper2.add(studyTitleLabel);
		formationHelper2.add(studyTitleField);
		formation.add(english, BorderLayout.NORTH);
		formation.add(formationHelper1, BorderLayout.CENTER);
		formation.add(formationHelper2, BorderLayout.SOUTH);
		
		JPanel interest = new JPanel(new GridLayout(3, 2));
		interest.setBorder(new TitledBorder("Interessi"));
		JCheckBox option1 = new JCheckBox("Informatica");
		JCheckBox option2 = new JCheckBox("Fisica");
		JCheckBox option3 = new JCheckBox("Elettronica");
		JCheckBox option4 = new JCheckBox("Matematica");
		JCheckBox option5 = new JCheckBox("Economia");
		JCheckBox option6 = new JCheckBox("Sociologia");
		interest.add(option1);
		interest.add(option2);
		interest.add(option3);
		interest.add(option4);
		interest.add(option5);
		interest.add(option6);
		
		layoutHelper.add(info);
		layoutHelper.add(formation);
		layoutHelper.add(interest);
		
		JButton send = new JButton("Invio");
		
		client.add(request, BorderLayout.NORTH);
		client.add(layoutHelper, BorderLayout.CENTER);
		client.add(send, BorderLayout.SOUTH);
		
		add(client);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new ClientInterface());
	}
}