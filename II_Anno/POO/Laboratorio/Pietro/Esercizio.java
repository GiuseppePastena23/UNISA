//Classe Studente con metodi per leggere e scrivere attributi
//Classe Segreteria che permette la registrazione e la stampa di n studenti

import java.util.ArrayList;

class Studente {
	private String name;
	private String mNumber;
	//Costruttore
	public Studente (String name, String mNumber) {
		this.name = name;
		this.mNumber = mNumber;
	}
	//Metodi get e set
	public String getName() {
		return name;
	}
	public void setName (String name) {
		this.name = name;
	}
	public String getMNumber() {
		return mNumber;
	}
	public void setMNumber (String mNumber) {
		this.mNumber = mNumber;
	}
}

class Segreteria {
	private String name;
	private String number;
	private ArrayList <Studente> listaStudenti;
	//Costruttore
	public Segreteria (String name, String number) {
		this.name = name;
		this.number = number;
		listaStudenti = new ArrayList <Studente> ();
	}
	//Aggiunta e rimozione studenti
	public void aggiungiStudente (Studente s) {
		listaStudenti.add (s);
	}
	public void rimuoviStudente (Studente s) {
		listaStudenti.remove (s);
	}
	//Stampa
	public void stampaInformazioni() {
	
		for(Studente studente: listaStudenti) {
			System.out.println("Nome e cognome: " + studente.getName());
			System.out.println("Numero matricola: " + studente.getMNumber());
		}
	}
}

public class Esercizio {
	public static void main (String[] args) {
		Segreteria seg = new Segreteria ("Dipartimento informatica", "333");
		Studente s1 = new Studente ("Aldo Baglio", "001");
		Studente s2 = new Studente ("Giovanni Storti", "002");
		Studente s3 = new Studente ("Giacomo Poretti", "003"); 
		seg.aggiungiStudente (s1);
		seg.aggiungiStudente (s2);
		seg.aggiungiStudente (s3);
		seg.stampaInformazioni();
	}
}
	