package animali;

public class Cane extends Animale{

	public Cane(String nome, double peso) {
		super(nome, 4, peso, (int)peso);
	}
	
	public String toString() {
		return "[Cane]" + super.toString();
	}
}
