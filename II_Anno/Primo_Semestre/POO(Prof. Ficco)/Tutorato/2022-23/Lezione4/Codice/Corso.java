package core;

import java.util.Objects;

public class Corso 
{
	private String nome;
	private String docente;
	private int cfu;
	
	public Corso(String nome, String docente, int cfu) 
	{
		this.nome = nome;
		this.docente = docente;
		this.cfu = cfu;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocente() {
		return docente;
	}

	public void setDocente(String docente) {
		this.docente = docente;
	}

	public int getCfu() {
		return cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;
	}

	@Override
	public String toString() {
		return "Corso [nome=" + nome + ", docente=" + docente + ", cfu=" + cfu + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cfu, docente, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corso other = (Corso) obj;
		return cfu == other.cfu && docente.equalsIgnoreCase(other.docente) && nome.equalsIgnoreCase(other.nome);
	}
	
	
}
