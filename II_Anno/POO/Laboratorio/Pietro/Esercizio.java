//Classe Studente con metodi per leggere e scrivere attributi
//Classe Segreteria che permette la registrazione e la stampa di n studenti

import java.util.ArrayList;

class Studente {
	private String nome;
	private String cognome;
	private String matricola;
	//Costruttore
	public Studente (String nome, String cognome, String matricola) {
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
	}
	//Metodi get e set
	public String getNome() {
		return nome;
	}
	public void setNome (String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome (String cognome) {
		this.cognome = cognome;
	}
	public String getMatricola() {
		return matricola;
	}
}

class Segreteria {
	private String nome;
	private String numero;
	private static int numStudenti = 0;
	private ArrayList <Studente> listaStudenti;
	//Costruttore
	public Segreteria (String nome, String numero) {
		this.nome = nome;
		this.numero = numero;
		listaStudenti = new ArrayList <Studente> ();
	}
	//Aggiunta e rimozione studenti
	public void aggiungiStudente (Studente s) {
		listaStudenti.add (s);
		numStudenti++;
	}
	public void rimuoviStudente (Studente s) {
		listaStudenti.remove (s);
		numStudenti--;
	}
	//Stampa
	public void stampaInformazioni() {
		System.out.println("Numero degli studenti: " + numStudenti);
		for(Studente studente: listaStudenti) {
			System.out.println("Nome e cognome: " + studente.getNome() + " " + studente.getCognome());
			System.out.println("Numero matricola: " + studente.getMatricola());
		}
	}
}

public class Esercizio {
	public static void main (String[] args) {
		Segreteria seg = new Segreteria ("Dipartimento informatica", "333");
		Studente s1 = new Studente ("Aldo", "Baglio", "001");
		Studente s2 = new Studente ("Giovanni", "Storti", "002");
		Studente s3 = new Studente ("Giacomo", "Poretti", "003"); 
		seg.aggiungiStudente (s1);
		seg.aggiungiStudente (s2);
		seg.aggiungiStudente (s3);
		seg.stampaInformazioni();
	}
}
	