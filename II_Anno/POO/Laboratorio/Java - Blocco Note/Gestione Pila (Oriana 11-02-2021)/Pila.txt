package gestione.pila;
public class Pila 
{
    private int[] vet;
    private int d;

    public Pila(int dim) 
    {
        int i;
        this.vet=new int[dim];
        for(i=0;i<dim;i++)
        {
            this.vet[i] = 0;
        }
        this.d=0;
    }
    
    public void inserisci(int e)
    {
        this.vet[this.d]=e;
        this.d++;
    }

    public int getD() 
    {
        return d;
    }
    
    
    public void elimina()
    {
        if(this.d==0)
            System.out.println("Pila Vuota");
        else
        {
            this.vet[this.d-1]=0;
            this.d--;
        }
    }
    
    public int top()
    {
        return this.vet[this.d-1];
    }
    
    @Override
    public String toString()
    {
        String tes ="La stampa è: ";
        for(int i=0;i<this.d;i++)
        {
            tes=tes+" / Pila n. " + i + " = " + this.vet[i] + "\n";
        }
        return tes;
    }
}
