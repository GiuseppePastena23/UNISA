import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class FileCopyGUI extends JFrame {
	private JTextField sourceTextField;
	private JTextField destinationTextField;

	public FileCopyGUI() {
		setTitle("File Copy GUI");
		setSize(400, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Components
		JLabel sourceLabel = new JLabel("Source File:");
		sourceTextField = new JTextField(20);
		JLabel destinationLabel = new JLabel("Destination File:");
		destinationTextField = new JTextField(20);
		JButton copyButton = new JButton("Copy File");
		copyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				copyFile();
			}
		});
		
		JButton copyInvertButton = new JButton("Copy switch case");
		copyInvertButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				copyFileInvert();
			}
		});
		
		//Panels
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel aidPanel = new JPanel(new GridLayout(2, 2));
		JPanel aidPanel2 = new JPanel(new GridLayout(1, 2));
		aidPanel.add(sourceLabel);
		aidPanel.add(sourceTextField);
		aidPanel.add(destinationLabel);
		aidPanel.add(destinationTextField);
		aidPanel2.add(copyButton);
		aidPanel2.add(copyInvertButton);
		mainPanel.add(aidPanel, BorderLayout.CENTER);
		mainPanel.add(aidPanel2, BorderLayout.SOUTH);
		
		add(mainPanel);
		setLocationRelativeTo(null);
		setVisible(true);
    }

    private void copyFile() {
		String sourcePath = sourceTextField.getText();
		String destinationPath = destinationTextField.getText();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(sourcePath));
			 BufferedWriter writer = new BufferedWriter(new FileWriter(destinationPath))) {
			
			String line;
			while ((line = reader.readLine()) != null) {
				writer.write(line);
				writer.newLine();
			}
			JOptionPane.showMessageDialog(this, "File copiato con successo!");
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Errore nella copia del file: " + e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void copyFileInvert() {
		String sourcePath = sourceTextField.getText();
		String destinationPath = destinationTextField.getText();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(sourcePath));
			 BufferedWriter writer = new BufferedWriter(new FileWriter(destinationPath))) {
			
			String originalLine;
			while ((originalLine = reader.readLine()) != null) {
				String transformedLine = transformCase(originalLine);
				writer.write(transformedLine);
				writer.newLine();
			}
			
			JOptionPane.showMessageDialog(this, "File copiato con successo!");
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Erroro nella copia del file: " + e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private String transformCase(String originalLine) {
		int length = originalLine.length();
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < length; i++) {
			char currentChar = originalLine.charAt(i);
			if(Character.isUpperCase(currentChar)) {
				result.append(Character.toLowerCase(currentChar));
			} else if(Character.isLowerCase(currentChar)) {
				result.append(Character.toUpperCase(currentChar));
			} else {	//non alfabetico
				result.append(currentChar);
			}
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new FileCopyGUI();
			}
		});
	}
}