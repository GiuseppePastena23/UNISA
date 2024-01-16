package preappello2022;

public class Cane extends Animale {
	private static final int numZampe = 4;
	private static final int richiesteNecessarie = 10;
	
	public Cane(String nome, double peso) {
		super(numZampe, nome, peso, richiesteNecessarie);
	}
	
	protected String getTipo() {
		return "Cane";
	}

	@Override
	public String toString() {
		return "Il cane " + getNome() + " ha " + getNumZampe() + " zampe ed un peso di " + getPeso() + "kg";
	}
}