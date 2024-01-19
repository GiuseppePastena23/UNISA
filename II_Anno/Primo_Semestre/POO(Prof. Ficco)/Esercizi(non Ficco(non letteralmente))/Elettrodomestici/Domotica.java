import java.util.ArrayList;

public class Domotica {
    private ArrayList<Elettrodomestico> elettrodomestici;

    public Domotica() {
        this.elettrodomestici = new ArrayList<Elettrodomestico>();
    }

    public boolean aggiungiElettrodomestico(Elettrodomestico elettrodomestico) {
        this.elettrodomestici.add(elettrodomestico);
        return true;
    }

    public String testElettrodomestici() {
        String output = "";
        for (Elettrodomestico elettrodomestico : elettrodomestici) {
            output += elettrodomestico.start() + "\n";
            output += elettrodomestico.next() + "\n";
        }
        return output;
    }
}
 