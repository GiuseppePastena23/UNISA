package Game;

public class Cavaliere extends Personaggio
{
	private static int Last_ID_Cavaliere = 0;
	private int ID_Cavaliere;
	
	public Cavaliere(String tipo, int energia, int posizione_iniziale)
	{
		super(tipo, energia, posizione_iniziale);
		this.ID_Cavaliere = ++Last_ID_Cavaliere;
	}
    	
    @Override public void Colpisci(Personaggio pers)
    {
    	Danneggia(pers, 100);
    }
		
	@Override
    public String toString()
    {
        return ("CAVALIERE: Tipo = " + this.tipo + " Vita = " + this.energia + " Posizione = " + this.posizione);
    }
}
