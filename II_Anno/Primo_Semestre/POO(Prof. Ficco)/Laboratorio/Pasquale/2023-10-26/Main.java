import geometria.*;

public class Main {
    public static void main(String[] args) {
        // Triangolo tri = new Triangolo(1, 2);
        // Quadrato qua = new Quadrato(1);
        // ExtendedTriangle ext = new ExtendedTriangle(1, 1, 1, 1, 1);
        Triangolo ext = new ExtendedTriangle(1, 2, 1, 2, 1);
        System.out.println(ext.calcolaArea());
    }
}
