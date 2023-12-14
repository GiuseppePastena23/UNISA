//Ficco fornisce belle tracce e le esegue male
//Classe astratta che implementa l'interfaccia
//Serve a definire i tratti generali che ogni personaggio deve possedere

package Fantasy;

import java.util.Random;

public abstract class Personaggio implements SuperPersonaggio {
	protected int hp;
	protected int staminaTotale;
	public boolean dimezzaDanni;	//dimezza il danno subito con il prossimo colpo
	public boolean potenziamento;	//potenzia l'attacco successivo
	//Costruttore
	public Personaggio(int hp, int staminaTotale) {
		this.hp = hp;
		this.staminaTotale = staminaTotale;
		dimezzaDanni = false;
		potenziamento = false;
	}
	//Non implementabile a questo livello
	public abstract int colpisci(Personaggio p);
	//Metodo che viene richiamato dai figli per eseguire i calcoli
	protected int calcoloDanni(int dannoBase, int range) {	//range indica di quanto spostarsi in una direzione
		int dannoMin = dannoBase - range;
		int intervallo = (2 * range) + 1;
		Random gen = new Random();
		int num = gen.nextInt(intervallo);
		return (num + dannoMin);
	}
	//Metodi get/set
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public boolean getDimezzaDanni() {
		return dimezzaDanni;
	}
	public void setDimezzaDanni(boolean b) {
		this.dimezzaDanni = b;
	}
	public boolean getPotenziamento() {
		return potenziamento;
	}
	public void setPotenziamento(boolean b) {
		this.potenziamento = b;
	}
}