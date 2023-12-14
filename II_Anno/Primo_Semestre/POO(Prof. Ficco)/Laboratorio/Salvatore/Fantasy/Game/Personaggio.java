package Game;

public abstract class Personaggio implements SuperPersonaggio
{
	private static int last_ID = 0;
	protected int ID;
	protected String tipo;
	protected int energia;
	protected int posizione_iniziale;
	protected int posizione;
	protected int direzione;
	
	public Personaggio(String tipo, int energia, int posizione_iniziale)
	{
    	this.ID = ++last_ID;
    	this.tipo = tipo;
    	this.energia = energia;
    	this.posizione_iniziale = posizione_iniziale;
    	this.posizione = posizione_iniziale;
    }
    
    @Override
    public String toString()
    {
        return ("PERSONAGGIO: Tipo = " + this.tipo + " Vita = " + this.energia + " Posizione = " + this.posizione);
    }
    
    public int getPosizione(Personaggio pers)
	{
		return (this.posizione);
	}
	
	public abstract void Colpisci(Personaggio pers);
	
	public void Danneggia(Personaggio pers, int danno)
	{
		this.energia = this.energia - danno;
	}

	public void ruota(int gradi)
	{
		this.direzione = gradi%360;
	}
	public void avanti(int spazio)
	{
		this.posizione = this.posizione+spazio;
	}
	public void indietro(int spazio)
	{
		this.posizione = -(this.posizione+spazio);
	}
}
