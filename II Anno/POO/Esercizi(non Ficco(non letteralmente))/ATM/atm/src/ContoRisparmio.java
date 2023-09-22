public class ContoRisparmio extends Conto {

	public ContoRisparmio(double d) {
		super.saldo = d;
	}

	@Override
	public String toString() {
		return String.format("Conto Risparmio - Saldo: %.2f", super.saldo);
	}

}
