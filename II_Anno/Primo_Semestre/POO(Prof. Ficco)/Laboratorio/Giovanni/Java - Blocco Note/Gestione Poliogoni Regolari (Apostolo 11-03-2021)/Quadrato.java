package gestionepoligoniregolari;
public class Quadrato extends Figure 
{
    public Quadrato(double lato) 
    {
        super(lato);
    }

    @Override
    public double perimetro()
    {
        return lato * 4;
    }

    @Override
    public double area()
    {
        return lato*lato;
    }
}