package Game;

public class Orco extends Personaggio
{
	private static int Last_ID_Orco = 0;
	private int ID_Orco;
	
	public Orco(String tipo, int energia, int posizione_iniziale)
	{
		super(tipo, energia, posizione_iniziale);
		this.ID_Orco = ++Last_ID_Orco;
    }	
    
    @Override public void Colpisci(Personaggio pers)
    {
    	Danneggia(pers, 50);
    }
    
    @Override
    public String toString()
    {
        return ("ORCO: Tipo = " + this.tipo + " Vita = " + this.energia + " Posizione = " + this.posizione);
    }
}
