package WECPKG;

public class Cambio extends Componente {
private String marce;
    public Cambio(double costo, int rif_vettura, String rif_Costruttore, String data_ins, String marce) {
        super(costo,data_ins,rif_Costruttore,rif_vettura);
        this.marce = marce;
    }

    public String getMarce() {return marce;}
}
