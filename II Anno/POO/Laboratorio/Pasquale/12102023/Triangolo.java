import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Vuoi creare un triangolo o un quadrato?");
        System.out.println("q / t");
        char car = scan.nextLine().charAt(0);
        if (car == 'q') {
            System.out.println("Inserisci il lato");
            double lato = scan.nextDouble();
            Quadrato quadrato = new Quadrato(lato);
            System.out.println("L'area e': " + quadrato.calcolaArea());
        }
        else if (car == 't') {
            System.out.println("Inserisci base");
            double base = scan.nextDouble();
            System.out.println("Inserisci altezza");
            double altezza = scan.nextDouble();

            Triangolo myTriangle = new Triangolo(base, altezza);
            System.out.println("L'area e': " + myTriangle.calcolaArea());
        }

        scan.close();
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

class Quadrato {
    double lato;

    public Quadrato(double lato) {
        System.out.println("Creo oggetto Quadrato");
        this.lato = lato;
    }

    double calcolaArea() {
        return lato * lato;
    }
}
