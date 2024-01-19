public class TriangoloIsoscele extends FigureGeometriche {
    int base;
    int lato;

    public TriangoloIsoscele(int base, int lato) {
        this.base = base;
        this.lato = lato;
    }

    public double getAltezza() {
        return Math.sqrt(lato * lato - (base * base / 4));  
    }

    @Override
    public double getPerimetro() {
        return base + lato * 2;
    }

    @Override
    public double getArea() {
        return base * getAltezza() / 2;
    }
}
