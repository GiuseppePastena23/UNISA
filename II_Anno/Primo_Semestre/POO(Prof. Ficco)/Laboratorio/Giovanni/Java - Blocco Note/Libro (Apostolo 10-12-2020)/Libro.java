package biblioteca;
public class Libro
{
	private int codice; 
	private String titolo;
	private int numcop;
	private float prezzo;
	
	public libro(int codice, String titolo, int numcop, float prezzo)
	{
		this.codice=codice;
		this.titolo=titolo;
		this.numcop=numcop;
		this.prezzo=prezzo;
	}
	
	@Override
	public String toString()
	{
		return "Libro ("+"Codice: "+codice+ " - Titolo: "+titolo+" - Numero Copie: "+numcop" - Prezzo: "+prezzo+")"; 
	}

	public void prestito()
	{
		if(this.numcop>0)
		{
			this.numcop--;
			System.out.println("Prestito effettuato");
		}
		else
			System.out.println("Non ci sono più copie di questo libro");
	}
	
	public void reso()
	{
		this.numcop++;
	}	
}