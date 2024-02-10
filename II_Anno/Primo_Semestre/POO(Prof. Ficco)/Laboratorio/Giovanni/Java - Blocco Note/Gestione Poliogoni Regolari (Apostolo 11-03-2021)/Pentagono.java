package gestionepoligoniregolari;
public class Pentagono extends Figure
{
    public Pentagono(double lato) 
    {
        super(lato);
    }

    @Override
    public double perimetro()
    {
        return lato * 5;
    }

    @Override
    public double area()
    {
        return (this.lato*this.lato)*1.72;
    }
}