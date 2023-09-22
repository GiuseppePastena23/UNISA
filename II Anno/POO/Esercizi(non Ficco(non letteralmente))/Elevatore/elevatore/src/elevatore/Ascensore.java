package elevatore;

public class Ascensore extends Elevatore {
    private boolean occupato;
    private double pesoMax;
    private int numUtilizzi;

    public Ascensore(Integer codice, String marca, double prezzoBase, double pesoMax) {
        super(codice, marca, prezzoBase);
        this.occupato = false;
        this.pesoMax = pesoMax;
        this.numUtilizzi = 0;
    }

    //Getter & Setter
    public int dammiNumeroUtilizzi() {
        return this.numUtilizzi;
    }
    public void setNumUtilizzi(int numUtilizzi) {
        this.numUtilizzi = numUtilizzi;
    }

    public boolean isOccupato() {
        return occupato;
    }
    public void setOccupato(boolean occupato) {
        this.occupato = occupato;
    }

    public double getPesoMax() {
        return pesoMax;
    }
    public void setPesoMax(double pesoMax) {
        this.pesoMax = pesoMax;
    }
    
    @Override
    public double getCosto() {
        return super.getPrezzoBase() * this.getPesoMax() / 100;
    }

    //Methods
    @Override
    public void accendi() {
        super.accendi();
        this.occupato = false;
        this.setNumUtilizzi(0);
    }

    @Override
    public void spegni() {
        super.spegni();
        this.occupato = false;
    }

    public boolean prenota() {
        if(!isOccupato()) {
            this.setOccupato(true);
            return true;
        }
        return false;
    }

    public boolean utilizza(double peso) {
        if(peso < this.getPesoMax()){
            this.setOccupato(false);
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return String.format("%s Occupato: %s, PesoMax: %.2f, Num Utilizzi: %d\n", 
            super.toString(),this.isOccupato() ? "SI":"NO",this.getPesoMax(),this.dammiNumeroUtilizzi() );
    }
    
}
