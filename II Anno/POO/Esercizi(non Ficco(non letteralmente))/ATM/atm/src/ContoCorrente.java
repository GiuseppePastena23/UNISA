public class ContoCorrente extends Conto {
	
	public ContoCorrente(double d) {
		super.saldo = d;
	}

	@Override
	public String toString() {
		return String.format("Conto Corrente - Saldo: %.2f", super.saldo);
	}

}
