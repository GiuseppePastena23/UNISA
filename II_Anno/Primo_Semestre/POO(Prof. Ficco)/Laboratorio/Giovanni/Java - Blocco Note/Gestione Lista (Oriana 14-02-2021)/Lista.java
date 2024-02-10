package gestionelista;
public class Lista 
{
    private int[] lis;
    private int gra;
   
    public Lista(int dim)
    {
        this.gra=0;
        this.lis=new int[dim];
        for(int i=0;i<dim;i++)
        {
            this.lis[i]=0;
        }
    }
    
    public void inseriscico(int e, int dim)
    {
        for(int i=0;i<dim;i++)
        {
            if(this.lis[i]==0)
            {
                this.lis[i]=e;
                i=dim;
            }
        }
        this.gra++;
    }
    
    public void inseriscime(int e, int pos, int dim)
    {
        for(int i=dim-1;i>pos;i--)
        {
            this.lis[i]=this.lis[i-1];
        }
        this.lis[pos]=e;
        this.gra++;
    }
    
    public void inseriscimes(int e, int pos)
    {
        this.lis[pos]=e;
    }
    
    public void elimina(int pos, int dim)
    {
        for(int i=pos;i<dim-1;i++)
        {
            this.lis[i]=this.lis[i+1];
        }
        this.lis[dim-1]=0;
        this.gra--;
    }
    
    public void eliminas(int pos)
    {
        this.lis[pos]=0;
        this.gra--;
    }

    public int getGra() 
    {
        return this.gra;
    }
    
    public int getLis(int dim)
    {
        return this.lis[dim-1];
    }
    
    public int getLispos(int pos)
    {
        return this.lis[pos];
    }
    public int seleziona(int pos)
    {
        return this.lis[pos];
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