package animali;

public class Uccello extends Animale{
	
	
	public Uccello(String nome) {
		super(nome, 2, 2, 4);
	}
	
	public String toString() {
		return "[Uccello]" + super.toString();
	}
}	
