package core;

public class NumberNotAvaiableException extends RuntimeException
{
    public NumberNotAvaiableException()
    {
        super("Numero non disponibile, preso già da un altro giocatore");
    }
}