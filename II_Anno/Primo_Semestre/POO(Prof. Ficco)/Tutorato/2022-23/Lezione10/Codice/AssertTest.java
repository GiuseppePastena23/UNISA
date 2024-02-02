package test;

import core.Autobus;
import core.IllegalActionException;
import core.Ticket;

public class AssertTest {

	public static void main(String[] args) throws IllegalActionException 
	{
		//aggiungete -ea alla run configuration come parametro della JVM
		Autobus a = new Autobus(20);
		System.out.println(a.buyTicket(0));

	}

}
