package esame_2016_06_23;

import javax.swing.*;
import java.awt.*;

public class StarterGUI extends JFrame {
	public StarterGUI(ProgrammazioneDidattica p) {
		super("ProgrammazioneDidattica " + p.getNome());
		setSize(300, 200);
		setDefaultCloseOpereation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel northPanel = new JPanel(new GridLayout(1, 2));
		JPanel centerPanel = new JPanel();
		JPanel southPanel = new JPanel(new GridLayout(1, 2));
		
		JLabel costoText = new JLabel("Costo della Programmazione:");
		JLabel costoTotale = new JLabel(String.valueOf(p.calcolaCostoTotale()));
		northPanel.add(costoText);
		northPanel.add(costoTotale);
		
		JComboBox<String> corsiInseriti = new JComboBox<>(p.getCorsi().stream()
														  .map(Corso::toString)
														  .toArray(String[]::new));
		
		JButton verificaButton = new JButton("Verifica");
		JLabel verificaLabel = new JLabel();
		verificaButton.addActionListener(e -> {
			verificaLabel.setText(p.verifica() ? "Requisiti soddisfatti" : "Requisiti non soddisfatti");
		});
		southPanel.add(verificaButton);
		southPanel.add(verificaLabel);
		
		mainPanel.add(northPanel, BorderLayout.NORTH);
		mainPanel.add(southPanel, BorderLayout.SOUTH);
		add(mainPanel);
		setPositionRelativeTo(null);
		setVisible(true);
	}
}