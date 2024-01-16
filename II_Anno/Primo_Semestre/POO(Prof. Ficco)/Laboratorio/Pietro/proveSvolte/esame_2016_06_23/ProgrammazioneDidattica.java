package esame_2016_06_23;

import java.util.ArrayList;

public class ProgrammazioneDidattica {
	private String nome;
	private int numOreMinimo;
	private int numOreMassimo;
	private ArrayList <corsoUniversitario> listaCorsi;
	
	public ProgrammazioneDidattica(String nome, int minimo, int massimo) {
		this.nome = nome;
		this.numOreMinimo = minimo;
		this.numOreMassimo = massimo;
		listaCorsi = new ArrayList <corsoUniversitario> ();
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getNumOreMinimo() {
		return numOreMinimo;
	}
	
	public int getNumOreMassimo() {
		return numOreMassimo;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setNumOreMinimo(int minimo) {
		this.numOreMinimo = minimo;
	}
	
	public void setNumOreMinimo(int massimo) {
		this.numOreMassimo = massimo;
	}
	
	public void aggiungiCorso(corsoUniversitario c) throws OreSuperateException {
		int count = 0;
		for(corsoUniversitario corso : listaCorsi) {
			count = count + corso.getOreCorso();
		}
		count = count + c.getOreCorso();
		if(count > numOreMassimo) {
			throw new OreSuperateException("Con l'aggiunta del corso: " + c + " è stato superato il tetto massimo di ore");
		}
		else {
			listaCorsi.add(c);
		}
	}
	
	public void cancellaCorso(corsoUniversitario c) {
		listaCorsi.remove(c);
	}
	
	public boolean verifica() {
		int count = 0;
		for(corsoUniversitario corso : listaCorsi) {
			count = count + corso.getOreCorso();
		}
		if((count < numOreMinimo) || (count > numOreMassimo)) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public int calcolaCostoTotale() {
		int count = 0;
		for(corsoUniversitario corso : listaCorsi) {
			count = count + corso.calcolaCosto();
		}
		return count;
	}
	
	public int calcolaCFU() {
		int count = 0;
		for(corsoUniversitario corso : listaCorsi) {
			count = count + corso.dammiNumeroCFU();
		}
		return count;
	}
}