package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import core.Studente;
import core.StudentiManager;
import exception.CampiVuotoException;

public class MainPanel extends JPanel 
{
	private StudentiManager m;

	public MainPanel() 
	{
		this.m = new StudentiManager();
		buildPanel();
	}

	private void buildPanel()
	{
		this.setLayout(new BorderLayout());

		JPanel northPanel = new JPanel();

		JButton saveOnFile = new JButton("Salva su file");
		saveOnFile.addActionListener(new SaveStudenti(this.m));
		northPanel.add(saveOnFile);

		JPanel cenPanel = new JPanel();

		JLabel nome = new JLabel("Nome");
		JTextField nomeText = new JTextField("",12);

		JLabel cognome = new JLabel("Cognome");
		JTextField cognomeText = new JTextField("",12);

		JLabel eta = new JLabel("Eta'");
		JComboBox etaBox = new JComboBox();

		for(int i = 18; i <= 40; i++) etaBox.addItem("" + i);

		JLabel categoria = new JLabel("Categoria");
		JComboBox catBox = new JComboBox();
		catBox.addItem("IN CORSO");
		catBox.addItem("FUORI CORSO");

		JButton add = new JButton("Aggiungi");


		add.addActionListener((ActionEvent e)->{

			String n = nomeText.getText();
			String c = cognomeText.getText();

			try
			{
				if(n.equals("") || c.equals("")) throw new CampiVuotoException();
			}
			catch(CampiVuotoException e1)
			{
				System.out.println(e1.getMessage());
			}
			
			int etaParsed = Integer.parseInt((String) etaBox.getSelectedItem());
			
			int cat = 0;
			if(((String) catBox.getSelectedItem()).equals("IN CORSO")) cat = Studente.INCORSO;
			else cat = Studente.FUORICORSO;
			
			Studente app = new Studente(n,c,cat,etaParsed);
			
			this.m.add(app);
			
			System.out.println("\n\nStudente: " + app + " aggiunto al sistema!");
		});


		cenPanel.add(nome);
		cenPanel.add(nomeText);
		cenPanel.add(cognome);
		cenPanel.add(cognomeText);
		cenPanel.add(eta);
		cenPanel.add(etaBox);
		cenPanel.add(categoria);
		cenPanel.add(catBox);
		cenPanel.add(add);

		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(2,2));

		JButton studEta = new JButton("Studenti per eta'");
		studEta.addActionListener(new PrintStudenti(this.m.getStudenti()));
		
		JButton studFC = new JButton("Studenti fuori corso");
		studFC.addActionListener((ActionEvent e)->{
			
			System.out.println("\n\nStampa degli studenti fuori corso\n\n");
			for(Studente s : this.m.getStudenti()) if(s.getCategoria() == Studente.FUORICORSO) System.out.println(s);
		});
		
		JButton studO30 = new JButton("Studenti over 30");
		studO30.addActionListener((ActionEvent e)->{
			
			System.out.println("\n\nStampa studenti over 30\n\n");
			StudentiManager.printStudByCond(this.m.getStudenti(),  s -> s.getEta() > 30, s -> s.printInfo());
		});
		
		JButton studU30 = new JButton("Studenti under 30");
		studU30.addActionListener((ActionEvent e)->{
			
			System.out.println("\n\nStampa studenti under 30\n\n");
			StudentiManager.printStudByCond(this.m.getStudenti(), s -> s.getEta() <= 30, s -> s.printInfo());
		});

		southPanel.add(studEta);
		southPanel.add(studFC);
		southPanel.add(studO30);
		southPanel.add(studU30);
		

		add(northPanel,BorderLayout.NORTH);
		add(cenPanel,BorderLayout.CENTER);
		add(southPanel,BorderLayout.SOUTH);

	}
}
