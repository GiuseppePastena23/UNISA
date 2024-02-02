package test;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import core.ListaPacchiNatale;
import core.Pacco;

//4 Punti (Classi Pacco + Test)
public class Test 
{

	public static void main(String[] args) 
	{
		Pacco p1 = new Pacco("Pista automobili",new GregorianCalendar(2022,GregorianCalendar.DECEMBER,21),Pacco.GRANDE);
		Pacco p2 = new Pacco("Costruzioni Lego",new GregorianCalendar(2022,GregorianCalendar.DECEMBER,20),Pacco.PICCOLO);
		Pacco p3 = new Pacco("Castello da giardino",new GregorianCalendar(2022,GregorianCalendar.DECEMBER,24,8,0),Pacco.GRANDE);
		Pacco p4 = new Pacco("PlayStation", new GregorianCalendar(2022,GregorianCalendar.DECEMBER,22),Pacco.MEDIO);
		
		GregorianCalendar dataCreazione = new GregorianCalendar(2022,GregorianCalendar.DECEMBER,20);
		GregorianCalendar dataConsegna = new GregorianCalendar(2022,GregorianCalendar.DECEMBER,24,23,59);
		
		ListaPacchiNatale m = new ListaPacchiNatale(dataCreazione,dataConsegna);
		if(m.Aggiungi(p1)) System.out.println("Pacco Aggiunto!");
		else System.out.println("Pacco NON Aggiunto!");
		
		if(m.Aggiungi(p2)) System.out.println("\n\nPacco Aggiunto!");
		else System.out.println("\n\nPacco NON Aggiunto!");
		
		if(m.Aggiungi(p3)) System.out.println("\n\nPacco Aggiunto!");
		else System.out.println("\n\nPacco NON Aggiunto!");
		
		if(m.Aggiungi(p4)) System.out.println("\n\nPacco Aggiunto!");
		else System.out.println("\n\nPacco NON Aggiunto!");
		
		System.out.println("\n\nNumero pacchi inseriti: " + m.getNumPacchiInseriti() + "\n\n");
		for(Pacco p : m.getListaPacchi()) System.out.println(p);
		
		if(m.Modifica(new GregorianCalendar(2022,GregorianCalendar.DECEMBER,19))) System.out.println("\n\nData modificata!"); //Data di ieri
		else System.out.println("\n\nData NON modificata!");
		
		Pacco p5 = new Pacco("Bambola", new GregorianCalendar(2022,GregorianCalendar.DECEMBER,24),Pacco.MEDIO);
		if(m.Rimuovi(p5)) System.out.println("\n\nPacco Rimosso!");
		else System.out.println("\n\nPacco NON Rimosso!");
		
		if(m.Aggiungi(p5)) System.out.println("\n\nPacco Aggiunto!");
		else System.out.println("\n\nPacco NON Aggiunto!");
		
		if(m.Rimuovi(p5)) System.out.println("\n\nPacco Rimosso!");
		else System.out.println("\n\nPacco NON Rimosso!");
		
		System.out.println("\n\nNumero pacchi inseriti: " + m.getNumPacchiInseriti() + "\n\n");
		for(Pacco p : m.getListaPacchi()) System.out.println(p);
		
		m.saveListaToFile("lista_pacchi.txt");
		System.out.println("\n\nPacchi salvati su file!");
		
		System.out.println("\n\nStampa ordinata (crescente) dei pacchi in base alla data con espressione lambda\n");
		
		List<Pacco> listaPacchi = m.getListaPacchi();
		Pacco[] listaPacchiArray = listaPacchi.toArray(new Pacco[listaPacchi.size()]);
		
		Arrays.sort(listaPacchiArray, (a, b) -> {return Pacco.compareByDataArrivo(a,b);});
		
		for(Pacco p : listaPacchiArray) System.out.println(p);
		
		
		System.out.println("\n\nStampa delle date di arrivo dei pacchi GRANDI (tipologia=2) con espressione lambda\n");
		ListaPacchiNatale.printDataLambda(listaPacchi, p->p.getTipologia() == p.GRANDE, p-> System.out.println(p.formatData()));
	}

}
