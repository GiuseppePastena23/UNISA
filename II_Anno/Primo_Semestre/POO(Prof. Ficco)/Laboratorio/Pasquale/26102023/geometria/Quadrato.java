package geometria;

public class Quadrato {
    double lato;

    public Quadrato(double lato) {
        System.out.println("Creo oggetto Quadrato");
        this.lato = lato;
    }

    double calcolaArea() {
        return lato * lato;
    }
}
