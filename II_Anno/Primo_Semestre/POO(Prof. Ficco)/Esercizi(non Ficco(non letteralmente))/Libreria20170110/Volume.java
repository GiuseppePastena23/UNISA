package it.unisa.libreria;

import java.util.List;

public class Volume extends Libro {
	private String titoloEnciclopedia;
	private String nomeCuratore;
	
	
	public Volume(String titolo, int numPagine, List<String> capitoli, String titoloEnciclopedia, String nomeCuratore) {
		super(titolo, numPagine, capitoli);
		this.titoloEnciclopedia = titoloEnciclopedia;
		this.nomeCuratore = nomeCuratore;
	}


	public Volume(String titolo, String autore, int numPagine, List<String> capitoli, String titoloEnciclopedia,
			String nomeCuratore) {
		super(titolo, autore, numPagine, capitoli);
		this.titoloEnciclopedia = titoloEnciclopedia;
		this.nomeCuratore = nomeCuratore;
	}


	public Volume(String titoloEnciclopedia, String nomeCuratore) {
		super();
		this.titoloEnciclopedia = titoloEnciclopedia;
		this.nomeCuratore = nomeCuratore;
	}


	public String getTitoloEnciclopedia() {
		return titoloEnciclopedia;
	}


	public void setTitoloEnciclopedia(String titoloEnciclopedia) {
		this.titoloEnciclopedia = titoloEnciclopedia;
	}


	public String getNomeCuratore() {
		return nomeCuratore;
	}


	public void setNomeCuratore(String nomeCuratore) {
		this.nomeCuratore = nomeCuratore;
	}
	
	
	
}
