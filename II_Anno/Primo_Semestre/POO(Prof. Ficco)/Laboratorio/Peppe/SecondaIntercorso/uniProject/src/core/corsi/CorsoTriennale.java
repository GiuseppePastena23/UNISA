package core.corsi;

import javax.print.DocFlavor.READER;

public class CorsoTriennale extends Corso{
    private String nome;
    private String docente;
    private int hLaboratorio;


    public CorsoTriennale(String nome, String docente, int hFrontali, int hLaboratorio){
        super(nome, docente, hFrontali);
        this.hLaboratorio = hLaboratorio;
    }

    public int dammiNumeroCFU(){
        return (this.hLaboratorio / 8) + (this.hFrontali / 10);
    }
    
    @Override
    public int calcolaCosto(){
        return super.calcolaCosto() + (hLaboratorio * 35);
    }
    
    @Override
    public int getOre(){
        return super.getOre() + hLaboratorio;
    }
}