package core;

public interface TransActions {
    int PREZZOFISSO = 10;

    boolean checkTicket(Ticket t);
    Ticket buyTicket(int money) throws NotEnoughMoneyException;
}
