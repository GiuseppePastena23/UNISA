package core.mezzi;

public abstract class Veicolo{

    private static int id = 0;
    private final int thisId;
    private String tipo;
    private int kmPercorsi;

    protected Veicolo(String tipo, int kmPercorsi){
        this.tipo = tipo;
        this.kmPercorsi = kmPercorsi;
        this.id += 1;
        this.thisId = this.id;
    }

    @Override
    public String toString(){
        return ", Veicolo" + thisId + ": " + "Tipo: " + tipo + ", Km Percorsi: " + kmPercorsi;
    }
}