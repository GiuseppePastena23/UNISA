import java.util.Scanner;	//maiuscola perché è una classe

class Triangolo {
	double base;
	double altezza;
	
	public Triangolo (double base, double altezza) {
		this.base = base;
		this.altezza = altezza;
	}
	
	double calcolo () {
		return ((base * altezza) / 2);
	}
}

class Quadrato {
	double lato;
	
	public Quadrato (double lato) {
		this.lato = lato;
	}
	
	double calcolo () {
		return (lato * lato);
	}
}

public class Area {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);	//input da standard input (tastiera)
		
		System.out.println("Desideri calcolare l'area di un triangolo o un quadrato?");
		System.out.println("1: Triangolo\t 2: Quadrato");
		int i = scan.nextInt();
		
		if (i == 1) {
			System.out.println("Inserisci base");
			double base = scan.nextDouble();	//next + datatype
			System.out.println("Inserisci altezza");
			double altezza = scan.nextDouble();
			Triangolo t1 = new Triangolo (base, altezza);
			System.out.println("L'area è: " + t1.calcolo());
		}
		
		else if (i == 2) {
			System.out.println("Inserisci lato");
			double lato = scan.nextDouble();
			Quadrato q1 = new Quadrato (lato);
			System.out.println("L'area è: " + q1.calcolo());
		}
		
		scan.close();
	}
}