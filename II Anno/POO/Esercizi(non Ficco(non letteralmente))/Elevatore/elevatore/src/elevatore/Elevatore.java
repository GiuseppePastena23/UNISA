package elevatore;

public abstract class Elevatore {
    private Integer codice;
    private String marca;
    private double prezzoBase;
    private boolean acceso;
    
    //Constructors
    public Elevatore(Integer codice, String marca, double prezzoBase) {
        this.codice = codice;
        this.marca = marca;
        this.prezzoBase = prezzoBase;
        this.acceso = false;
    }

    //Getter & Setter
    public boolean isAcceso() {
        return acceso;
    }

    public void setAcceso(boolean acceso) {
        this.acceso = acceso;
    }

    public double getPrezzoBase() {
        return prezzoBase;
    }

    public void setPrezzoBase(double prezzoBase) {
        this.prezzoBase = prezzoBase;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getCodice() {
        return codice;
    }

    public void setCodice(Integer codice) {
        this.codice = codice;
    }
    
    //Methods
    public void accendi() {
        if (isAcceso())
            throw new RuntimeException();
        this.setAcceso(true);
    }

    public void spegni() {
        if (!isAcceso())
            throw new RuntimeException();
        this.setAcceso(false);
    }

    public abstract double getCosto();

    @Override
    public String toString() {
        return String.format("Tipo: %s, Codice: %d, Marca: %s, Prezzo Base: %.2f, Acceso: %s\n", 
                    this.getClass().getSimpleName(), this.getCodice(), this.getMarca(), this.getPrezzoBase(), this.isAcceso()? "SI" : "NO");
    }
}


