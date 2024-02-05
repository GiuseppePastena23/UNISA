package WECPKG;

public class Motore extends Componente {
    private int cilindrata;
    private String tipo_motore;
    private int ncilindri;

    public Motore(double costo, String data_ins, int rif_vettura, String rif_Costruttore, int cilindrata, int ncilindri, String tipo_motore) {
        super(costo, data_ins, rif_Costruttore, rif_vettura);
        this.cilindrata = cilindrata;
        this.tipo_motore = tipo_motore;
        this.ncilindri = ncilindri;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    public String getTipo_motore() {
        return tipo_motore;
    }

    public int getNcilindri() {
        return ncilindri;
    }
}
