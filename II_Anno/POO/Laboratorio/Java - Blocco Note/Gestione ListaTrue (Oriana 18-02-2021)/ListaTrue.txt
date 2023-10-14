package gestionelistatrue;
public class ListaTrue 
{
    private int[] lis;
    private int gra;
   
    public ListaTrue(int dim)
    {
        this.gra=0;
        this.lis=new int[dim];
        for(int i=0;i<dim;i++)
        {
            this.lis[i]=0;
        }
    }
    
    public void inserisci(int e,int pos, int dim)
    {
        
        if(this.gra==dim)
            System.out.println("Lista piena");
        else if (pos>this.gra)
            System.out.println("Le posizioni vanno da 0 a " + this.gra);     
        else
        {
            this.gra++;
            for(int i=dim-1;i>pos;i--)
            {
                this.lis[i] = this.lis[i-1];
            }
            this.lis[pos] = e;
        }
    }
    
    public void elimina(int pos, int dim)
    {
        if(this.gra == 0)
            System.out.println("Lista vuota");
        else
        {
            for(int i=pos;i<dim-1;i++)
            {
                this.lis[i] = this.lis[i+1];
            }
            this.lis[this.gra-1] = 0;
            this.gra--;
        }
    }
    
    public int getGra() 
    {
        return this.gra;
    }
    
    public String toString(int dim)
    {
        String tes ="La stampa è: \n";
        for(int i=0;i<dim;i++)
        {
            tes=tes+" / Pila n. " + i + " = " + this.lis[i] + "\n";
        }
        return tes;
    }
}