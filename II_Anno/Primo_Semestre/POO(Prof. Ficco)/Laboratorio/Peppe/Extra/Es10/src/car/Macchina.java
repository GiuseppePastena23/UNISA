package car;
import java.awt.*;

public class Macchina extends Autovettura{

    public final int matricola;
    public String targa;
    public int nMarce;

    public Macchina(String type, int nRuote, int cilindrataMotore, Color colore, int matricola, String targa, int nMarce){
        super(type, nRuote, cilindrataMotore, colore);
        this.matricola = matricola;
        this.targa = targa;
        this.nMarce = nMarce;
    }

    public void accendi() throws CarAlreadyOnOff{
        if(!this.accesa)
        {
            this.accesa = true;
        }
        else
        {
            throw new CarAlreadyOnOff("Autovettura gia' accesa");
        }
    }

    public void spegni() throws CarAlreadyOnOff{
        if(this.accesa)
        {
            this.accesa = false;
        }
        else
        {
            throw new CarAlreadyOnOff("Macchina gia' spenta");
        }
    }
}