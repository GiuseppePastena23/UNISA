package it.unisa.libreria;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;

public class GUI2Test extends JFrame {
	
	JPanel paneContent;
	JComboBox<String> cmbLibri;
	JButton btnVisualizza;
	JPanel paneDettagli;
	JTextArea txtDettagli;
	
	public GUI2Test() {
		initialize();
	}

	private void initialize() {

		
		setSize(new Dimension(600,400));
		paneContent = new JPanel();
		paneDettagli = new JPanel();
		cmbLibri = new JComboBox<>();
		btnVisualizza = new JButton("Visualizza");
		txtDettagli = new JTextArea();
		
		paneContent.setBorder(new EmptyBorder(5, 10, 10, 10));
		setContentPane(paneContent);
		GridBagLayout gbc = new GridBagLayout();
		gbc.columnWidths = new int[] {0, 0};
		gbc.columnWeights = new double[] {1.0, 0.0, Double.MIN_VALUE};
		gbc.rowHeights = new int[] {0, 0};
		gbc.rowWeights = new double[] {0.0, 1.0, Double.MIN_VALUE};
		paneContent.setLayout(gbc);
		
		GridBagConstraints cmbLibriGbc = new GridBagConstraints();
		cmbLibriGbc.gridx = 0;
		cmbLibriGbc.gridy = 0;
		cmbLibriGbc.insets = new Insets(5, 5, 5, 5);
		cmbLibriGbc.fill = GridBagConstraints.BOTH;
		paneContent.add(cmbLibri,cmbLibriGbc);
		
		GridBagConstraints gbc_btnVisualizza = new GridBagConstraints();
		JButton btnVisualizza = new JButton("Visualizza");
		gbc_btnVisualizza.fill = GridBagConstraints.BOTH;
		gbc_btnVisualizza.gridx = 1;
		gbc_btnVisualizza.gridy = 0;
		gbc_btnVisualizza.insets = new Insets(5, 5, 5, 5);
		paneContent.add(btnVisualizza, gbc_btnVisualizza);
		
		GridBagConstraints paneDettagliGbc = new GridBagConstraints();
		paneDettagliGbc.gridx = 0;
		paneDettagliGbc.gridy = 1;
		paneDettagliGbc.gridheight = 1;
		paneDettagliGbc.gridwidth = 0;
		paneDettagliGbc.insets = new Insets(5, 5, 5, 5);
		paneDettagliGbc.fill = GridBagConstraints.BOTH;
		paneDettagli.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED,new Color(230,230,230), new Color(230,230,230)),"Dettagli"));
		paneDettagli.setLayout(new BorderLayout(0, 0));
		paneDettagli.add(txtDettagli);
		paneContent.add(paneDettagli, paneDettagliGbc);
		
	}
}
