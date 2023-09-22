package spedizione;

import java.util.ArrayList;

public class SpedizioneNazionale extends Spedizione {

    private static final int costoPerTappa = 3;

    public SpedizioneNazionale(DestNazionali origine, DestNazionali destinazione) {
        super(origine.name(), destinazione.name(), costoPerTappa);
	}

	@Override
    public boolean spedisci() {
        if(!isValidSpedizione()) return false;
        super.error = "";
        int orig = DestNazionali.valueOf(super.getOrigine()).ordinal();
        int dest = DestNazionali.valueOf(super.getDestinazione()).ordinal();
        ArrayList<String> tappe = new ArrayList<String>();
        if(orig < dest)
            for(int i = orig+1; i < dest; i++ ) 
                tappe.add(DestNazionali.values()[i].name());
        else
            for (int i = orig - 1; i > dest; i--)
                tappe.add(DestNazionali.values()[i].name());
        super.setTappe(tappe);
        return true;
    }


}
