package core;

public class SquadraRegisteredException extends Exception
{
    public SquadraRegisteredException()
    {
        super("Squadra già iscritta al campionato");
    }
}