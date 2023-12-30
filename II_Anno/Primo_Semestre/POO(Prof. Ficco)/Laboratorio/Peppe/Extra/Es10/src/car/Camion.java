package car;
import java.awt.*;

public class Camion extends Macchina{

    public float lunghezzaRimorchio;
    public float pesoCarico;
    public int limiteVel;

    public Camion(String type, int nRuote, int cilindrataMotore, Color colore, int matricola, String targa, int nMarce, float lunghezzaRimorchio, float pesoCarico, int limiteVel){
        super(type, nRuote, cilindrataMotore, colore, matricola, targa, nMarce);
        this.lunghezzaRimorchio = lunghezzaRimorchio;
        this.pesoCarico = pesoCarico;
        this.limiteVel = limiteVel;
    }

    public void caricaRimorchio(float peso)
    {
        this.pesoCarico = peso;
    }

    public void scaricaRimorchio()
    {
        this.pesoCarico = 0;
    }
}