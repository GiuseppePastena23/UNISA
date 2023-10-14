public class Elettronico extends Prodotto {
    private int garanziaBase;
    private double prezzoAnnualeGaranzia;

    public Elettronico(Long codice, String descrizione, String marca, double prezzo, int quantita, int garanziaBase,
            double prezzoAnnualeGaranzia) {
        super(codice, descrizione, marca, prezzo, quantita);
        this.setGaranziaBase(garanziaBase);
        this.prezzoAnnualeGaranzia = prezzoAnnualeGaranzia;
    }

    public int getGaranziaBase() {
        return garanziaBase;
    }
    public void setGaranziaBase(int garanziaBase) {
        this.garanziaBase = garanziaBase;
    }

    public double calcolaCostoGaranzia(int a) {
        return this.prezzoAnnualeGaranzia * a;
    }

    public boolean acquista(int q) {
        if( q > super.getQuantita() )
            return false;
        super.setQuantita( super.getQuantita() - q );
        return true;
    }
}
