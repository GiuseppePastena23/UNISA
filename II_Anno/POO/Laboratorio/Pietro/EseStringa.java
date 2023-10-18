/*Il programma, data una stringa s inserita da linea di comando,
controlla se il primo carattere di s è ripetuto nella stringa,
stampando la posizione in cui è ripetuto (oppure -1)*/

import java.util.Scanner;

public class EseStringa {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int counter = 0;
		System.out.println("Inserire una stringa");
		String s = in.nextLine();		//prende anche gli spazi
		int l = s.length();
		char primo = s.charAt(0);
		for (int i = 1; i < l; i++) {
			if(s.charAt(i) == primo) {
				System.out.println("Trovato lo stesso carattere in posizione: " + i);
				counter++;
			}
		}
		if(counter == 0)
			System.out.println("Il primo carattere non viene ripetuto");
	}
}