package core;

//4 Punti
public class Camion extends Macchina 
{
	double lunRim;
	double peso;
	int limVel;
	double pesoMax;
	
	public Camion(String tipo, int numRuote, int cilindrata, String colore) 
	{
		super(tipo, numRuote, cilindrata, colore);
		this.lunRim = 0.0;
		this.peso = 0.0;
		this.limVel = 80;
		this.pesoMax = 0;
	}
	
	public Camion(double lunRim, double peso, double pesoMax, String targa, int numMarce, String tipo, int numRuote, int cilindrata, String colore) 
	{
		super(targa, numMarce, tipo, numRuote, cilindrata, colore);
		this.lunRim = lunRim;
		this.peso = peso;
		this.limVel = 80;
		this.pesoMax = pesoMax;
	}

	public double getLunRim() {
		return lunRim;
	}

	public void setLunRim(double lunRim) {
		this.lunRim = lunRim;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getLimVel() {
		return limVel;
	}

	public void setLimVel(int limVel) {
		this.limVel = limVel;
	}

	public double getPesoMax() {
		return pesoMax;
	}

	public void setPesoMax(double pesoMax) {
		this.pesoMax = pesoMax;
	}

	@Override
	public String toString() {
		return "Camion [lunRim=" + lunRim + ", peso=" + peso + ", limVel=" + limVel + ", pesoMax=" + pesoMax + "]";
	}
	
	public void caricaRimorchio()
	{
		if(this.pesoMax >= this.peso + 1000) this.peso = this.peso + 1000;
	}
	
	public void scaricaRimorchio()
	{
		this.peso = 0;
	}
}
