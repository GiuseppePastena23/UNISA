package televisore;
public class accendi 
{
    private int a;
    public accendi(int ac)
    {
        this.a=ac;
        if(this.a==1)
        {
            System.out.println("La televisione e' gia' accesa");
        }
        else
        {
            System.out.println("La televisione si e' accesa");
            this.a=1;
        }
    }
    public int accensione()
    {
        return this.a;
    }
}