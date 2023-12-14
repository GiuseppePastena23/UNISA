//Ficco fornisce belle tracce e le esegue male
package Fantasy;

public class Cavaliere extends Personaggio {
	private String id;	//nome assegnato al cavaliere
	private int staminaAttuale;	//forse da spostare in Personaggio
	//Costruttori
	public Cavaliere() {
		super(100, 100);	//100hp, 100staminaTotale -> parametrizzare?
		id = "senza nome";
		staminaAttuale = staminaTotale;
	}
	public Cavaliere (String id) {
		super(100, 100);	//100hp, 100staminaTotale -> parametrizzare?
		this.id = id;
		staminaAttuale = staminaTotale;
	}
	//Azioni del cavaliere
	//Funzioni singole per le tipologie di colpo da chiamare in colpisci: mostrano danni possibili e chiedono se essere eseguiti o meno
	
	
	public int colpisci (Personaggio p) {
		//Scelta del tipo di attacco: fisico - elementale
		
		//Calcolo del danno a cui si aggiungono i modificatori
		
		//Uscita: riduzione hp del nemico con messaggio che indica l'output
	}
	public void difendi() {
		dimezzaDanni = true;	//da controllare nel calcolo dei danni
	}
	public void potenzia() {
		potenziamento = true;	//da controllare nel calcolo dei danni
	}
	public void riposa() {
		staminaAttuale = staminaAttuale + (staminaTotale / 2);
		if(staminaAttuale > staminaTotale) {
			staminaAttuale = staminaTotale;	//previene un superamento della soglia massima
		}
	}
	//Metodi get/set
	public int getStamina() {
		return staminaAttuale;
	}
	//Metodo per la stampa dello status di un Cavaliere
	public void stato() {
		System.out.println("Il cavaliere: " + id + " ha attualmente " + hp + "hp e " + staminaAttuale + "stamina");
	}
}