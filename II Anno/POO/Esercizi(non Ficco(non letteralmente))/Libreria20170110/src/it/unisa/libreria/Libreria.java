package it.unisa.libreria;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Libreria {
	private List<Libro> libri;
	
	public Libreria() {
		this.libri = new ArrayList<>();
	}
	
	public void aggiungiLibro(Libro libro) {
		this.libri.add(libro);
	}
	
	public Libro ricercaLibro(String titolo) throws IOException {
		Libro libroCercato = null;
		for (Libro libro : getLibri()) {
			if(libro.getTitolo().equals(titolo)) {
				libroCercato = libro;
				break;
			}
		}
		if(libroCercato == null)
			throw new IOException();
		return libroCercato;
	}
	
	public String libriToString() {
		StringBuilder str = new StringBuilder();
		for (Libro libro : getLibri()) {
			str.append(libro.getClass().getSimpleName()); str.append(",");
			str.append(libro.getTitolo()); str.append(",");
			str.append(libro.getAutore()); str.append(",");
			str.append(libro.getNumPagine()); str.append(",");
			for (String capitolo : libro.getCapitoli()) {
				str.append(capitolo); str.append(";");
			}
			str.deleteCharAt(str.length()-1); //remove last ;
			str.append(",");
			if(libro instanceof LibroScolastico) {
				var ls = (LibroScolastico) libro;
				str.append(ls.getGradoScolastico()); str.append(",");
				str.append(ls.getOrdine()); str.append(",");
				str.append(ls.getTitoloCD());
			} else if (libro instanceof Volume) {
				var vol = (Volume) libro;
				str.append(vol.getTitoloEnciclopedia()); str.append(",");
				str.append(vol.getNomeCuratore());
			}
			str.append(String.format("%n"));
		}
		return str.toString();
	}
	
	public void loadFromFile(String fileName) {
		System.out.println("Reading");
		File myObj = new File(fileName);
		try (Scanner myReader = new Scanner(myObj)) {
			while (myReader.hasNextLine()) {
				String[] lib = myReader.nextLine().split(",");
				System.out.println(lib.toString());
				if(lib[0].equals("LibroScolastico") || lib[0].equals("Volume")) {
					Libro libro;
					String titolo = lib[1];
					String autore = lib[2];
					int numPagine = Integer.parseInt(lib[3]);
					//'1;2;3;4'
					List<String> capitoli = Arrays.asList(lib[4].split(";"));
					if(lib[0].equals("LibroScolastico")) {
						String gradoScolastico = lib[5];
						String ordine = lib[6];
						String cd = lib[7];
						libro = new LibroScolastico(titolo, autore, numPagine, capitoli, ordine, gradoScolastico, cd);
					} else {
						String titoloEnciclopedia = lib[5];
						String nomeCuratore = lib[6];
						libro = new Volume(titolo, autore, numPagine, capitoli, titoloEnciclopedia, nomeCuratore);
					}
					this.aggiungiLibro(libro);
				}
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(String.format("Libri size %d", this.libri.size()));
	}

	public List<Libro> getLibri() {
		return new ArrayList<>(libri);
	}
}
