
public class StudenteDSA extends Studente 
{
	private String patologia;

	public StudenteDSA(String matricola, String nome, String cognome, String patologia) 
	{
		super(matricola, nome, cognome);
		this.patologia = patologia;
	}

	public String getPatologia() {
		return patologia;
	}

	public void setPatologia(String patologia) {
		this.patologia = patologia;
	}

	@Override
	public String toString() {
		return "StudenteDSA [patologia=" + patologia + " " + super.toString() + "]";
	}
	
	
}
