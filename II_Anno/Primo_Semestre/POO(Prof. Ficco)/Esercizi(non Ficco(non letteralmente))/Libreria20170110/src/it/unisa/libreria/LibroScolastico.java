package it.unisa.libreria;

import java.util.List;

public class LibroScolastico extends Libro {
	private String ordine;
	private String gradoScolastico;
	private String titoloCD;
	
	public LibroScolastico(String ordine, String gradoScolastico, String titoloCD) {
		super();
		this.setOrdine(ordine);
		this.setGradoScolastico(gradoScolastico);
		this.setTitoloCD(titoloCD);
	}
	
	public LibroScolastico(String titolo, int numPagine, List<String> capitoli, String ordine, String gradoScolastico,
			String titoloCD) {
		super(titolo, numPagine, capitoli);
		this.setOrdine(ordine);
		this.setGradoScolastico(gradoScolastico);
		this.setTitoloCD(titoloCD);
	}

	public LibroScolastico(String titolo, String autore, int numPagine, List<String> capitoli, String ordine,
			String gradoScolastico, String titoloCD) {
		super(titolo, autore, numPagine, capitoli);
		this.setOrdine(ordine);
		this.setGradoScolastico(gradoScolastico);
		this.setTitoloCD(titoloCD);
	}

	public String getTitoloCD() {
		return titoloCD;
	}

	public void setTitoloCD(String titoloCD) {
		this.titoloCD = titoloCD;
	}

	public String getGradoScolastico() {
		return gradoScolastico;
	}

	public void setGradoScolastico(String gradoScolastico) {
		this.gradoScolastico = gradoScolastico;
	}

	public String getOrdine() {
		return ordine;
	}

	public void setOrdine(String ordine) {
		this.ordine = ordine;
	}
	
	
	
}
