import java.util.Objects;

public class Esame 
{
	private String nome;
	private int voto;
	private int cfu;
	
	public Esame(String nome, int voto, int cfu) 
	{
		this.nome = nome;
		this.voto = voto;
		this.cfu = cfu;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getVoto() {
		return voto;
	}
	public void setVoto(int voto) {
		this.voto = voto;
	}
	public int getCfu() {
		return cfu;
	}
	public void setCfu(int cfu) {
		this.cfu = cfu;
	}

	@Override
	public String toString() {
		return "Esame [nome=" + nome + ", voto=" + voto + ", cfu=" + cfu + "]";
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Esame other = (Esame) obj;
		return cfu == other.cfu && nome.equals(other.getNome()) && voto == other.voto;
	}
	
}
