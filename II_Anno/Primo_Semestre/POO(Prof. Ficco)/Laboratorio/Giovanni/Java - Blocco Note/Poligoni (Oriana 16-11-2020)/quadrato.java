package poligoni;
public class quadrato{
    private int lato1;
    public quadrato(int l1)
    {
        this.lato1=l1;
    }
    public int perimetro()
    {
        return(this.lato1*4);
    }
}