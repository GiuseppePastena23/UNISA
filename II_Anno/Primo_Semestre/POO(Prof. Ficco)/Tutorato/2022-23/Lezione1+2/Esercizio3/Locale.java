package core;

import java.util.Objects;

public abstract class Locale
{
	private String nome;
	private String indirizzo;
	private int numPosti;
	
	public Locale(String nome, String indirizzo, int numPosti)
	{
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.numPosti = numPosti;
	}
	
	public abstract boolean prenotazione(int numPersone);

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public int getNumPosti() {
		return numPosti;
	}

	public void setNumPosti(int numPosti) {
		this.numPosti = numPosti;
	}

	public String toString() {
		return "Locale [nome=" + nome + ", indirizzo=" + indirizzo + ", numPosti=" + numPosti + "]";
	}

    @Override
	public int hashCode() {
		return Objects.hash(indirizzo, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Locale other = (Locale) obj;
		return this.indirizzo.equalsIgnoreCase(other.getIndirizzo()) &&
				this.nome.equalsIgnoreCase(other.getNome());
	}
    
    
}
