
public class Soldato 
{
	private String nome;
	private int grado;
	
	public Soldato(String nome, int grado)
	{
		this.nome = nome;
		this.grado = grado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getGrado() {
		return grado;
	}

	public void setGrado(int grado) {
		this.grado = grado;
	}


	public String toString() 
	{
		return "Soldato [" + nome  + "," + grado + "]";
	}
}
