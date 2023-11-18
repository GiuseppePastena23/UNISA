package Fantasy;

public class Orco extends Personaggio {
	public Orco (int i) {
		super (i);
	}
	public int colpisci (Personaggio p) {
		p.energia--;
		return p.energia;
	}
	/*public static int identifier = 0;
	public Orco (String ID, String type, int energy, Posizione start) {
		super (ID, type, energy, start);
		identifier++;
	}*/
}