public class Circle implements Shape{
    
    protected double raggio;
    protected double diametro;
    protected static final double PI = 3.141592653589793;

    public Circle(double raggio)
    {
        this.raggio = raggio;
        this.diametro = raggio * 2;
    }

    public double calculatePerimeter()
    {
        return (this.diametro * PI);
    }

    public double calculateArea()
    {
        return (PI * (this.raggio * this.raggio));
    }
    
}
