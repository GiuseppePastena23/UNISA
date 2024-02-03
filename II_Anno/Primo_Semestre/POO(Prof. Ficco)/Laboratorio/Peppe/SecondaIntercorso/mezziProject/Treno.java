package core.mezzi;


public class Treno extends Veicolo{

    private int minRitardo;

    public Treno(int kmPercorsi, int minRitardo){
        super("Treno", kmPercorsi);
        this.minRitardo = minRitardo;
    }

    public int getMinRitardo(){
        return minRitardo;
    }

    @Override
    public String toString(){
        return "Treno " + "minuti ritardo=" + minRitardo + super.toString();
    }
}