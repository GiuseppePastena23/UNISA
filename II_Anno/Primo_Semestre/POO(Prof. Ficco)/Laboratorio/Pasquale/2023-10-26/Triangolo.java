package geometria;

public class Triangolo {
    double base;
    double altezza;

    public Triangolo(double base, double altezza) {
        System.out.println("Creo oggetto triangolo");
        this.base = base;
        this.altezza = altezza;
    }

    public double calcolaArea() {
        return (base * altezza) / 2;
    }
}
