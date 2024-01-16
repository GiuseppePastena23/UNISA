package preappello2022;

public class Uccello extends Animale {
	private static final int numZampe = 2;
	private static final double peso = 0.1;
	private static final int richiesteNecessarie = 4;
	
	public Uccello(String nome) {
		super(numZampe, nome, peso, richiesteNecessarie);
	}
	
	protected String getTipo() {
		return "Uccello";
	}
	
	@Override
	public String toString() {
		return "L'uccello " + getNome() + " ha " + getNumZampe() + " zampe ed un peso di " + getPeso() + "kg";
	}
}