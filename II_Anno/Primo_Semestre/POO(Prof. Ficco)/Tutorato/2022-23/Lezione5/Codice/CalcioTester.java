package test;

import java.util.List;

import core.Calciatore;
import core.CalcioManager;
import core.Squadra;
import exception.NumberNotAvailableException;
import exception.NumberNotValidException;
import exception.SquadraRegisteredException;

public class CalcioTester {

	public static void main(String[] args) 
	{
		CalcioManager campionato = new CalcioManager("Serie A");
		
		Squadra s1 = new Squadra("Napoli",2);
		Squadra s2 = new Squadra("Inter",18);
		Squadra s3 = new Squadra("Milan",18);
		Squadra s4 = new Squadra("Salernitana",0);
		Squadra s5 = new Squadra("Sassuolo",0);
		
		try {
			if(campionato.squadraSubscription(s1)) System.out.println("Squadra aggiunta!\n\n");
			else System.out.println("Squadra NON aggiunta!\n\n");
		} catch (SquadraRegisteredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if(campionato.squadraSubscription(s2)) System.out.println("Squadra aggiunta!\n\n");
			else System.out.println("Squadra NON aggiunta!\n\n");
		} catch (SquadraRegisteredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if(campionato.squadraSubscription(s3)) System.out.println("Squadra aggiunta!\n\n");
			else System.out.println("Squadra NON aggiunta!\n\n");
		} catch (SquadraRegisteredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if(campionato.squadraSubscription(s4)) System.out.println("Squadra aggiunta!\n\n");
			else System.out.println("Squadra NON aggiunta!\n\n");
		} catch (SquadraRegisteredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			if(campionato.squadraSubscription(s5)) System.out.println("Squadra aggiunta!\n\n");
			else System.out.println("Squadra NON aggiunta!\n\n");
		} catch (SquadraRegisteredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if(campionato.squadraSubscription(s1)) System.out.println("Squadra aggiunta!\n\n");
			else System.out.println("Squadra NON aggiunta!\n\n");
		} catch (SquadraRegisteredException e) {
			// TODO Auto-generated catch block
			System.out.println("Squadra NON aggiunta!\n\n");
		}
		
		Calciatore c1 = new Calciatore("Lautaro","Martinez","Attaccante",10);
		Calciatore c2 = new Calciatore("Frank","Ribery","Centrocampista",9);
		Calciatore c3 = new Calciatore("Olivier","Giroud","Attaccante",9);
		Calciatore c4 = new Calciatore("Davide","Frattesi","Centrocampista",20);
		Calciatore c5 = null;
		
		
		try
		{
			c5 = new Calciatore("Hirving","Lozano","Attaccante",0);
		}
		catch(NumberNotValidException e)
		{
			System.out.println(e.getMessage());
			c5 = new Calciatore("Hirving","Lozano","Attaccante",11);
		}
		
		if(campionato.addPlayer(c1, s2)) System.out.println("\n\n" + c1 + " aggiunto!\n\n");
		else System.out.println("\n\n" + c1 + " NON aggiunto!\n\n");
		
		if(campionato.addPlayer(c2, s4)) System.out.println("\n\n" + c2 + " aggiunto!\n\n");
		else System.out.println("\n\n" + c2 + " NON aggiunto!\n\n");
		
		if(campionato.addPlayer(c3, s3)) System.out.println("\n\n" + c3 + " aggiunto!\n\n");
		else System.out.println("\n\n" + c3 + " NON aggiunto!\n\n");
		
		if(campionato.addPlayer(c4, s5)) System.out.println("\n\n" + c4 + " aggiunto!\n\n");
		else System.out.println("\n\n" + c4 + " NON aggiunto!\n\n");

		if(campionato.addPlayer(c5, s1)) System.out.println("\n\n" + c5 + " aggiunto!\n\n");
		else System.out.println("\n\n" + c5 + " NON aggiunto!\n\n");
		
		Calciatore c6 = new Calciatore("Romelu","Lukaku","Attaccante",10);
		
		try
		{
			if(campionato.addPlayer(c6, s2)) System.out.println("\n\n" + c6 + " aggiunto!\n\n");
			else System.out.println("\n\n" + c6 + " NON aggiunto!\n\n");
		}
		catch(NumberNotAvailableException e)
		{
			System.out.println(e.getMessage());
			c6.setNumMaglia(99);
			if(campionato.addPlayer(c6, s2)) System.out.println("\n\n" + c6 + " aggiunto!\n\n");
			else System.out.println("\n\n" + c6 + " NON aggiunto!\n\n");
		}
		
		System.out.println("\n\nStampo le info del numero 10 della squadra: " + s2);
		campionato.getCampionato().get(4).printPlayerByCond(p -> p.getNumMaglia() == 10, p -> System.out.println(p));
		
		System.out.println("\n\nStampo le info di tutti i numeri 9 iscritti al campionato\n\n");
		campionato.printAllPlayerByCondition(p -> p.getNumMaglia() == 9, p -> System.out.println(p));
		
		System.out.println("\n\nStampo le informazioni della Salernitana\n\n");
		Squadra s6 = (Squadra) campionato.searchBySquadra("Salernitana");
		if(s6 !=  null) System.out.println(s6);
		else System.out.println("Squadra NON trovata!");
		
		System.out.println("\n\nStampo le informazioni della Roma\n\n");
		Squadra s7 = (Squadra) campionato.searchBySquadra("Roma");
		if(s7 !=  null) System.out.println(s7);
		else System.out.println("Squadra NON trovata!");
		
		System.out.println("\n\nStampo tutte le squadre ordinate in base al numero di scudetti\n\n");
		campionato.printSquadraByScudetti();
	}

}
