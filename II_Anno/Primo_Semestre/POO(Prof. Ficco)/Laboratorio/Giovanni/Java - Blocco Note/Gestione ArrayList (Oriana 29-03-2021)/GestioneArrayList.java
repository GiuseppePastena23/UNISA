package gestione_arraylist;

import java.util.Scanner;
import java.util.ArrayList;

public class Gestione_arraylist {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int sc = 0, num, cont, pos, neg, min;
		ArrayList <Integer> numeri = new ArrayList <>();
		do {
			System.out.println("1. Inserisci");
			System.out.println("2. Elimina");
			System.out.println("3. Ricerca");
			System.out.println("4. Stampa");
			System.out.println("5. Conta numeri positivi e negativi");
			System.out.println("6. Ricerca min e spostamento a pos 0");
			System.out.println("0. Esci");
			sc = in.nextInt();
			switch(sc) {
				case 1:
					{
						System.out.println("Inserisci il numero: ");
						num = in.nextInt();
						numeri.add(num);
					} break;
				case 2:
					{
						cont = 0;
						System.out.println("Inserisci il numero da cancellare: ");
						num = in.nextInt();
						for (int i = 0; i < numeri.size(); i++) {
							if(num == numeri.get(i)) {
								numeri.remove(i);
								System.out.println("Numero cancellato!!");
								cont++;
							}
						}
						if(cont == 0)
							System.out.println("Il numero non è stato trovato :(");
					} break;
				case 3:
					{
						cont = 0;
						System.out.println("Inserisci il numero da cercare: ");
						num = in.nextInt();
						for(int i = 0; i < numeri.size(); i++) {
							if(num == numeri.get(i)) {
								System.out.println("Il numero è stato trovato al posto: " + i + " :))");
								cont++;
							}
						}
						if(cont == 0)
							System.out.println("Ricerca fallita");
					} break;
				case 4:
					{
						System.out.println(numeri);
					} break;
				case 5:
					{
						pos = 0;
						neg = 0;
						for (int i = 0; i < numeri.size(); i++) {
							if(numeri.get(i) >= 0)
								pos++;
							else
								neg++;
						}
						System.out.println("I numeri positivi sono: " + pos + " i negativi invece: " + neg);
					} break;
				case 6:
					{
						pos = 0;
						min = numeri.get(0);
						for (int i = 1; i < numeri.size(); i++) {
							if(numeri.get(i) < min) {
								min = numeri.get(i);
								pos = i;
							}
						}
						numeri.set(pos, numeri.get(0));
						numeri.set(0, min);
						System.out.println(numeri);
					} break;
			}
		} while(sc != 0);
	}
}