package esame_2016_06_23;

public abstract class corsoUniversitario {
	protected int oreFrontali;
	protected String nomeCorso;
	protected String docente;
	
	public corsoUniversitario(int oreFrontali, String nomeCorso, String docente) {
		this.oreFrontali = oreFrontali;
		this.nomeCorso = nomeCorso;
		this.docente = docente;
	}
	
	public int getOreFrontali() {
		return oreFrontali;
	}
	
	public abstract int getOreCorso();
	
	public String getNomeCorso() {
		return nomeCorso;
	}
	
	public String getDocente() {
		return docente;
	}
	
	public int dammiNumeroCFU() {
		return (oreFrontali / 8);
	}
	
	public int calcolaCosto() {
		return (oreFrontali * 50);
	}
}