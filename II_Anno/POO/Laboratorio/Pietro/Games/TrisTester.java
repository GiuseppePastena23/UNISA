//Scacchiera 3x3 per il gioco Tris

import java.util.Scanner;

class Tris {
	private String[][] board;
	private static final int ROWS = 3;
	private static final int COLUMNS = 3;
	//Costruttore di una scacchiera vuota
	public Tris() {
		board = new String[ROWS][COLUMNS];
		for(int i = 0; i < ROWS; i++) {
			for(int j = 0; j < COLUMNS; j++) {
				board[i][j] = " ";
			}
		}
	}
	//Metodo set per inserimento nella scacchiera
	public boolean set (int i, int j, String player) {
		if(board[i][j].equals(" ")) {	//casella libera
			board[i][j] = player;
			return true;
		}
		else
			return false;	//la casella è occupata
	}
	//Metodo per creare una rappresentazione della scacchiera come stringa
	public String toString() {
		String r = "";
		for(int i = 0; i < ROWS; i++) {
			r = r + "|";
			for(int j = 0; j < COLUMNS; j++) {
				r = r + board[i][j];
			}
			r = r + "|\n";
		}
		return r;
	}
}

public class TrisTester {
	public static void main (String[] args) {
		String player = "x";
		Tris game = new Tris();
		Scanner in = new Scanner(System.in);
		boolean done = false;
		System.out.println("La griglia è formata da 3 righe e 3 colonne, contata dall'alto in basso e da sinistra verso destra");
		System.out.println("Puoi inserire ovunque, a patto che la casella sia libera");
		System.out.println("Il gioco termina quando 3 segni uguali sono posti di fila, orizzontalmente, verticalmente o in obliquo");
		while(!done) {
			System.out.println(game.toString());	//stampa l'attuale partita
			System.out.println("Turno del giocatore: " + player);
			System.out.println("Inserisci la riga per giocare oppure 0 per uscire:");
			int riga = in.nextInt() - 1;
			if(riga == -1) {
				done = true;
			}
			else if((riga < 0) || (riga > 2)) {
				System.out.println("Valore non valido");
			}
			else {
				System.out.println("Inserisci la colonna:");
				int colonna = in.nextInt() - 1;
				if(game.set(riga, colonna, player)) {
					if(player.equals("x")) {
						player = "o";
					}
					else {
						player = "x";
					}
				}
				else {
					System.out.println("La casella è già occupata");
				}
			}
		}
	}
}