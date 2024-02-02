package test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import core.Lottatore;
import core.LottatoreVolante;
import core.Mago;
import core.Player;

public class Test {

	public static void main(String[] args) 
	{
		//Esercizio 1

		ArrayList<Player> players = new ArrayList<Player>();

		Lottatore p1 = new Lottatore(100,100,50);
		Lottatore p2 = new Lottatore(100,150,50);
		Lottatore p3 = new Lottatore(100,100,100);

		Mago p4 = new Mago(100,50,100);
		Mago p5 = new Mago(100,50,50);
		Mago p6 = new Mago(100,50,150);

		players.add(p1);
		players.add(p2);
		players.add(p3);
		players.add(p4);
		players.add(p5);
		players.add(p6);

		System.out.println("Stampa delle info di tutti i Players\n\n");
		printInfo(players);

		System.out.println("\n\nStampa delle info di tutti i Players con attacco e difesa >= 100\n\n");

		Predicate<Player> pred = p -> p.getAttacco() >= 100 && p.getDifesa() >= 100;

		printInfoByCond(players,pred);

		System.out.println("\n\nStampa delle info di tutti i Players con punti vita >= difesa\n\n");
		pred = p -> p.getPuntiVita() >= p.getDifesa();

		printInfoByCond(players,pred);

		System.out.println("\n\nStampa delle info di tutti i Maghi\n\n");
		printInfoByClass(players,Mago.class);

		System.out.println("\n\nStampa delle info di tutti i Lottatori\n\n");
		printInfoByClass(players,Lottatore.class);

		System.out.println("\n\nStampa dei soli attacchi di tutti i Players\n\n");
		printAttacks(players);
		
		/*Soluzione equivalente 
		 *
		 *         System.out.println("Stampa delle info di tutti i Player");
        printInfo(playerList, p -> true, Player::toString);
        System.out.println();

        System.out.println("Stampa delle info di tutti i Player con attacco e difesa >= 100 (o di una soglia K)");
        printInfo(playerList, p -> p.getAttacco() >= 100 && p.getDifesa() >= 100, Player::toString);
        System.out.println();

        System.out.println("Stampa delle info di tutti i Player con punti vita >= difesa");
        printInfo(playerList, p -> p.getPuntiVita() >= p.getDifesa(), Player::toString);
        System.out.println();

        System.out.println("Stampa delle info di tutti e soli i Maghi");
        printInfo(playerList, p -> p instanceof Mago, Player::toString);
        System.out.println();

        System.out.println("Stampa delle info di tutti e soli i Lottatori");
        printInfo(playerList, p -> p instanceof Lottatore, Player::toString);
        System.out.println();

        System.out.println("Stampa dei soli valori d’attacco di tutti i Player");
        printInfo(playerList, p -> true, p -> String.valueOf(p.getAttacco()));
        System.out.println();
        */

		//Esercizio 2

		LottatoreVolante l1 = new LottatoreVolante(100,200,100);
		LottatoreVolante l2 = new LottatoreVolante(100,100,100);

		players.add(l1);
		players.add(l2);
	}

	public static void printInfo(ArrayList<Player> players)
	{
		players.stream().forEach(System.out::println);
	}

	public static void printInfoByCond(ArrayList<Player> players,Predicate<Player> pred)
	{
		players.stream().filter(pred).forEach(System.out::println);
	}

	public static <T> void printInfoByClass(ArrayList<Player> players,Class<T> classe)
	{
		//classe::isInstance è l'equivalente dinamico di  p -> p instanceof Classe
		players.stream().filter(classe::isInstance).forEach(System.out::println);
	}

	public static void printAttacks(ArrayList<Player> players)
	{
		players.stream().map(Player::getAttacco).forEach(System.out::println);
	}

	//Soluzione delle operazioni equivalente
	private static <T> void printInfo(List<T> list, Predicate<T> filter, Function<T, String> map) 
	{
		list.stream().filter(filter).map(map).forEach(System.out::println);
	}
}
