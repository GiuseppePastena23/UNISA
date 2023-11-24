package Game;

public class Orco extends Personaggio
{
	static int ID_Orco = 0;
	
	public Orco(String tipo, int energia, int posizione_iniziale)
	{
		this.ID_Orco = ++ID_Orco;
    	this.id = ++last_ID;
    	this.tipo = tipo;
    	this.energia = energia;
    	this.posizione_iniziale = posizione_iniziale;
    	this.posizione = posizione_iniziale;
    }	
		
}
