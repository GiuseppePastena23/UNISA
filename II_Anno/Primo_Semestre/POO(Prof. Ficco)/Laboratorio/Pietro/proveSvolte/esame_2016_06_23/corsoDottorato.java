package esame_2016_06_23;

public class corsoDottorato extends corsoUniversitario {
	private String lingua;
	
	public corsoTriennale(int oreFrontali, String lingua, String nome, String docente) {
		super(oreFrontali, nome, docente);
		this.lingua = lingua;
	}
	
	public String getLingua() {
		return lingua;
	}
	
	public int getOreCorso() {
		return (super.getOreFrontali);
	}
	
	@Override
	public int dammiNumeroCFU() {
		return (super.dammiNumeroCFU() * 2);
	}
	
	@Override
	public int calcolaCosto() {
		if(this.lingua.compareToIgnoreCase("inglese") {
			return (super.calcolaCosto() * 2;
		}
		else {
			return (super.calcolaCosto());
		}
	}
}