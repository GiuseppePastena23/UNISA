package it.unisa.libreria;

import java.util.ArrayList;
import java.util.List;

public abstract class Libro {
	
	private static long lastId = 0;
	private long id;
	private String titolo;
	private String autore;
	private int numPagine;
	private List<String> capitoli;
	
	public Libro() {
		this("Sconosciuto","Sconosciuto",0,null);
		this.id = 0;
	}
	
	public Libro(String titolo, int numPagine, List<String> capitoli) {
		this(titolo,"Sconosciuto",numPagine,capitoli);
	}

	public Libro(String titolo, String autore, int numPagine, List<String> capitoli) {
		this.titolo = titolo;
		this.autore = autore;
		this.numPagine = numPagine;
		this.capitoli = capitoli;
		this.id = lastId + 1;
		lastId = this.id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public int getNumPagine() {
		return numPagine;
	}

	public void setNumPagine(int numPagine) {
		this.numPagine = numPagine;
	}

	public List<String> getCapitoli() {
		return new ArrayList<>(capitoli);
	}

	public void setCapitoli(List<String> capitoli) {
		this.capitoli = capitoli;
	}

	public String getInitials() {
		if(this.getAutore().equals("Sconosciuto"))
			return "";
		String[] aut = this.getAutore().split(" ");
		if(aut.length >= 2)
			return aut[0] + aut[1] + aut[2];
		else
			return aut[0] + aut[1];
	}
	
	
	@Override
	public String toString() {
		return "Libro [id=" + id + ", titolo=" + titolo + ", autore=" + autore + ", numPagine=" + numPagine
				+ ", capitoli=" + capitoli + "]";
	}

	@Override
	public boolean equals(Object obj) {
		// Se e' lo stesso oggetto ritorna true
		if (obj == this) {
			return true;
		}
		/* Se non e' un istanza di Libro o obj e' null, ritorna false */
		if (!(obj instanceof Libro)) {
			return false;
		}
		// typecast a Libro in modo da poterli comparare 
		Libro libro = (Libro) obj;
		return this.getTitolo().equals(libro.getTitolo()) && 
				this.getAutore().equals(libro.getAutore()) && 
				this.getNumPagine() == libro.getNumPagine() &&
				this.capitoli.containsAll(libro.getCapitoli());
	}	
	
}
