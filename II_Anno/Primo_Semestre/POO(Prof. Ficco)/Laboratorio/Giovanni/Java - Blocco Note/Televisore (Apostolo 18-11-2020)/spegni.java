package televisore;
public class spegni 
{
    private int a;
    public spegni(int ac)
    {
        this.a=ac;
        if(this.a==0)
        {
            System.out.println("La televisione e' gia' spenta");
        }
        else
        {
            System.out.println("La televisione si e' spenta");
            this.a=0;
        }
    }
    public int spegnimento()
    {
        return this.a;
    }
}