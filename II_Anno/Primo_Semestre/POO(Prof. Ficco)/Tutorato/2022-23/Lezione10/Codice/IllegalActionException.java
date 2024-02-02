package core;

public class IllegalActionException extends Exception 
{

	public IllegalActionException() {
		super("Operazione non consentita");
	}

	public IllegalActionException(String message) {
		super(message);
	}
	
}
