
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class GUI extends JFrame {

	public GUI() {
		initialize();
	}

	private JPanel paneContent;
	JComboBox<String> cmbRuolo;

	private void initialize() {			
		//Dimensione del frame e centramento nello schermo
		Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = new Dimension ( 600, 400 );
		setBounds( ss.width / 2 - frameSize.width / 2, 
		                  ss.height / 2 - frameSize.height / 2,
		                  frameSize.width, frameSize.height );
		
		setTitle("Ricerca"); //Titolo Frame
		paneContent = new JPanel();
		
		paneContent.setBorder(new EmptyBorder(5, 30, 30, 30)); //Riquadro
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Panello principale del JFrame
		setContentPane(paneContent);
		GridBagLayout gbc = new GridBagLayout();
		//numero colonne (arr.length) e width minimo
		gbc.columnWidths = new int[] { 0, 0, 0 };
		//peso colonne, 1.0 = Grow per riempire lo spazio restante in orizzontale
		gbc.columnWeights = new double[] { 1.0, 1.0, 0, Double.MIN_VALUE };
		//numero righe (arr.length) e width minimo
		gbc.rowHeights = new int[] { 0, 0 };
		//peso righe, 1.0 = Grow per riempire lo spazio restante in verticale
		gbc.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		paneContent.setLayout(gbc);
		
		//Componenti
		GridBagConstraints txtCognomeGbc = new GridBagConstraints();
		JTextField txtCognome = new JTextField();
		txtCognomeGbc.fill = GridBagConstraints.HORIZONTAL;
		txtCognomeGbc.gridx = 0;
		txtCognomeGbc.gridy = 0;
		txtCognomeGbc.insets = new Insets(5, 5, 5, 5);
		paneContent.add(txtCognome, txtCognomeGbc);
		
		GridBagConstraints cmbRuoloGbc = new GridBagConstraints();
		cmbRuolo = new JComboBox<>();
		cmbRuoloGbc.fill = GridBagConstraints.HORIZONTAL;
		cmbRuoloGbc.gridx = 1;
		cmbRuoloGbc.gridy = 0;
		cmbRuoloGbc.insets = new Insets(5, 5, 5, 5);
		paneContent.add(cmbRuolo, cmbRuoloGbc);
		
		GridBagConstraints btnTrovaGbc = new GridBagConstraints();
		JButton btnTrova = new JButton("Trova");
		btnTrovaGbc.fill = GridBagConstraints.BOTH;
		btnTrovaGbc.gridx = 2;
		btnTrovaGbc.gridy = 0;
		btnTrovaGbc.insets = new Insets(5, 5, 5, 5);
		paneContent.add(btnTrova, btnTrovaGbc);
		
		GridBagConstraints txtDettagliEspertiGbc = new GridBagConstraints();
		JTextArea txtDettagliEsperti = new JTextArea();
		txtDettagliEsperti.append("");
		txtDettagliEsperti.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(50,50,50), new Color(255,255,255)));
		txtDettagliEspertiGbc.fill = GridBagConstraints.BOTH;
		txtDettagliEspertiGbc.gridx = 0;
		txtDettagliEspertiGbc.gridy = 1;
		txtDettagliEspertiGbc.insets = new Insets(5, 5, 5, 5);
		paneContent.add(txtDettagliEsperti, txtDettagliEspertiGbc);
		
		GridBagConstraints txtDettagliRuoloGbc = new GridBagConstraints();
		JTextArea txtDettagliRuolo = new JTextArea();
		txtDettagliRuolo.append("");
		txtDettagliRuolo.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(50,50,50), new Color(255,255,255)));
		txtDettagliRuoloGbc.fill = GridBagConstraints.BOTH;
		txtDettagliRuoloGbc.gridx = 1;
		txtDettagliRuoloGbc.gridy = 1;
		txtDettagliRuoloGbc.insets = new Insets(5, 5, 5, 5);
		paneContent.add(txtDettagliRuolo, txtDettagliRuoloGbc);
		
	}
	
	
}
