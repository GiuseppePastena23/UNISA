package preappello2022;

import java.util.ArrayList;

public class ElencoAnimali {
	ArrayList <Animale> elenco;
	
	public ElencoAnimali() {
		elenco = new ArrayList <Animale> (); 
	}
	
	public void addAnimale(Animale a) {
		elenco.add(a);
	}
	
	public int getNumeroZampe() {
		int count = 0;
		for(Animale a: elenco) {
			count = count + a.getNumZampe();
		}
		return count;
	}
	
	public int getCounter(String tipoAnimale) throws BadAnimalException {
		int count = 0;
		boolean valid = false;
		for(Tipologie type : Tipologie.values()) {
			if((type.toString().compareToIgnoreCase(tipoAnimale)) == 0) {
				valid = true;
				break;
			}
		}
		if(valid) {
			for(Animale a: elenco) {
				if((a.getTipo().compareToIgnoreCase(tipoAnimale)) == 0) {
					count++;
				}
			}
			return count;
		}
		else {
			throw new BadAnimalException("Nessun animale di tipo: " + tipoAnimale + " presente");
		}
	}
	
	public int alimenta() {
		int count = 0;
		for(Animale a: elenco) {
			for(int i = 0; i < Tipologie.values().length; i++) {
				count++;
				if(a.vuoiMangiare()) {
					a.Mangia();
					break;
				}
			}
		}
		return count;
	}
}