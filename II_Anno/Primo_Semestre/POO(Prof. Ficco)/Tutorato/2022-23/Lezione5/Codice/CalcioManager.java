package core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import exception.NumberNotAvailableException;
import exception.SquadraRegisteredException;

public class CalcioManager 
{
	private List<Squadra> campionato;
	private String nomeCampionato;
	
	public CalcioManager(String nomeCampionato) 
	{
		this.campionato = new ArrayList<Squadra>();
		this.nomeCampionato = nomeCampionato;
	}

	public List<Squadra> getCampionato() {
		return campionato;
	}

	public void setCampionato(List<Squadra> campionato) {
		this.campionato = campionato;
	}

	public String getNomeCampionato() {
		return nomeCampionato;
	}

	public void setNomeCampionato(String nomeCampionato) {
		this.nomeCampionato = nomeCampionato;
	}
	
	//Attenzione: cambia l'ordine delle squadre nella collection!
	public boolean addPlayer(Calciatore c, Squadra s)
	{
		if(s.getRosa().contains(c)) return false;
		else
		{
			if(! this.campionato.contains(s)) return false;
			else
			{
				if(s.getRosa().size() == 0) 
				{
					s.getRosa().add(c);
					this.campionato.remove(s);
					this.campionato.add(s);
					return true;
				}
				else
				{
					for(Calciatore app : s.getRosa()) if(app.getNumMaglia() == c.getNumMaglia()) throw new NumberNotAvailableException();
					s.getRosa().add(c);
					this.campionato.remove(s);
					this.campionato.add(s);
					return true;
				}
			}
			
		}
	}
	
	/* Implementazione alternativa
	public boolean addPlayer(Calciatore c, Squadra s)
	{
		if(! this.campionato.contains(s)) return false;
		else
		{
			for(int i=0; i<this.campionato.size();i++)
			{
				if(this.campionato.get(i).equals(s))
				{
					if(this.campionato.get(i).getRosa().contains(c)) return false;
					else
					{
						if(this.campionato.get(i).getRosa().stream().filter(p->p.getNumMaglia() == c.getNumMaglia()).count() > 0) 
							throw new NumberNotAvailableException();
						else
						{
							this.campionato.get(i).getRosa().add(c);
							return true;
						}
					}
				}
			}
			
			return false;
		}
	}
	*/
	
	public boolean squadraSubscription(Squadra s) throws SquadraRegisteredException
	{
		if(this.campionato.contains(s)) throw new SquadraRegisteredException();
		else
		{
			this.campionato.add(s);
			return true;
		}
	}
	
	public Squadra searchBySquadra(String nomeSquadra)
	{
		Squadra app = null;
		Stream<Squadra> sapp = this.campionato.stream().filter(s -> s.getNomeSquadra().equalsIgnoreCase(nomeSquadra));
		
		Optional<Squadra> oapp = sapp.findFirst();
		if(oapp.isPresent()) app = oapp.get();
		
		return app;
	}
	
	/*
	public Squadra searchBySquadra(String nomeSquadra)
	{
		return this.campionato.stream().filter(s -> s.getNomeSquadra().equalsIgnoreCase(nomeSquadra)).findFirst().orElse(null);
	}*/
	
	public void printSquadraByScudetti()
	{
		Comparator<Squadra> squadra = Comparator.comparing(Squadra::getNumScudetti);
		this.campionato.stream().sorted(squadra.reversed()).forEach(System.out::println);
	}
	
	/*va aggiunto il reverse
	public void printSquadraByScudetti()
	{
		this.campionato.stream().sorted((s1,s2) -> (Squadra.compareByScudetti(s1,s2))).forEach(System.out::println);
	}*/
	
	public void printAllPlayerByCondition(Predicate<Calciatore> pred,Consumer<Calciatore> cons)
	{
		this.campionato.stream().forEach(s -> s.printPlayerByCond(pred, cons));
	}
}
