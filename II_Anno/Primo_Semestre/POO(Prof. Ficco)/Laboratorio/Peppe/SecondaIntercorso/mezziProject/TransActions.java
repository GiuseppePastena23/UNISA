package core.mezzi;

public interface TransActions{

    boolean checkTicket(Ticket t);
    Ticket buyTicket(int money) throws NoMoneyException;
}