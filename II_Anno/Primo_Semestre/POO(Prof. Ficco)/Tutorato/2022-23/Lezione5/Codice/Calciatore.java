package core;

import java.util.Objects;

import exception.NumberNotValidException;

public class Calciatore 
{
	private String nome;
	private String cognome;
	private String ruolo;
	private int numMaglia;
	private int goalFatti;
	
	public Calciatore(String nome, String cognome, String ruolo, int numMaglia, int goalFatti) 
	{	
		if(numMaglia < 1 || numMaglia > 99) throw new NumberNotValidException();
		this.nome = nome;
		this.cognome = cognome;
		this.ruolo = ruolo;
		this.numMaglia = numMaglia;
		this.goalFatti = goalFatti;
	}

	public Calciatore(String nome, String cognome, String ruolo, int numMaglia) 
	{	
		if(numMaglia < 1 || numMaglia > 99) throw new NumberNotValidException();
		this.nome = nome;
		this.cognome = cognome;
		this.ruolo = ruolo;
		this.numMaglia = numMaglia;
		this.goalFatti = 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public int getGoalFatti() {
		return goalFatti;
	}

	public void setGoalFatti(int goalFatti) {
		this.goalFatti = goalFatti;
	}

	public int getNumMaglia() {
		return numMaglia;
	}

	public void setNumMaglia(int numMaglia) {
		if(numMaglia < 1 || numMaglia > 99) throw new NumberNotValidException();
		this.numMaglia = numMaglia;
	}

	@Override
	public String toString() {
		return "Calciatore [nome=" + nome + ", cognome=" + cognome + ", ruolo=" + ruolo + ", numMaglia=" + numMaglia
				+ ", goalFatti=" + goalFatti + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cognome, goalFatti, nome, numMaglia, ruolo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calciatore other = (Calciatore) obj;
		return cognome.equalsIgnoreCase(other.cognome) && goalFatti == other.goalFatti
				&& nome.equalsIgnoreCase(other.nome) && numMaglia == other.numMaglia
				&& Objects.equals(ruolo, other.ruolo);
	}
	
	
}
