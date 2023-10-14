package televisore;
public class dimvol 
{
    private int vol;
    public dimvol(int vo)
    {
        this.vol=vo;
        if(this.vol==0)
        {
            System.out.println("Il volume è al minimo");
        }
        else
        {
            this.vol--;
        }
    }
    public int diminuisce()
    {
        return this.vol;
    }
}
