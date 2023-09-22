package spedizione;

import java.util.ArrayList;
import java.util.Collections;

public class SpedizioneInternazionale extends Spedizione {
	private static final int costoPerTappa = 20;

	public SpedizioneInternazionale(DestInternazionali origine, DestInternazionali destinazione) {
		super(origine.name(), destinazione.name(),costoPerTappa);
	}

	@Override
	public boolean spedisci() {
		if (!isValidSpedizione()) return false;
		super.error = "";
		ArrayList<String> cittaDestinazioni = new ArrayList<String>();
		ArrayList<String> tappe = new ArrayList<String>();
		for (DestInternazionali citta : DestInternazionali.values()) {
			if( !citta.name().equals(super.getOrigine()) ){
				cittaDestinazioni.add(citta.name());
			}
		}
		Collections.shuffle(cittaDestinazioni);
		for (String citta : cittaDestinazioni) {
			if(citta.equals(super.getDestinazione()))
				break;
			tappe.add(citta);
		}
		super.setTappe(tappe);
		return true;
	}
    
}