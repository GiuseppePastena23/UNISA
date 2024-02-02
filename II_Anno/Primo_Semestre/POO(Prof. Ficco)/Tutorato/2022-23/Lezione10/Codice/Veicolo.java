package core;

public abstract class Veicolo implements TransActions 
{
	private static int count = 0;
	
	protected int id;
	protected String tipo;
	protected int km;
	
	public Veicolo(String tipo)
	{
		this.id = count++;
		this.tipo = tipo;
		this.km = 0;
	}
	
	
	
	public Veicolo(String tipo, int km) 
	{
		this.id = count++;
		this.tipo = tipo;
		this.km = km;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public int getKm() {
		return km;
	}
	

	public void setKm(int km) {
		this.km = km;
	}

	public boolean checkTicket(Ticket t) 
	{
		if(t.isValido())
		{
			t.setValido(false);
			return true;
		}
		else return false;
	}

	public Ticket buyTicket(int money) throws IllegalActionException 
	{
		assert(money > 0);
		if(money >= Ticket.prezzoBase) return new Ticket();
		else throw new IllegalActionException();
		
		/*
		 
		 if(money < Ticket.prezzoBase) throw new IllegalActionException();
		 else return new Ticket();
		 
		 */
	}

	public String toString() {
		return "Veicolo [id=" + id + ", tipo=" + tipo + ", km=" + km + "]";
	}
	
	public abstract void printDetailedInfo();
}
