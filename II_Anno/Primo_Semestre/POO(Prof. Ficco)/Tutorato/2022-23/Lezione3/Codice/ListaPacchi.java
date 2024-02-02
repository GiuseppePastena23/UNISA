package core;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import interfacce.Lista;

//8 Punti
public abstract class ListaPacchi implements Lista 
{
	private static int ID = 0;
	
	private int codLista = 0;
	private GregorianCalendar dataCreazione;
	private GregorianCalendar dataConsegna;
	private ArrayList<Pacco> listaPacchi;
	
	
	public ListaPacchi(GregorianCalendar dataCreazione, GregorianCalendar dataConsegna) 
	{
		this.codLista = ID++;
		this.dataCreazione = dataCreazione;
		this.dataConsegna = dataConsegna;
		this.listaPacchi = new ArrayList<Pacco>();
	}

	abstract boolean Modifica(GregorianCalendar data);
	
	public int getCodLista() {
		return codLista;
	}

	public void setCodLista(int codLista) {
		this.codLista = codLista;
	}

	public GregorianCalendar getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(GregorianCalendar dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public GregorianCalendar getDataConsegna() {
		return dataConsegna;
	}

	public void setDataConsegna(GregorianCalendar dataConsegna) {
		this.dataConsegna = dataConsegna;
	}

	public ArrayList<Pacco> getListaPacchi() {
		return listaPacchi;
	}

	public void setListaPacchi(ArrayList<Pacco> listaPacchi) {
		this.listaPacchi = listaPacchi;
	}

}
