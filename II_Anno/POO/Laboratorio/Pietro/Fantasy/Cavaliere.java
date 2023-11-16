package Fantasy;

public class Cavaliere extends Personaggio {
	
	public int colpisci (Personaggio p) {
		p.energia--;
		return p.energia;
	}
	/*public static int identifier = 0;
	public Cavaliere (String ID, String type, int energy, Posizione start) {
		super (ID, type, energy, start);
		identifier++;
	}
	*/
}