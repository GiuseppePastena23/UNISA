package car;

import java.awt.*;

public class Macchina extends Autovettura {
    protected String matricola;
    protected String targa;
    protected int nMarce;

    public Macchina(String tipoAutovettura, int numeroRuote, int cilindrataMotore, Color colore, String matricola,
                    String targa, int nMarce) {
        super(tipoAutovettura, numeroRuote, cilindrataMotore, colore);
        this.matricola = matricola;
        this.targa = targa;
        this.nMarce = nMarce;
    }

    public void Accendi(Auto a) throws AlreadyEngine {
        if (!isAccesa) {
            isAccesa = true;
        }
        else {
            throw new AlreadyEngine(true);
        }
    }

    public void Spegni(Auto a) throws AlreadyEngine{
        if (isAccesa) {
            isAccesa = false;
        }
        else  {
            throw new AlreadyEngine(false);
        }
    }
}
