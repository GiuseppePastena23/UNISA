package spedizione;

import java.util.ArrayList;

public abstract class Spedizione {
    private String destinazione;
    private String origine;
    private ArrayList<String> tappe;
    private int costoPerTappa;
    protected String error;

    public Spedizione(String origine, String destinazione, int costoPerTappa) {
        tappe = new ArrayList<String>();
        this.error = "Non spedita"; 
        this.origine = origine;
        this.destinazione = destinazione;
        this.costoPerTappa = costoPerTappa;
    }

    public abstract boolean spedisci();

    public Integer dammiCosto() {
        return this.getNumTappe() * this.getCostoPerTappa();
    }

    public int getCostoPerTappa() {
        return this.costoPerTappa;
    }
    public void setCostoPerTappa(int value) {
        this.costoPerTappa = value;
    }

    public ArrayList<String> getTappe() {
        return tappe;
    }
    public void setTappe(ArrayList<String> tappe) {
        this.tappe = tappe;
    }
    public int getNumTappe() {
        return (this.tappe.size() + 1); //1 sarebbe la destinazione;
    }
    
	protected String getDestinazione() {
        return this.destinazione;
    }
    protected String getOrigine() {
        return this.origine;
    }

    @Override
    public String toString() {
        if(!this.error.equals(""))
            return String.format("Errore spedizione da %s a %s\n%s\n", this.getOrigine(), this.getDestinazione(), this.error);

        String output = String.format("Costo %s: %d - Dettagli:\n", this.getClass().getSimpleName(),this.dammiCosto());        
        output += String.format("\tPartenza da: %s\n", this.getOrigine());
        for (int i = 0; i < tappe.size(); i++) {
            output += String.format("\tTappa %d: %s\n", i + 1, tappe.get(i));
        }
        output += String.format("\tArrivo a: %s\n", this.getDestinazione());
        return output;
    }

	public boolean isValidSpedizione() {
        if(this.getOrigine().equals(this.getDestinazione())){
            this.error = "Origine e destinazione sono uguali, spedizione annullata.";
            this.costoPerTappa = 0;
            return false;
        }
		return true;
	}
}
