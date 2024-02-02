package core;
import java.io.Serializable;

public abstract class Dipendente implements Serializable
{
	private String nome;
	private String cognome;
	private int id;
	private double salario;
	
	public Dipendente(String nome, String cognome, int id, double salario)
	{
		this.nome = nome;
		this.cognome = cognome;
		this.id = id;
		this.salario = salario;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public abstract double calcolaStipendio();

	public String toString() 
	{
		return "Dipendente [nome=" + nome + ", cognome=" + cognome + ", id=" + id + ", salarioBase=" + salario + "]";
	}
}
