public class Cerchio extends FigureGeometriche {
    int raggio;

    public Cerchio(int raggio) {
        this.raggio = raggio;
    }
    
    @Override
    public double getPerimetro() {
        return raggio * 2 * Math.PI;
    }

    @Override
    public double getArea() {
        return raggio * raggio * Math.PI;
    }
}
