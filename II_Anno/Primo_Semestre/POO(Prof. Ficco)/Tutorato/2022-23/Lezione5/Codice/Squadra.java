package core;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Squadra 
{
	private List<Calciatore> rosa;
	private String nomeSquadra;
	private int numScudetti;
	
	public Squadra(String nomeSquadra, int numScudetti) 
	{
		this.rosa = new ArrayList<Calciatore>();
		this.nomeSquadra = nomeSquadra;
		this.numScudetti = numScudetti;
	}

	@Override
	public String toString() {
		return "Squadra [nomeSquadra=" + nomeSquadra + ", numScudetti=" + numScudetti + "]";
	}

	public List<Calciatore> getRosa() {
		return rosa;
	}

	public void setRosa(List<Calciatore> rosa) {
		this.rosa = rosa;
	}

	public String getNomeSquadra() {
		return nomeSquadra;
	}

	public void setNomeSquadra(String nomeSquadra) {
		this.nomeSquadra = nomeSquadra;
	}

	public int getNumScudetti() {
		return numScudetti;
	}

	public void setNumScudetti(int numScudetti) {
		this.numScudetti = numScudetti;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nomeSquadra, numScudetti, rosa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Squadra other = (Squadra) obj;
		return nomeSquadra.equals(other.nomeSquadra) && numScudetti == other.numScudetti;
	}
	
	public void printPlayerByCond(Predicate<Calciatore> pred,Consumer<Calciatore> cons)
	{
		this.rosa.stream().filter(pred).forEach(cons);
	}
	
	public static int compareByScudetti(Squadra s1,Squadra s2)
	{
		return s1.getNumScudetti() - s2.getNumScudetti();
	}
}
