//Ficco fornisce belle tracce e le esegue male
package Fantasy;

import java.util.Random;

public class Orco extends Personaggio {
	//Bisogna aggiungere resistenze elementali: enum?
	
	//Costruttore
	public Orco () {
		super (150, 75);	//150hp, 75staminaTotale -> parametrizzare?
		//Scelta random di un elemento per resistenza e, di conseguenza, debolezza (non viene detto esplicitamente?)
	}
	//Metodo che sceglie a caso la prossima azione dell'orco -> diverse soglie in cui dare pesi diversi alle azioni
	public char scelta() {
		char ch = 'D';
		
		
		return ch;
	}
	
	//Metodo che stampa lo stato attuale di un Orco
	public void stato() {
		System.out.println("L'orco avversario ha attualmente " + hp + "hp e " + staminaAttuale + "stamina");
	}
}