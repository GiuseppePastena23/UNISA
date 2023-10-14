package televisore;
public class aumvol 
{
    private int vol;
    public aumvol(int vo)
    {
        this.vol=vo;
        if(this.vol==100)
        {
            System.out.println("Il volume è al massimo");
        }
        else
        {
            this.vol++;
        }
    }
    public int aumenta()
    {
        return this.vol;
    }
}