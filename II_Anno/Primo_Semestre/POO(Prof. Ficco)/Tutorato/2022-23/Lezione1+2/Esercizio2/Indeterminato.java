package core;

public class Indeterminato extends Dipendente 
{
	final int BONUS = 30;

	public Indeterminato(String nome, String cognome, int id, float salario)
	{
		super(nome, cognome, id, salario);
	}

	@Override
	public String toString() {
		return "Indeterminato [BONUS=" + BONUS + " " + super.toString() + "]";
	}

	@Override
	public double calcolaStipendio() 
	{
		double salarioBase = this.getSalario();
		double incremento = (salarioBase * BONUS)/100;
		
		return salarioBase + incremento;
	}
}
