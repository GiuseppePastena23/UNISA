package animali;

public abstract class Animale {
	private String nome;
	private final int nZampe;
	private double peso;
	private int nRichieste;
	private int canEat;

	public Animale(String nome, int nZampe, double peso, int nRichieste) {
		this.nome = nome;
		this.nZampe = nZampe;
		this.peso = peso;
		this.nRichieste = nRichieste;
		this.canEat = nRichieste;
	}
	
	public int getZampe() {
		return nZampe;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public boolean vuoiMangiare() {
		if(canEat > 0) {
			canEat -= 1;
			return false;
		}
		else {
			this.mangia();
			return true;
		}
	}
	
	private void mangia() {
		this.canEat = nRichieste;
	}
	
	@Override
	public String toString() {
		return "Nome: " + this.nome + ", Peso: " + peso + " Kg" + ", Zampe: " + nZampe ;
	}
}
