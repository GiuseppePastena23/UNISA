import geometria.*;
import java.util.Scanner;

public class TestArea {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);	//input da standard input (tastiera)
		
		System.out.println("Desideri calcolare area e perimetro di quale figura?");
		System.out.println("1: Triangolo\t 2: Quadrato\t 3: Cerchio");
		int i = scan.nextInt();
		
		if (i == 1) {
			System.out.println("Inserisci base");
			double base = scan.nextDouble();	//next + datatype
			System.out.println("Inserisci altezza");
			double altezza = scan.nextDouble();
			System.out.println("Inserisci il secondo lato");
			double l2 = scan.nextDouble();
			System.out.println("Inserisci il terzo lato");
			double l3 = scan.nextDouble();
			Triangolo t1 = new Triangolo (base, altezza, l2, l3);
			System.out.println("L'area è: " + t1.calcoloArea());
			System.out.println("Il perimetro: " + t1.calcoloPerimetro());
		}
		else if (i == 2) {
			System.out.println("Inserisci lato");
			double lato = scan.nextDouble();
			Quadrato q1 = new Quadrato (lato);
			System.out.println("L'area è: " + q1.calcoloArea());
			System.out.println("Il perimetro è: " + q1.calcoloPerimetro());
		}
		else if (i == 3) {
			System.out.println("Inserisci raggio");
			double raggio = scan.nextDouble();
			Cerchio c1 = new Cerchio (raggio);
			System.out.println("L'area è: " + c1.calcoloArea());
			System.out.println("La circonferenza è: " + c1.calcoloCirconferenza());
		}
		
		scan.close();
	}
}