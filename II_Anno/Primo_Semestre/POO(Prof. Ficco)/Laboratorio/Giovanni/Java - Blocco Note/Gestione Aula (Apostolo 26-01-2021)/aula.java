package gestioneaula;

public class aula {
	private String[] nome = new String[20];
	private int[] età = new int[20];
	private int n;
	
	public aula() {
		this.n = 0;
		int i;
		for(i = 0; i < 20; i++) {
			nome[i] = " ";
			età[i] = 0;
		}
	}
	public void inseriscialunno(String nom, int età) {
		this.nome[this.n] = nom;
		this.età[this.n] = età;
		this.n++;
	}
	@Override
	public String toString() {
		String stampa = "Alunni";
		int i;
		for(i = 0; i < n; i++) {
			stampa = stampa + "\n nome: " + this.nome[i] + " età: " + this.età[i];
		}
		return stampa;
	}
	public void elimina(String al) {
		int nu = 21;
		for(int i = 0; i < n; i++) {
			if(nome[i].equals(al))
				nu = i;
		}
		if(nu == 21)
			System.out.println("Alunno non trovato");
		else {
			for(int i = nu; i < n-1; i++) {
				nome[i] = nome[i+1];
				età[i] = età[i+1];
			}
		}
		nome[n] = " ";
		età[n] = 0;
		n--;
		System.out.println("Alunno ELIMINATO");
	}
	public float mediae() {
		int med = 0;
		int i;
		for(i = 0; i < n; i++) {
			med = med + età[i];
		}
		return med/n;
	}
	public void giov() {
		int min = età[0];
		System.out.println("Gli/L' alunni/o più giovani/e sono/è: ");
		for(int i = 1; i < n; i++) {
			if(min > età[i]) {
				min = età[i];
			}
		}
		for(int i = 0; i < n; i++) {
			if(min == età[i])
				System.out.println(nome[i]);
		}
	}
	public int getN() {
		return n;
	}
	public void vecc() {
		int max = età[0];
		System.out.println("Gli/L' alunni/o più vecchi/io sono/è: ");
		for(int i = 1; i < n; i++) {
			if(max < età[i]) {
				max = età[i];
			}
		}
		for(int i = 0; i < n; i++) {
			if(max == età[i])
				System.out.println(nome[i]);
		}
	}
	public void insenel(String nom, int et, int p) {
		for(int i = this.n; i + 1 > p; i--) {
			this.nome[i+1] = this.nome[i];
			this.età[i+1] = this.età[i];
		}
		this.nome[p] = nom;
		this.età[p] = et;
		n++;
	}
}