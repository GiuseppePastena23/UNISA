package poligoni;
public class triangolo {
    private int lato1;
    private int lato2;
    private int lato3;
    
    public triangolo(int l1)
    {
        this.lato1=l1;
        this.lato2=l1;
        this.lato3=l1;
    }
   
    public triangolo(int l1, int l2)
    {
        this.lato1=l1;
        this.lato2=l1;
        this.lato3=l2;
   }
    public triangolo(int l1, int l2,int l3)
   {
        this.lato1=l1;
        this.lato2=l2;
        this.lato3=l3;
   }
    public int perimetro()
    {
        return(this.lato1+this.lato2+this.lato3);
    }
}
