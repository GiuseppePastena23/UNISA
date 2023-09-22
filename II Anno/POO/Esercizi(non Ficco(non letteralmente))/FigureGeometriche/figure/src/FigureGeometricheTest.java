import java.util.ArrayList;
import java.util.Random;

public class FigureGeometricheTest {
    public static void main(String[] args) throws Exception {
        ArrayList<FigureGeometriche> figure = new ArrayList<FigureGeometriche>();
        Random rnd = new Random();
        double sumArea = 0, sumPerimetro = 0;
        for (int i = 0; i < 5; i++) {
            figure.add(new Cerchio(rnd.nextInt(10) + 1));
            figure.add(new Rettangolo(rnd.nextInt(10) + 1, rnd.nextInt(10) + 2));
            figure.add(new TriangoloIsoscele(rnd.nextInt(10) + 1, rnd.nextInt(10) + 1));
        }

        for (FigureGeometriche figura : figure) {
            sumArea += figura.getArea();
            sumPerimetro += figura.getPerimetro();
        }

        System.out.println("Area " + sumArea + "\nPerimetro " + sumPerimetro);
    }
}
