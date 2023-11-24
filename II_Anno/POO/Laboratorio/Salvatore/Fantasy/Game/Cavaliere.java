package Game;

public class Cavaliere extends Personaggio
{
	static int ID_Cavaliere = 0;
	
	public Cavaliere(String tipo, int energia, int posizione_iniziale)
	{
		this.ID_Cavaliere = ++ID_Cavaliere;
    	this.id = ++last_ID;
    	this.tipo = tipo;
    	this.energia = energia;
    	this.posizione_iniziale = posizione_iniziale;
    	this.posizione = posizione_iniziale;
    }	
		
}
