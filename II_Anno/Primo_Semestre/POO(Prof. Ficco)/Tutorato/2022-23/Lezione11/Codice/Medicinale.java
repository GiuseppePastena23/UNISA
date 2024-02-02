package core;

import java.util.GregorianCalendar;

public class Medicinale 
{
	protected String nome;
	protected String azienda;
	protected int numUnita;
	protected GregorianCalendar dataScadenza;
	
	public Medicinale(String nome, String azienda, int numUnita, GregorianCalendar dataScadenza) 
	{
		this.nome = nome;
		this.azienda = azienda;
		this.numUnita = numUnita;
		this.dataScadenza = dataScadenza;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAzienda() {
		return azienda;
	}

	public void setAzienda(String azienda) {
		this.azienda = azienda;
	}

	public int getNumUnita() {
		return numUnita;
	}

	public void setNumUnita(int numUnita) {
		this.numUnita = numUnita;
	}

	public GregorianCalendar getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(GregorianCalendar dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public String toString() {
		return "Medicinale [nome=" + nome + ", azienda=" + azienda + ", numUnita=" + numUnita + ", dataScadenza="
				+ dataScadenza + "]";
	}
	
}
