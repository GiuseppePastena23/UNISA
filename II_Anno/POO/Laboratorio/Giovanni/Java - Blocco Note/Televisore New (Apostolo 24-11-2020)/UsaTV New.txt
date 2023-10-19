package televisore;
public class televisione 
{
    private int stato;
    private int volume;
    private int canale;
   
    public void televisione(int s,int v,int c)
    {
        this.stato=s; 
        this.volume=v;
        this.canale=c;       
    }

 
    public int accendi(int st)
    {
        this.stato=st;
        if(this.stato==1)
            System.out.println("La televisione e' gia' accesa");
        else
        {
            System.out.println("La televisione si e' accesa");
            this.stato=1;
        }
        return this.stato;
    }
    
    public int spegni(int st)
    {
        this.stato=st;
        if(this.stato==0)
            System.out.println("La televisione e' gia' spenta");
        else
        {
            System.out.println("La televisione si e' spenta");
            this.stato=0;
        }
        return this.stato;
    }
    
    public int aumvol(int vol)
    {
        this.volume=vol;
        if(this.volume==100)
            System.out.println("Il volume è al massimo");
        else
            this.volume++;
        return this.volume;
    }
    
    public int dimvol(int vol)
    {
        this.volume=vol;
        if(this.volume==0)
            System.out.println("Il volume è al minimo");
        else
            this.volume--;
        return this.volume;
    }
    
    public int camcan(int c)
    {
        this.canale=c;
        return this.canale;
    }
    
    public int aumcan(int c)
    {
        this.canale=c;
        if(this.canale==30)
            System.out.println("Sei già al canale massimo");
        else
            this.canale++;
        return this.canale;
    }
    
    public int dimcan(int c)
    {
        this.canale=c;
        if(this.canale==0)
            System.out.println("Sei già al canale minimo");
        else
            this.canale--;
        return this.canale;
    }
    
    public int getStato() 
    {
        return this.stato;
    }

    public int getVolume() 
    {
        return this.volume;
    }

    public int getCanale() 
    {
        return this.canale;
    }
}