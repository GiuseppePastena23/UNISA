//

package Fantasy;

public abstract class Personaggio implements SuperPersonaggio {
	public static String ID;
	protected int posizione = 0;
	protected int energy = 100;
	/*
	public String type;
	public int energy;
	public Posizione start;
	public Posizione position;
	public int dir;
	public enum Direction {NORD, EST, SUD, OVEST};*/
	
	public Personaggio() {
		this(10);
	}
	public Personaggio(int i) {
		posizione = i;
	}
	public int posizione () {
		return this.posizione;
	}
	public abstract int colpisci (Personaggio p);
	
	/*
	public Personaggio (String ID, String type, int energy, Posizione start) {
		this.ID = ID;
		this.type = type;
		this.energy = energy;
		this.start = start;
		this.position = start;
		this.dir = 0;
		this.Direction = NORD;
	}
	
	public Posizione posizione () {
		return this.position;
	}
	public void colpisci (Personaggio pers) {
		
	}
	
	public void ruotaDX (int g) {
		this.dir += g;
		if(this.dir >= 360)
			this.dir -= 360;
		this.Direction = Direction.values()[(this.dir / 90)];
	}
	public void ruotaSX (int g) {
		this.dir -= g;
		if(this.dir <= 360)
			this.dir += 360;
		this.Direction = Direction.values()[(this.dir / 90)];
	}
	public Posizione avanti (int s) {
	
	}
	public Posizione indietro (int s) {
	
	}
	*/
}