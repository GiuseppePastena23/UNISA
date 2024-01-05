
/*Aggiungere grafica ai pulsanti
ImageIcon img = new ImageIcon("c:\\...\\ img1.gif ");
//legge il file .gif e lo incorpora nell'oggetto img
JButton pulsanteUno = new Jbutton(img);
//passo img al costruttore del pulsante
*/

import javax.swing.*;

public class MyJLabelJTextFieldJFrame extends JFrame {
	JLabel etichetta = new JLabel("Etichetta");
	JTextField campoDiTesto = new JTextField("Scrivi qui", 30);
	JTextArea areaDiTesto = new JTextArea("Questa ? un'area di testo di\n6 righe e 20 colonne", 6, 20);
	
	public MyJLabelJTextFieldJFrame() {
		super("Finestra con Etichette e Campi");
		setSize(350, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel pannello = new JPanel();
		//impostiamo le proprietà dei componenti
		campoDiTesto.setEditable(true);
		areaDiTesto.setLineWrap(true);
		areaDiTesto.setWrapStyleWord(true);
		//aggiungiamo i componenti al pannello
		pannello.add(etichetta);
		pannello.add(campoDiTesto);
		pannello.add(areaDiTesto);
		//rendiamo il pannello parte del nostro frame
		setContentPane(pannello);
		show();	//deprecated
	}
	
	public static void main(String argv[]) {	//a quanto pare ogni tanto lo scrive anche in questo modo, per non scontentare nessuno
		MyJLabelJTextFieldJFrame ec = new MyJLabelJTextFieldJFrame();
	}
	
}