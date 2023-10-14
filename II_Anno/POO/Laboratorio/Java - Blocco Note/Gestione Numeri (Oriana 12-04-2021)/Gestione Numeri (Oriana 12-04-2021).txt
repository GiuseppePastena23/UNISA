INTERFACCIA
package GestioneNumeri;
public interface Numero
{
    abstract double valore();
    abstract String stampa();
}

INTERO
package GestioneNumeri;
public class Intero implements Numero
{
    private int v;

    public Intero(int v) 
    {
        this.v = v;
    }
    
    public boolean estd(int v2)
    {
        return (v%v2)==0;
    }

    public int getV() 
    {
        return v;
    }
    
    @Override
    public double valore()
    {
        return this.v;
    }
    
    @Override
    public String stampa() 
    {
        return "Intero{" + "v=" + v + '}';
    }
}

FRAZIONE
package GestioneNumeri;
public class Frazione implements Numero 
{
    private int n;
    private int d;

    public Frazione(int n, int d) 
    {
        this.n = n;
        this.d = d;
    }
    
    public boolean estfp()
    {
        return n<d;
    }
    
    public void inversa()
    {
        int t;
        t=this.n;
        this.n=this.d;
        this.n=t;
    }
    
    public int getn()
    {
        return n;
    }
    
    public int getd()
    {
        return d;
    }

    @Override
    public String stampa() 
    {
        return "Frazione{" + "n=" + n + ", d=" + d + '}';
    }
    
    @Override
    public double valore()
    { 
        return (double)n/d;
    }
}

OPERAZIONE
package GestioneNumeri;
public class Operazione implements Numero
{
    private double op1;
    private double op2;
    private char op;
    
    public Operazione(double o1,double o2, char o) 
    {
        op1=o1;
        op2=o2;
        op=o;
    }
    
    public double getop1()
    {
        return op1;
    }
    
    public double getop2()
    {
        return op2;
    }
    
    public char getop()
    {
        return op;
    }

    @Override
    public String stampa() {
        return "Operazione{" + "op1=" + op1 + ", op2=" + op2 + ", op=" + op + '}';
    }
    
    @Override
    public double valore()
    {
        switch(op)
        {
            case '+':
                return op1+op2;
            
            case '-':
                return op1-op2;
            
            case '*':
                return op1*op2;
                
            case '/':
                return op1-op2;
                
            default: 
                return 0;
        }
    }
}