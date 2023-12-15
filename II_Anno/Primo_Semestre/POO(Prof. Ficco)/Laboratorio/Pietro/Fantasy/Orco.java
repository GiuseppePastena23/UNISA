//Ficco fornisce belle tracce e le esegue male
package Fantasy;

import java.util.Random;

public class Orco extends Personaggio {
	private int staminaAttuale;
	
	//Bisogna aggiungere resistenze elementali: enum?
	
	//Costruttore
	public Orco () {
		super (TOTAL_HP, TOTAL_STAMINA);
		staminaAttuale = staminaTotale;
		//Scelta random di un elemento per resistenza e, di conseguenza, debolezza (non viene detto esplicitamente?)
	}
	//Metodo che sceglie a caso la prossima azione dell'orco -> diverse soglie in cui dare pesi diversi alle azioni
	public char scelta() {
		char ch = 'D';
		
		
		return ch;
	}
	
	public int colpisci(Personaggio pers) {
		return 5;
	}
	
	//Metodo che stampa lo stato attuale di un Orco
	public void stato() {
		System.out.println("L'orco avversario ha attualmente " + hp + "hp e " + staminaAttuale + "stamina");
	}
	//Costanti
	private static final int TOTAL_HP = 150;
	private static final int TOTAL_STAMINA = 75;
}