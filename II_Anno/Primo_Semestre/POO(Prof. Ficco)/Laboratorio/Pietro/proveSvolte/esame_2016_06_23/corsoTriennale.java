package esame_2016_06_23;

public class corsoTriennale extends corsoUniversitario {
	private int oreLaboratorio;
	
	public corsoTriennale(int oreFrontali, int oreLaboratorio, String nome, String docente) {
		super(oreFrontali, nome, docente);
		this.oreLaboratorio = oreLaboratorio;
	}
	
	public int getOreLaboratorio() {
		return oreLaboratorio;
	}
	
	public int getOreCorso() {
		return (super.getOreFrontali + oreLaboratorio);
	}
	
	@Override
	public int dammiNumeroCFU() {
		return ((super.dammiNumeroCFU()) + (oreLaboratorio / 10));
	}
	
	@Override
	public int calcolaCosto() {
		return ((super.calcolaCosto()) + (oreLaboratorio * 35));
	}
}