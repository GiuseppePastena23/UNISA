package animali;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ElencoAnimali {
	List<Animale> animali;
	
	public ElencoAnimali() {
		animali = new ArrayList<>();
	}
	
	public void addAnimale(Animale a) {
		animali.add(a);
	}
	
	public int totaleZampe() {
		int totale = 0;
		for(Animale a : animali) {
			totale += a.getZampe();
		}
		return totale;
	}
	
	public int getCounter(String tipo) throws BadAnimalException{
		
		int result = 0;
		boolean exists = false;
		
		for (Tipi type : Tipi.values()) {
		    if(type.toString().equalsIgnoreCase(tipo)){
		    	exists = true;
		    	break;
		    }
		}
	
		if(exists) {
			for(Animale a : animali) {
				if((a.getClass().getSimpleName()).equalsIgnoreCase(tipo)) {
					result += 1;
				}
			}
			return result;
		} 
		else {
			throw new BadAnimalException("Nessun Animale di tipo " + tipo + " Trovato");
		}
	}
	
	public int alimenta() {
		int result = 0;
		for(Animale a : animali) {
			for(int i = 0; i < 3; i++) {
				while(!a.vuoiMangiare()) {
					result += 1;
				}
				result += 1;
			}
		}
		return result;
	}
}


