package gestionepoligoniregolari;
public abstract class Figure 
{
    protected double lato; 

    public Figure(double lato) 
    {
        this.lato = lato;
    }

    public double getLato() 
    {
        return lato;
    }

    public void setLato(double lato) 
    {
        this.lato = lato;
    }

    public abstract double perimetro();
    public abstract double area();
}