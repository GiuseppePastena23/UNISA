package gestionepoligoniregolari;
public class Triangolo extends Figure
{
    public Triangolo(double lato) 
    {
        super(lato);
    }
    
    @Override
    public double perimetro()
    {
        return lato * 3;
    }

    @Override
    public double area()
    {
        return (Math.sqrt(3)/4)*(this.lato*this.lato);
    }
}