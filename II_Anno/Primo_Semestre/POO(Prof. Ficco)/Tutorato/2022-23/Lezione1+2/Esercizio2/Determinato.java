package core;
import java.util.Date;

public class Determinato extends Dipendente
{
	private Date scadenza;

	public Determinato(String nome, String cognome, int id, double salario, Date scadenza) {
		super(nome, cognome, id, salario);
		this.scadenza = scadenza;
	}

	public Date getScadenza() {
		return scadenza;
	}

	public void setScadenza(Date scadenza) {
		this.scadenza = scadenza;
	}

	@Override
	public String toString() {
		return "Determinato [scadenza=" + scadenza + " " + super.toString() + "]";
	}

	@Override
	public double calcolaStipendio() {
		
		return this.getSalario();
	}
}
