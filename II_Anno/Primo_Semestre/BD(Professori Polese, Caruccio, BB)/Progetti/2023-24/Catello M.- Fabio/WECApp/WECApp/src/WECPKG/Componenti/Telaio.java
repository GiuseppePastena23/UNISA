package WECPKG.Componenti;

import WECPKG.Componenti.Componente;

public class Telaio extends Componente {
    private String materiale;
    private double peso = 0;
    public Telaio(double costo, String data_ins, String rif_Costruttore, int rif_vettura, double peso, String materiale){
        super(costo, data_ins, rif_Costruttore, rif_vettura);
        this.peso = peso;
        this.materiale = materiale;
    }

    public double getPeso() {
        return peso;
    }
    public String getMateriale() {
        return materiale;
    }
}
