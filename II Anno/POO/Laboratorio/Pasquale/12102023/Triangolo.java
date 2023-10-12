import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci base");
        double base = scan.nextDouble();
        System.out.println("Inserisci altezza");
        double altezza = scan.nextDouble();

        Triangolo myTriangle = new Triangolo(base, altezza);
        System.out.println("L'area e': " + myTriangle.calcolaArea());
    }
}

class Triangolo {
    double base;
    double altezza;

    public Triangolo(double base, double altezza) {
        System.out.println("Creo oggetto triangolo");
        this.base = base;
        this.altezza = altezza;
    }

    double calcolaArea() {
        return (base * altezza) / 2;
    }
}

class Ciao {
    static int cont;

    public Ciao() {
        
    }
}
