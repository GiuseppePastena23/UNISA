//Crea una classe Libro con attributi per titolo, autore e ISBN
//E metodi per aggiungere e rimuovere libri da una collezione

import java.util.ArrayList;
//Classe che gestisce una sequenza di oggetti
//Cresce e si riduce a piacimento e presenta metodi per inserire, cancellare, modificare ed accedere

class Book {
	private String title;
	private String author;
	private String ISBN;
	private static ArrayList < Book > bookCollection = new ArrayList < Book > ();
	
	public Book (String title, String author, String ISBN) {
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
	}
	
	public String getTitle () {
		return title;
	}
	
	public String getAuthor () {
		return author;
	}
	
	public String getISBN () {
		return ISBN;
	}
	
	public void setTitle (String title) {
		this.title = title;
	}
	
	public void setAuthor (String author) {
		this.author = author;
	}
	
	public void setISBN (String ISBN) {
		this.ISBN = ISBN;
	}
	
	public static void addBook (Book book) {
		bookCollection.add (book);
	}
	
	public static void removeBook (Book book) {
		bookCollection.remove (book);
	}
	
	public static ArrayList < Book > getBookCollection () {
		return bookCollection;
	}
}

public class Ese4 {
	public static void main (String[] args) {
		Book b1 = new Book ("Java 101", "Pietro", "00110");
		Book b2 = new Book ("C 101", "Pietro", "00101");
		
		Book.addBook (b1);
		Book.addBook (b2);
		ArrayList < Book > bookCollection = Book.getBookCollection ();
		
		System.out.println("List of books:");
		for (Book book: bookCollection) {
			System.out.println(book.getTitle() + " by " + book.getAuthor() + ", ISBN: " + book.getISBN());
		}
		//for-each loop: visita dell'array basata sugli elementi e non sugli indici
		//for (data_type variable: array_name)
		
		Book.removeBook(b1);
    	System.out.println("\nAfter removing " + b1.getTitle() + ":");
   		System.out.println("List of books:");
   		for (Book book: bookCollection) {
			System.out.println(book.getTitle() + " by " + book.getAuthor() + ", ISBN: " + book.getISBN());
    	}
	}
}