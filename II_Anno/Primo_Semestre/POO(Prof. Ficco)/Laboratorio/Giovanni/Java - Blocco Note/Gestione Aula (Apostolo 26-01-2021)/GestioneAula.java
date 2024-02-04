package gestioneaula;

import java.util.Scanner;

public class Gestioneaula {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String nome;
		int i, età, sc, n;
		aula a = new aula();
		do {
			System.out.println("1) Inserimento");
			System.out.println("2) Stampa");
			System.out.println("3) Età media");
			System.out.println("4) Eliminazione");
			System.out.println("5) Alunni più giovani");
			System.out.println("6) Alunni più vecchi");
			System.out.println("7) Inserimento all'interno dell'elenco");
			System.out.println("8) Esci");
			sc = in.nextInt();
			switch(sc) {
				case 1:
					System.out.println("Inserisci il nome");
					nome = in.next();
					System.out.println("Inserisci l'età");
					età = in.nextInt();
					a.inseriscialunno(nome, età);
					break;
				case 2:
					System.out.println(a.toString());
					break;
				case 3:
					System.out.println(a.mediae());
					break;
				case 4:
					System.out.println("Inserisci l'alunno da eliminare");
					nome = in.next();
					a.elimina(nome);
					break;
				case 5:
					a.giov();
					break;
				case 6:
					a.vecc();
					break;
				case 7:
					if(a.getN()<20) {
						System.out.println("Inserisci il nome");
						nome = in.next();
						System.out.println("Inserisci l'età");
						età = in.nextInt();
						System.out.println("Inserisci dove vuoi inserire l'alunno");
						i = in.nextInt();
						n = a.getN();
						if(i < n) {
							a.insenel(nome, età, i);
						} else
							System.out.println("Inserire un numero minore a: " + a.getN());
					} else
						System.out.println("Troppi alunni");
					break;
				case 8:
					System.out.println("Uscita");
					break;
				default:
					System.out.println("SCELTA SCONOSCIUTA");
			}
		} while (sc != 8);
	}
}