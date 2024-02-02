package eccezioni;

public class PositionException extends Exception 
{

	public PositionException() 
	{
		super("Posizione errata!");
	}

	public PositionException(String message) 
	{
		super(message);
	}
	
}
