package GestioneAutomobili;

public class Automobili {
	private String targa;
    private String modello;
    private String colore;
    private float kmeffettuati;

    public Automobili(String targa, String modello, String colore, float kmeffettuati) {
        this.targa = targa;
        this.modello = modello;
        this.colore = colore;
        this.kmeffettuati = kmeffettuati;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public float getKmeffettuati() {
        return kmeffettuati;
    }

    public void setKmeffettuati(float kmeffettuati) {
        this.kmeffettuati = kmeffettuati;
    }

    @Override
    public String toString() {
        return "Automobili{" + "targa=" + targa + ", modello=" + modello + ", colore=" + colore + ", kmeffettuati=" + kmeffettuati + '}';
    }
    
    public void viaggio(float kmviaggio) {
        this.kmeffettuati= this.kmeffettuati + kmviaggio;
    }
}