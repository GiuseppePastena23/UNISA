package figure_geometriche;

import java.util.Scanner;

public class Figure_geometriche {
	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
		double d, D, g;
		int sc;
		System.out.println("Inserisci la diagonale minore");
		d = in.nextDouble();
		System.out.println("Inserisci la diagonale maggiore");
		D = in.nextDouble();
		System.out.println("Inserisci l'angolo g");
		g = in.nextDouble();
		parallelogramma p = new parallelogramma(d, D, g);
		do {
			System.out.println("1) Perimetro");
			System.out.println("2) Area");
			System.out.println("3) Esci");
			sc = in.nextInt();
			switch(sc) {
				case 1:
					System.out.println("Il perimetro è: " + p.perimetro());
					break;
				case 2:
					System.out.println("L'area è: " + p.area());
					break;
				case 3:
					System.out.println("Uscita");
					break;
				default:
					System.out.println("SCELTA SCONOSCIUTA");
			}
		} while(sc != 3);
	}
}