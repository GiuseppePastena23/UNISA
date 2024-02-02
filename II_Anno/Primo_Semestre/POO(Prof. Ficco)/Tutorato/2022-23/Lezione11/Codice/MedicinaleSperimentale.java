package core;

import java.util.GregorianCalendar;

public class MedicinaleSperimentale extends Medicinale 
{
	public final static int INIZIO = 0;
	public final static int INTERMEDIO = 1;
	public final static int FINE = 2;
	
	private int stato;
	private int giorniSperimentazione;
	
	public MedicinaleSperimentale(String nome, String azienda, int numUnita, GregorianCalendar dataScadenza) 
	{
		super(nome, azienda, numUnita, dataScadenza);
		this.stato = MedicinaleSperimentale.INTERMEDIO;
		this.giorniSperimentazione = 0;
	}

	public int getStato() {
		return stato;
	}

	public void setStato(int stato) {
		this.stato = stato;
	}

	public int getGiorniSperimentazione() {
		return giorniSperimentazione;
	}

	public void setGiorniSperimentazione(int giorniSperimentazione) {
		this.giorniSperimentazione = giorniSperimentazione;
	}

	public String toString() {
		return "MedicinaleSperimentale [stato=" + stato + ", " + giorniSperimentazione
				+ ", toString()=" + super.toString() + "]";
	}
	
}
