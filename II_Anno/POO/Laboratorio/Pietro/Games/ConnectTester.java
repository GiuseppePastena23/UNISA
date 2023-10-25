//Programma per giocare a forza 4

import java.util.Scanner;

class Connect {
	private static final int ROWS = 6;
	private static final int COLUMNS = 7;
	private String[][] board;
	//Costruttore di una scacchiera vuota
	public Connect() {
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
			if(i == 5) {	//siamo nella prima riga, sempre possibile inserire
				board[i][j] = player;
				return true;
			}
			else if (!(board[(i + 1)][j].equals(" "))) {	//controllo se la casella sotto è occupata
				board[i][j] = player;
				return true;
			}
			else
				return false;	//non è possibile inserire in quella posizione la pedina
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

public class ConnectTester {
	public static void main (String[] args) {
		Connect game = new Connect();
		Scanner in = new Scanner(System.in);
		String player = "R";
		boolean done = false;
		while(!done) {
			System.out.println(game.toString());	//stampa l'attuale partita
			System.out.println("Turno del giocatore: " + player);
			System.out.println("Inserisci la riga per giocare oppure 0 per uscire:");
			int riga = in.nextInt() - 1;
			if(riga == -1) {
				done = true;
			}
			else if((riga < 0) || (riga > 5)) {
				System.out.println("Valore non valido");
			}
			else {
				System.out.println("Inserisci la colonna:");
				int colonna = in.nextInt() - 1;
				if(game.set(riga, colonna, player)) {
					if(player.equals("R")) {
						player = "G";
					}
					else {
						player = "R";
					}
				}
				else {
					System.out.println("Casella non valida");
				}
			}
		}
	}
}