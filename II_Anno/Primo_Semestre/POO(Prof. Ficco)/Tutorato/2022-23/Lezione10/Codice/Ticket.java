package core;

public class Ticket 
{
	public static final int prezzoBase = 10;
	
	private boolean valido;
	private int prezzo;
	
	public Ticket()
	{
		this.valido = true;
		this.prezzo = prezzoBase;
	}
	
	public Ticket(int prezzo)
	{
		this.valido = true;
		this.prezzo = prezzo;
	}

	public boolean isValido() {
		return valido;
	}

	public void setValido(boolean valido) {
		this.valido = valido;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	public String toString() {
		return "Ticket [valido=" + valido + ", prezzo=" + prezzo + "]";
	}	
}
