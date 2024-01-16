package esame_2016_06_23;

import java.util.ArrayList;

public class corsoMagistrale extends corsoUniversitario {
	private ArrayList <corsoUniversitario> corsiObbligatori;
	
	public corsoTriennale(int oreFrontali, String nome, String docente) {
		super(oreFrontali, nome, docente);
		corsiObbligatori = new ArrayList <corsoUniversitario> ();
	}
	
	public ArrayList <corsoUniversitario> dammiListaIndirizzi() {
		return corsiObbligatori;
	}
	
	public int getOreCorso() {
		return (super.getOreFrontali);
	}
	
	@Override
	public int dammiNumeroCFU() {
		return (super.dammiNumeroCFU());
	}
	
	@Override
	public int calcolaCosto() {
		return (super.calcolaCosto());
	}
}