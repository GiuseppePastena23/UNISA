package preappello2022;

import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.util.Arrays;

public class DisplayAnimali extends JFrame {
	private JTextField numberField;
	private JButton inputButton;
	private JTextArea outputArea;
	private JButton alimentaButton;
	public ElencoAnimali elenco = new ElencoAnimali();
	
	public DisplayAnimali() {
		setTitle("Test");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel pannello = new JPanel(new BorderLayout());
		
		//north elements
		JPanel northHelper = new JPanel(new BorderLayout());
		JLabel numAnimali = new JLabel("Numero Animali:");
		numberField = new JTextField(10);
		inputButton = new JButton("Genera");
		
		inputButton.addActionListener((e) -> {
			Random generatore = new Random();
			int n;
			for(int i = 0; i < Integer.parseInt(numberField.getText()); i++) {
				n = generatore.nextInt(0, Tipologie.values().length);
				switch(n) {
					case 0:
						elenco.addAnimale(new Cane("Cane" + i, generatore.nextDouble(5, 51)));
						break;
					case 1:
						elenco.addAnimale(new Pesce("Pesce" + i));
						break;
					case 2:
						elenco.addAnimale(new Uccello("Uccello" + i));
						break;
				}
			}
			try {
				outputArea.append(numberField.getText() + " Animali generati\n" +
					elenco.getCounter("Cane") + " cani\n" + elenco.getCounter("Uccello") + " uccelli\n" + 
					elenco.getCounter("Pesce") + " pesci\n");
			} catch (BadAnimalException err) {
				System.out.println(err);
			}
			
		});
		
		
		northHelper.add(numAnimali, BorderLayout.WEST);
		northHelper.add(numberField, BorderLayout.CENTER);
		northHelper.add(inputButton, BorderLayout.EAST);
		
		//center elements
		outputArea = new JTextArea();
		outputArea.setEditable(false);
		JScrollPane outputScroll = new JScrollPane(outputArea);
		
		//south elements
		alimentaButton = new JButton("Alimenta");
		alimentaButton.addActionListener((e) -> {
			int n = elenco.alimenta();
			outputArea.append("Animali alimentati - " + n + " invocazioni di vuoiMangiare\n");
		});
		
		//panel composition
		pannello.add(northHelper, BorderLayout.NORTH);
		pannello.add(outputScroll, BorderLayout.CENTER);
		pannello.add(alimentaButton, BorderLayout.SOUTH);
		add(pannello);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new DisplayAnimali());
	}
}