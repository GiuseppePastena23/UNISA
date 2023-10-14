package gestionecoda;
public class Coda
{
    private int[] cod;
    private int gra;
   
    public Coda(int dim)
    {
        this.gra=0;
        this.cod=new int[dim];
        for(int i=0;i<dim;i++)
        {
            this.cod[i]=0;
        }
    }
   
    public void inserisci(int e)
    {
       
        this.cod[this.gra]=e;
        this.gra++;
    }

    public int getGra() 
    {
        return gra;
    }
    
    public void elimina()
    {
        if(this.gra==0)
            System.out.println("Coda vuota");
        else
        {
            this.cod[0]=0;
            for(int i=0;i<gra-1;i++)
            {
                this.cod[i]=this.cod[i+1];
            }
            this.gra--;
        }
    }
    
    @Override
    public String toString()
    {
        String tes ="La stampa è: \n";
        for(int i=0;i<this.gra;i++)
        {
            tes=tes+" / Pila n. " + i + " = " + this.cod[i] + "\n";
        }
        return tes;
    }
}