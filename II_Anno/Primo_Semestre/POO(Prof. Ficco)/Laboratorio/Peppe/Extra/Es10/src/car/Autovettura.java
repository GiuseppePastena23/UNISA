package car;
import java.awt.*;

public abstract class Autovettura implements Auto{

    public String type;
    public int nRuote;
    public int cilindrataMotore;
    public Color colore;
    public boolean accesa; // False spenta True accesa
    private static int id = 0;

    public Autovettura(String type, int nRuote, int cilindrataMotore, Color colore){
        this.type = type;
        this.nRuote = nRuote;
        this.cilindrataMotore = cilindrataMotore;
        this.colore = colore;
        this.accesa = false;
        id++;
    }

    public abstract void accendi() throws CarAlreadyOnOff;

    public abstract void spegni() throws CarAlreadyOnOff;
}