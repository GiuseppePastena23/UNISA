package core;

import java.util.GregorianCalendar;

public class Pacco
{
	public final static int PICCOLO = 0;
	public final static int MEDIO = 1;
	public final static int GRANDE = 2;
	
	private static int ID = 0;
	
	private int codicePacco;
	private String descrizione;
	private GregorianCalendar dataArrivo;
	private int tipologia;
	
	public Pacco(String descrizione, GregorianCalendar dataArrivo, int tipologia) 
	{
		this.codicePacco = ID++;
		this.descrizione = descrizione;
		this.dataArrivo = dataArrivo;
		this.tipologia = tipologia;
	}

	public int getCodicePacco() {
		return codicePacco;
	}

	public void setCodicePacco(int codicePacco) {
		this.codicePacco = codicePacco;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public GregorianCalendar getDataArrivo() {
		return dataArrivo;
	}

	public void setDataArrivo(GregorianCalendar dataArrivo) {
		this.dataArrivo = dataArrivo;
	}

	public int getTipologia() {
		return tipologia;
	}

	public void setTipologia(int tipologia) {
		this.tipologia = tipologia;
	}

	@Override
	public String toString() {
		return "Pacco [codicePacco=" + codicePacco + ", descrizione=" + descrizione + ", dataArrivo=" 
	            + this.formatData() + ", tipologia=" + tipologia + "]";
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Pacco other = (Pacco) obj;
		
		return codicePacco == other.codicePacco && dataArrivo.equals(other.dataArrivo)
				&& descrizione.equals(other.descrizione) && tipologia == other.tipologia;
	}

	public static int compareByDataArrivo(Pacco a, Pacco b) 
	{
		return a.getDataArrivo().compareTo(b.getDataArrivo());
	}

	public String formatData() 
	{
		GregorianCalendar c = this.getDataArrivo();
		String data = "" + c.get(GregorianCalendar.DAY_OF_MONTH) + "/" + c.get(GregorianCalendar.MONTH) + "/" + c.get(GregorianCalendar.YEAR);
		return data;
	}
}
