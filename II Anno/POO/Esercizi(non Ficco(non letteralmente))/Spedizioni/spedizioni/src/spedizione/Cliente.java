package spedizione;

import java.util.ArrayList;

public class Cliente {
	private String codiceFiscale;
	private Integer saldo;
	ArrayList<Spedizione> spedizioni;

	public Cliente(String codiceFiscale, int saldo) {
		spedizioni = new ArrayList<Spedizione>();
		this.setCodiceFiscale(codiceFiscale);
		this.setSaldo(saldo);
	}

	public boolean spedisci(Spedizione spedizione) {
		if (spedizione.dammiCosto() < saldo){
			this.spedizioni.add(spedizione);
			if(spedizione.spedisci()){
				this.paga(spedizione);
				return true;
			}
		}
		return false;
	}

	public void paga(Spedizione spd) {
		this.setSaldo(this.getSaldo() - spd.dammiCosto());
	}

	public Integer getSaldo() {
		return this.saldo;
	}
	private void setSaldo(int i) {
		this.saldo = i;
	}
	
	private Object getCodiceFiscale() {
		return this.codiceFiscale;
	}
	private void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	@Override
	public String toString() {
		return String.format("CF: %s, Saldo: %s\n", this.getCodiceFiscale(), this.getSaldo());
	}
    
}
