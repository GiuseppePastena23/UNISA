package car;

import java.awt.*;

public abstract class Autovettura implements Auto {
    protected static int lastAuto = 0;

    protected int id;
    protected String tipoAutovettura;
    protected int numeroRuote;
    protected int cilindrataMotore;
    protected Color colore;
    protected boolean isAccesa = false;

    protected Autovettura(String tipoAutovettura, int numeroRuote, int cilindrataMotore, Color colore) {
        id = ++lastAuto;
        this.tipoAutovettura = tipoAutovettura;
        this.numeroRuote = numeroRuote;
        this.cilindrataMotore = cilindrataMotore;
        this.colore = colore;
    }


    public abstract void Accendi() throws AlreadyEngine;

    public abstract void Spegni() throws AlreadyEngine;


}
