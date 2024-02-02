package core;

public class Stagista extends Dipendente 
{
	private Dipendente supervisor;

	public Stagista(String nome, String cognome, int id, double salario, Dipendente supervisor) 
	{
		super(nome, cognome, id, salario);
		this.supervisor = supervisor;
	}

	public Dipendente getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Dipendente supervisor) {
		this.supervisor = supervisor;
	}

	@Override
	public String toString() {
		return "Stagista [supervisor=" + supervisor + " " + super.toString() + "]";
	}

	@Override
	public double calcolaStipendio() {
		
		double stipendioBase = this.getSalario();
		return stipendioBase - 300;
	}
	
	
}
