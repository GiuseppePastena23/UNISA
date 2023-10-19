import java.lang.String;
public class Studente
{
	private String Nome;
	private int Mat;
	
	public Studente(String Nome, int Mat)
	{
		this.Mat=Mat;
		this.Nome=Nome;
	}
	
	@Override
    	public String toString() 
    	{
    		return  "Nome =" + Nome + ", Matricola =" + Mat;
    	}
}
