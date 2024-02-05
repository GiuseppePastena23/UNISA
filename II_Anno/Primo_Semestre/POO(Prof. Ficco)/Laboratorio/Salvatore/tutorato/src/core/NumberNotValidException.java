package core;

public class NumberNotValidException extends RuntimeException
{
    public NumberNotValidException()
    {
        super("Numero maglia non compreso tra 1 e 99");
    }
}