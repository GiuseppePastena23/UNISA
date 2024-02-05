package WECPKG;

public abstract class Componente {
    private double costo;
    private String data_ins;
    private String rif_Costruttore;
    private int rif_vettura;


    public Componente(double costo, String data_ins, String rif_Costruttore, int rif_vettura) {
        this.costo = costo;
        this.data_ins = data_ins;
        this.rif_Costruttore = rif_Costruttore;
        this.rif_vettura = rif_vettura;

    }

    public double getCosto() {
        return costo;
    }

    public String getData_ins() {
        return data_ins;
    }

    public String getRif_Costruttore() {
        return rif_Costruttore;
    }

    public int getRif_vettura() {
        return rif_vettura;
    }
}
