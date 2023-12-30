package pgiorno;
public class giorno
{
	private int numgio;
	private float temmax, temmin;

	public giorno(int numgio, float temmax, float temmin)
	{
		this.numgio=numgio;
		this.temmax=temmax;
		this.temmin=temmin;
	}

	public int getNumgio()
	{
		return numgio;
	}

	public float getTemmax()
	{
		return temmax;
	}
	
	public float getTemmin()
	{
		return temmin;
	}

	public void setNumgio(int numgio)
	{
		this.numgio=numgio;
	}

	public void setTemmax(float temmax)
	{
		this.temmax=temmax;
	}
	
	public void setTemmin(float temmin)
	{
		this.temmin=temmin;
	}
	
	public float scostamento()
	{
		return this.temmax-this.temmin;
	}
        
        @Override
        public String toString()
        {
            return "giorno (" + "Numero del giorno: " + numgio + "- Temperatura massima: " + temmax + "- Temperatura minima " + temmin + ")";
        }
        
        public void stampaMaggiore(float magg)
        {
            if(magg>this.temmax)
                System.out.println("La temperatura inserita è maggiore");
            else
                System.out.println("La temperatura inserita è minore o uguale");
        }
        
        public float mediaG()
        {
            return (this.temmax+this.temmin)/2;
        }
}

