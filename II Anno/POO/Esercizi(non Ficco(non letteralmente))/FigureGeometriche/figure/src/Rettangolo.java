public class Rettangolo extends FigureGeometriche {
    int base;
    int altezza;

    public Rettangolo(int base, int altezza) {
        this.base = base;
        this.altezza = altezza;
    }

    @Override
    public double getPerimetro() {
        return base * 2 + altezza * 2;
    }

    @Override
    public double getArea() {
        return base * altezza;
    }
}
