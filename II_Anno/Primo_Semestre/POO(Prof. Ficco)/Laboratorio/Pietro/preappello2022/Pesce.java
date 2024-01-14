package preappello2022;

public class Pesce extends Animale {
	private static final int numZampe = 0;
	private static final double peso = 2;
	private static final int richiesteNecessarie = 3;
	
	public Pesce(String nome) {
		super(numZampe, nome, peso, richiesteNecessarie);
	}
	
	protected String getTipo() {
		return "Pesce";
	}
	
	@Override
	public String toString() {
		return "Il pesce " + getNome() + " non ha zampe ed ha un peso di " + getPeso() + "kg";
	}
}