//Ficco fornisce belle tracce e le esegue male
//Il gioco si struttura come una lotta tra cavaliere, controllato dall'utente, ed orco, che invece sceglie a caso l'azione da eseguire ad ogni turno
//Finito lo scontro, l'utente sceglie se iniziarne un'altro oppure concludere.

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import Fantasy.*;

public class TestFantasy {
	public static void main (String[] args) {
		//Condizioni iniziali: regole, inizializzazioni, ottenimento degli input
		Scanner in = new Scanner(System.in);
		Orco orco = new Orco();
		
		boolean done = false;	//variabile di controllo per i rematch
		
		Istruzioni.benvenuto();
		Istruzioni.regole();
		
		System.out.println("Desideri dare un nome al tuo Cavaliere? (1: sì\t0: no)");
		int choice1 = in.nextInt();
		if(choice1 == 0) {
			Cavaliere cavaliere = new Cavaliere();
		}
		else {
			System.out.println("Che nome desideri dargli?");
			String str = in.nextLine();
			Cavaliere cavaliere = new Cavaliere(str);
		}
		
		//Inizia lo scontro: gestire l'alternanza delle azioni
		while(!done) {
			//stampa delle condizioni iniziali
			
			while(true) {	//termina quando uno dei due raggiunge 0hp
				//chiedi cosa fare
				
				//calcolo degli effetti
				
				//stampa della situazione attuale
				
				//verifica dello status
				break;
			}
			//Partita conclusa
			System.out.println("Desideri giocare di nuovo?");
			while(true) {
				System.out.println("1: sì\t0: no");
				int choice2 = in.nextInt();
				if(choice2 == 0) {
					done = true;
					break;
				}
				else if(choice2 == 1) {
					//Reset status, mantieni nome
					break;
				}
				else {
					System.out.println("Valore non valido");
				}
			}
			
		}
		//Uscita con stampa dei risultati (e/o su file in un futuro lontano)
	}
}