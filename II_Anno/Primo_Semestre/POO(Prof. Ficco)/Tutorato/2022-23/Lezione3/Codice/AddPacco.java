package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import core.ListaPacchiNatale;
import core.Pacco;

public class AddPacco implements ActionListener 
{	
	private ListaPacchiNatale m;
	private JTextField descrizione;
	private JTextField dataArrivo;
	private JComboBox status;

	public AddPacco(ListaPacchiNatale m, JTextField descrizione, JTextField dataArrivo, JComboBox status)
	{
		this.m = m;
		this.descrizione = descrizione;
		this.dataArrivo = dataArrivo;
		this.status = status;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String des = this.descrizione.getText();
		int stat = 0;
		String da = this.dataArrivo.getText();
		
		if(des.equals("")) return;
		
		if(this.status.getSelectedItem().equals("PICCOLO")) stat = Pacco.PICCOLO;
		else if(this.status.getSelectedItem().equals("PICCOLO")) stat = Pacco.MEDIO;
		else stat = Pacco.GRANDE;
		
		String[] dataSplitted = da.split("/");
		GregorianCalendar data = new GregorianCalendar(Integer.parseInt(dataSplitted[2]), Integer.parseInt(dataSplitted[1]) - 1, Integer.parseInt(dataSplitted[0]));
		
		Pacco p = new Pacco(des,data,stat);
		
		if(m.Aggiungi(p)) System.out.println("\n\nPacco Aggiunto!");
		else System.out.println("\n\nPacco NON Aggiunto!");
		
		System.out.println("\n\nNumero pacchi inseriti: " + m.getNumPacchiInseriti() + "\n\n");
		for(Pacco pacco : m.getListaPacchi()) System.out.println(pacco);

	}

}
