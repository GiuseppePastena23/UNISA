public abstract class Conto {
    protected double saldo;

    public double getSaldo() {
        return this.saldo;
    }

	public void versa(double i) {
        this.saldo += i;
	}

	public boolean prelievo(double i) {
		if (this.saldo >= i) {
            this.saldo -= i;
            return true;
        } else {
            return false;
        }
	}
}
