//Programma che simula il lancio di una moneta

import java.util.Random;	//classe che genera uno stream di numeri pseudorandom
import java.util.Scanner;

class CoinToss {
	private enum Coin {Heads, Tails};	//tipo speciale che può assumere solo i valori indicati, che sono costanti
	Random randomNum = new Random();
	private int result;
	private int heads = 0;
	private int tails = 1;
	Coin coinFlip;
	public void flip() {
		result = randomNum.nextInt(2);	//pone un limite al numero generabile, tra 0, incluso, e valore, escluso: [0,2)
		if (result == 0) {
			coinFlip = Coin.Heads;
			System.out.println("Testa!");
		} else {
			coinFlip = Coin.Tails;
			System.out.println("Coda!");
		}
	}
}

public class TossGame {
	public static void main(String[] args) {
		CoinToss test = new CoinToss();
		Scanner input = new Scanner(System.in);
		int choice;
		System.out.println("Il programma simula il lancio di una moneta");
		do {
			System.out.print("Inserisci 1 per lanciare oppure 0 per uscire: ");
			choice = input.nextInt();
			if (choice == 1) {
				test.flip();
			} else if ((choice != 1) && (choice != 0)) {
				System.out.println("Numero non valido");
			}
		} while (choice != 0);
	}
}