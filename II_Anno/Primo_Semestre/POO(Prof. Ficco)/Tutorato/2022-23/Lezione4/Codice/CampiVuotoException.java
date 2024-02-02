package exception;

public class CampiVuotoException extends RuntimeException 
{

	public CampiVuotoException() {
		super("Uno o più campi vuoti!");
		// TODO Auto-generated constructor stub
	}

	public CampiVuotoException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
