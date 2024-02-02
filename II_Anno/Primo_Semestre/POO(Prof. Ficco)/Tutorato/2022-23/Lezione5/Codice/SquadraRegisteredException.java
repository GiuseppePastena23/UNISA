package exception;

public class SquadraRegisteredException extends Exception 
{

	public SquadraRegisteredException() {
		super("Squadra gia' registra!");
		// TODO Auto-generated constructor stub
	}

	public SquadraRegisteredException(String message) {
		super(message);
		// Squadra registrata ma in un altro campionato.
	}
	
}
