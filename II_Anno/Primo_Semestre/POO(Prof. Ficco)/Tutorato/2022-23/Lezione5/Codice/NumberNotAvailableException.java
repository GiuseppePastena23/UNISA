package exception;

public class NumberNotAvailableException extends RuntimeException 
{

	public NumberNotAvailableException() {
		super("Numero non disponibile!");
		// Il numero è stato già preso da un altro giocatore.
	}

	public NumberNotAvailableException(String message) {
		super(message);
		// Il numero di maglia è stato ritirato.
	}
	
}
