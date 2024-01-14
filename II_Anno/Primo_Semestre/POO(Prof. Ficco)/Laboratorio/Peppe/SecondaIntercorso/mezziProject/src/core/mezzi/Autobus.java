package core.mezzi;

public class Autobus extends Veicolo{

    public int nPosti;

    public Autobus(int kmPercorsi, int nPosti){
        super("Autobus", kmPercorsi);
        this.nPosti = nPosti;
    }

    public int getPosti()
    {
        return nPosti;
    }

    @Override
    public String toString(){
        return "Autobus " + "nPosti=" + nPosti + super.toString();
    }
}