package it.unisa.libreria;

import javax.swing.JFrame;
import javax.swing.JList;

import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Insets;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ListCellRenderer;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

public class GUI extends JFrame {
	private JButton btnVisualizza;
	private JComboBox<String> cmbLibri;
	private JTextArea txtDettagli;
	private Libreria libreria;
	
	public GUI(Libreria libreria) {
		this.libreria = libreria;
		initializeGUI();
		fillGUI();
	}


	private void fillGUI() {
		System.out.println(String.format("Fill %d", this.libreria.getLibri().size()));
		for (Libro libro : libreria.getLibri()) {
			this.cmbLibri.addItem(libro.getTitolo());
		}
	}


	private void initializeGUI() {
		setTitle("Libreria");
		setSize(new Dimension(1024,768));

		
		JPanel panel = new JPanel();
		setContentPane(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		cmbLibri = new JComboBox<>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(5, 5, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 0;
		panel.add(cmbLibri, gbc_comboBox);
		
		btnVisualizza = new JButton("Visualizza");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(5, 5, 5, 0);
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 0;
		panel.add(btnVisualizza, gbc_btnNewButton);
		btnVisualizza.addActionListener(e -> onVisualizzaClick());
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Dettagli", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.insets = new Insets(5, 5, 5, 5);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		txtDettagli = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridwidth = 2;
		gbc_textArea.insets = new Insets(0, 0, 0, 5);
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 0;
		panel_1.add(txtDettagli, gbc_textArea);
	}

	private void onVisualizzaClick() {
		String lib;
		if((lib = (String) this.cmbLibri.getSelectedItem()) != null) {
			try {
				this.txtDettagli.setText(this.libreria.ricercaLibro(lib).toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	public JButton getBtnNewButton() {
		return btnVisualizza;
	}
	public JComboBox<String> getComboBox() {
		return cmbLibri;
	}
	public JTextArea getTextArea() {
		return txtDettagli;
	}
}
