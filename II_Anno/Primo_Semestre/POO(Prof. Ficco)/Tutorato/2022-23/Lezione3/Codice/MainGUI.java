package gui;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import core.ListaPacchiNatale;

public class MainGUI extends JFrame
{
	private ListaPacchiNatale m;
	
	public MainGUI(String title)
	{
		GregorianCalendar dataCreazione = new GregorianCalendar(2022,GregorianCalendar.DECEMBER,20);
		GregorianCalendar dataConsegna = new GregorianCalendar(2022,GregorianCalendar.DECEMBER,24,23,59);
		
		this.m = new ListaPacchiNatale(dataCreazione,dataConsegna);
		
		setTitle(title);
		setSize(500,150);
		setLocation(300,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(buildPanel());
	}
	
	private JPanel buildPanel()
	{
		JPanel panel = new JPanel();
		
		JLabel labDescrizione = new JLabel("Descrizione");		
		JTextField descrizione = new JTextField("",15);
		
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
	    Calendar cal = Calendar.getInstance();
	    
	    JLabel labData = new JLabel("Data arrivo");
		JTextField dataArrivo = new JTextField(10);
		dataArrivo.setText(dateFormat.format(cal.getTime()));
		
		JLabel labStatus = new JLabel("Tipologia");
		JComboBox status = new JComboBox();
		status.addItem("PICCOLO");
		status.addItem("MEDIO");
		status.addItem("GRANDE");
		
		JButton addButton = new JButton("Aggiungi");
		addButton.addActionListener(new AddPacco(m,descrizione,dataArrivo,status));
		
		panel.add(labDescrizione);
		panel.add(descrizione);
		
		panel.add(labData);
		panel.add(dataArrivo);
		
		panel.add(labStatus);
		panel.add(status);
		
		panel.add(addButton);
		
		return panel;
	}
}
