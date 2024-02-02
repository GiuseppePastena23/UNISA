package core;

public interface TransActions 
{
	boolean checkTicket(Ticket t);
	Ticket buyTicket(int money) throws IllegalActionException;
}
