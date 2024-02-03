package main.medicinali;

import java.io.Serializable;
import java.sql.Date;
import java.util.GregorianCalendar;

public class Medicinale implements Serializable{
    private String name;
    private String scadenza;
    private String azienda;
    private int disponibili;
    private boolean isScaduto;

    public Medicinale(String name, String azienda, String scadenza, int disponibili, boolean isScaduto){
        this.name = name;
        this.scadenza = scadenza;
        this.azienda = azienda;
        this.disponibili = disponibili;
        this.isScaduto = isScaduto;
    }

    public String getAzienda(){
        return azienda;
    }

    public boolean isScaduto(){
        return isScaduto;
    }

    public int getDisp(){
        return disponibili;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "Medicinale{" +
                "name='" + name + '\'' +
                ", scadenza='" + scadenza + '\'' +
                ", azienda='" + azienda + '\'' +
                ", disponibili=" + disponibili +
                ", isScaduto=" + isScaduto +
                '}';
    }
}

    



