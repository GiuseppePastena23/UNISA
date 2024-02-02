
public class SoldatoScelto extends Soldato 
{
	private String nomeSpecialità;
	private int numMissioni;
	
	public SoldatoScelto(String nome, int grado, String nomeSpecialità, int numMissioni) 
	{
		super(nome, grado);
		this.nomeSpecialità = nomeSpecialità;
		this.numMissioni = numMissioni;
	}

	public String getNomeSpecialità() {
		return nomeSpecialità;
	}

	public void setNomeSpecialità(String nomeSpecialità) {
		this.nomeSpecialità = nomeSpecialità;
	}

	public int getNumMissioni() {
		return numMissioni;
	}

	public void setNumMissioni(int numMissioni) {
		this.numMissioni = numMissioni;
	}

	@Override
	public String toString() 
	{
		return "SoldatoScelto [" + nomeSpecialità + "," + numMissioni + "," + super.toString() + "]";
	}
	
	
}
