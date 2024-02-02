package core;

import java.util.List;
import java.util.Objects;
import java.util.Vector;

public class Studente 
{
	private String matricola;
	private String nome;
	private String cognome;
	private int categoria;
	private int eta;
	private List<Corso> corsi;
	
	private static int countMatricola = 1;
	
	public static final int INCORSO = 0;
	public static final int FUORICORSO = 1;
	
	public Studente(String nome, String cognome, int categoria, int eta) 
	{
		this.matricola = "051210000" + countMatricola++;
		this.nome = nome;
		this.cognome = cognome;
		this.categoria = categoria;
		this.eta = eta;
		this.corsi = new Vector<Corso>();
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
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

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public List<Corso> getCorsi() {
		return corsi;
	}

	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}

	@Override
	public String toString() {
		return "Studente [matricola=" + matricola + ", nome=" + nome + ", cognome=" + cognome + ", categoria="
				+ categoria + ", eta=" + eta + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoria, cognome, eta, matricola, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studente other = (Studente) obj;
		return categoria == other.categoria && cognome.equalsIgnoreCase(other.cognome) && eta == other.eta
				&& matricola.equalsIgnoreCase(other.matricola) && nome.equalsIgnoreCase(other.nome);
	}

	public static int compareByEta(Studente o1, Studente o2)
	{
		if(o1.getEta() >= o2.getEta()) return 1;
		else return -1;
	}
	
	public void printInfo()
	{
		System.out.println(this);
	}
}
