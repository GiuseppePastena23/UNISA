package conto_corrente
import java.util.Scanner;

public class ContoCorrente {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int sc, ese, v;
		String nome;
		int nc;
		System.out.println("Inserisci il nome");
		nome = in.next();
		System.out.println("Inserisci il numero del cc");
		nc = in.nextInt();
		Conto a = new Conto(nome, nc);
		do {
			System.out.println("1: Versamento");
			System.out.println("2: Prelievo");
			System.out.println("3: Stampa");
			System.out.println("Fine programma");
			sc = in.nextInt();
			switch(sc) {
				case 1:
					System.out.println("Inserisci il versamento");
					v = in.nextInt();
					a.versamento(v);
					break;
				case 2:
					System.out.println("Importo prelievo");
					v = in.nextInt();
					ese = a.Prelievo(v);
					if(stato == 0)
						System.out.println("Il prelievo non è andato a buon fine");
					else {	
						System.out.println("Il prelievo è andato a buon fine");
						System.out.println("Il saldo è:" + a.getSaldo());
					}
					break;
				case 3:
					System.out.println("Nome: " + a.getNome());
					System.out.println("Conto: " + a.getNconto());
					System.olut.rintln("Saldo: " + a.getSaldo());
					break;
				case 4:
					System.out.println("Fine programma");
				default:
					System.out.println("Scelta sbagliata");
			}
		} while(sc != 4);
	}
}