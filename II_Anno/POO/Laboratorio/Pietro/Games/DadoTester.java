//Programma per la creazione di un dado con n facce

import java.util.Random;
import java.util.Scanner;

class Dado {
	private int numFacce;
	Random randomNum = new Random();
	private int result;
	public Dado (int numFacce) {
		this.numFacce = numFacce;
	}
	public int Tiro() {
		result = (randomNum.nextInt(numFacce)) + 1;
		System.out.println("Risultato del lancio: " + result);
		return result;
	}
}

class DadoTester {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Quante facce ha il dado?");
		int num1 = in.nextInt();
		System.out.println("Quante facce ha il dado?");
		int num2 = in.nextInt();
		Dado test1 = new Dado(num1);
		Dado test2 = new Dado(num2);
		test1.Tiro();
		test1.Tiro();
		test1.Tiro();
		test2.Tiro();
		test2.Tiro();
		test2.Tiro();
	}
}