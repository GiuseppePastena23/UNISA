package exception;

public class NumberNotValidException extends RuntimeException 
{

	public NumberNotValidException() {
		super("Numero non compreso tra [0,99]");
		// TODO Auto-generated constructor stub
	}

	public NumberNotValidException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
