package gui;

import javax.swing.*;

import animali.*;

import java.awt.*;
import java.util.Random;

public class Main extends JFrame{
	
	StringBuilder sb = new StringBuilder();
	JTextArea output = new JTextArea(1000, 1000);
	ElencoAnimali animali = new ElencoAnimali();
	public Main() {
		super("Animali");
		setSize(400, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch(Exception e){
			System.out.println(e);
		}

		
		
		mainPanel.add(panel1(), BorderLayout.NORTH);
		mainPanel.add(panel2(), BorderLayout.CENTER);
		mainPanel.add(panel3(), BorderLayout.SOUTH);
		add(mainPanel);
		
		setVisible(true);
	}
	
	public JPanel panel1() {
		
		JPanel p = new JPanel();
		
		
		JTextField numField = new JTextField(10);
		JButton generateButton = new JButton("Generate");
		
		generateButton.addActionListener((e)->{
			Random random = new Random();
	        int n;
			for(int i = 0; i < Integer.parseInt(numField.getText()); i++) {
				n = random.nextInt(0, Tipi.values().length);
				switch(n) {
					case 0:
						System.out.println("genero cane");
						animali.addAnimale(new Cane("Cane" + i, random.nextDouble(5, 51)));
						break;
					case 1:
						System.out.println("genero uccello");
						animali.addAnimale(new Uccello("Uccello" + i));
						break;
					case 2:
						System.out.println("genero pesce");
						animali.addAnimale(new Pesce("Pesce" + i));
						break;
				}
			}
			try{
				output.append(numField.getText() + " Animali Generati:\n" +  + animali.getCounter("Cane") + " cani\n" + animali.getCounter("Uccello") + " uccelli\n" + animali.getCounter("Pesce") + " Pesci\n");
			}
			catch (BadAnimalException er) {
				System.out.println(er);
			}
		});
		
		p.add(new JLabel("Numero Animali"));
		p.add(numField);
		p.add(generateButton);
		
		return p;
	}
	
	public JPanel panel2() {
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.LEFT));
		p.setBackground(Color.white);

		

		// Add the output area to the panel
		p.add(output);


		return p;
	}
	
	public JPanel panel3() {
		JPanel p = new JPanel();
		JButton alimentaButton = new JButton("Alimenta");
		
		alimentaButton.addActionListener((e)->{
			int n = animali.alimenta();
			
			output.append("Animali alimentati - " + n + " invocazioni vuoiMangiare\n");
			System.out.println(n);
		});
		
		p.add(alimentaButton);
		return p;
	}
}
