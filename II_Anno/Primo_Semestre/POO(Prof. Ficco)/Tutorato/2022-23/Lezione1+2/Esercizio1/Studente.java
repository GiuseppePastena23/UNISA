import java.util.ArrayList;
import java.util.Objects;

public class Studente 
{
	private String matricola;
	private String nome;
	private String cognome;
	private ArrayList<Esame> elencoEsami;
	
	
	public Studente(String matricola, String nome, String cognome) 
	{
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.elencoEsami = new ArrayList<Esame>();
	}
	
	public boolean insertEsame(Esame e)
	{
		if(this.elencoEsami.contains(e)) return false;
		else
		{
			this.elencoEsami.add(e);
			return true;
		}
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
	public ArrayList<Esame> getElencoEsami() {
		return elencoEsami;
	}
	public void setElencoEsami(ArrayList<Esame> elencoEsami) {
		this.elencoEsami = elencoEsami;
	}
	
	@Override
	public String toString() {
		return "Studente [matricola=" + matricola + ", nome=" + nome + ", cognome=" + cognome + "]";
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
		
		Studente other = (Studente) obj;
		return this.matricola.equals(other.getMatricola());
	}
	
	
}
