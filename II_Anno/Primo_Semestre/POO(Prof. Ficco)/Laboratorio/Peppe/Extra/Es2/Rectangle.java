public class Rectangle implements Shape {
    protected double base;
    protected double altezza;

    public Rectangle(double base, double altezza)
    {
        this.base = base;
        this.altezza = altezza;
    }

    public double calculatePerimeter()
    {
        return (this.base * 2) + (this.altezza * 2);
    }

    public double calculateArea()
    {
        return (this.base * this.altezza);
    }
    
}
