package conto_corrente;

public class Conto {	
	private String nome;
	private String cognome;
	private int saldo;
	
	public void Conto(String nome, int nconto) {
		this.nome = nome;
		this.nconto = nconto;
		saldo = 0;
	}
	
	public int getNome() {
		return nome;
	}
	
	public int getNconto() {
		return nconto;
	}
	
	public int getSaldo() {
		return saldo;
	}
	
	public void versamento(int v) {
		saldo = saldo + v;
	}
	
	public int Prelievo(int v) {
		int ese;
		if(v>saldo)
			eseguito = 0;
		else {
			eseguito = 1;
			saldo = saldo-v;
		}
		return ese;
	}
}