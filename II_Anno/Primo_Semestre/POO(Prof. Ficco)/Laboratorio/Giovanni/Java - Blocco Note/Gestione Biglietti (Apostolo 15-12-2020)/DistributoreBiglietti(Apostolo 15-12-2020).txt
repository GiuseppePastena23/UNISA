package gestionebiglietti;
public class distributorebiglietti
{	
	private String codice;
	private String nomeF;
	private int nBiglietti;
	private int stato;
	private float costo;

	public distributorebiglietti(String codice, String nomeF, int nBiglietti, float costo)
	{
            this.codice=codice;
            this.nomeF=nomeF;
            this.nBiglietti=nBiglietti;
            stato=1;
            this.costo=costo;
	}

	public String getCodice()
	{
            return codice;
	}

	public String getNomeF()
	{
            return nomeF;
	}

	public int getnBiglietti()
	{
            return nBiglietti;
	}
	
	public int getStato()
	{
            return stato;
	}

	public float getCosto()
	{
            return costo;
	}

	public void setCodice(String codice)
	{
            this.codice=codice;
	}

	public void setNomeF(String nomeF)
	{
            this.nomeF=nomeF;
	}

	public void setStato(int stato)
	{
            this.stato=stato;
	}

	public void setCosto(float costo)
	{
            this.costo=costo;
	}

	@Override
	public String toString()
	{
            return "distributore (codice: " + codice + " - nomeF: " + nomeF + " - stato: "+  stato + " - costo: " + costo + ")";
 	}

	public int ricarica(int N)
	{
            this.nBiglietti=this.nBiglietti+N;
            this.stato=1;
            return this.nBiglietti;	
	}

	public float vendi(int N)
	{
            this.nBiglietti=this.nBiglietti-N;
            if(this.nBiglietti==0)
                this.stato=0;
            return this.costo*N;
	}	
	
	public void ripara()
	{
            this.stato=1;
	}
}