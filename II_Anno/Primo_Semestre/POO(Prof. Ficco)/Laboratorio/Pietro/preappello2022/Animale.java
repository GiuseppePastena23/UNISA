package preappello2022;

public abstract class Animale {
	protected int numZampe;
	protected String nome;
	protected double peso;
	protected int richiesteAttuali;
	protected int richiesteNecessarie;
	
	public Animale(int numZampe, String nome, double peso, int richiesteNecessarie) {
		this.numZampe = numZampe;
		this.nome = nome;
		this.peso = peso;
		this.richiesteNecessarie = richiesteNecessarie;
		this.richiesteAttuali = 0;
	}

	public int getNumZampe() {
		return numZampe;
	}

	public String getNome() {
		return nome;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public boolean vuoiMangiare() {
		if(richiesteNecessarie == richiesteAttuali) {
			return true;
		}
		else {
			richiesteAttuali++;
			return false;
		}
	}
	
	public void Mangia() {
		if(this.vuoiMangiare()) {
			richiesteAttuali = 0;
		}
	}
	
	protected abstract String getTipo();
}