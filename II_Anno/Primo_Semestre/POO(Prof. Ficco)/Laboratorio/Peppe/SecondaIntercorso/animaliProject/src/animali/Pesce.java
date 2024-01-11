package animali;

public class Pesce extends Animale{
	public Pesce(String nome) {
		super(nome, 0, 0.1, 3);
	}
	
	public String toString() {
		return "[Pesce]" + super.toString();
		
	}
}

