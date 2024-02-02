package exception;

import java.io.IOException;

public class SalvataggioControllatoException extends IOException {

	public SalvataggioControllatoException() {
		super("Salvataggio non avvenuto correttamente!");
		// TODO Auto-generated constructor stub
	}

	public SalvataggioControllatoException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
