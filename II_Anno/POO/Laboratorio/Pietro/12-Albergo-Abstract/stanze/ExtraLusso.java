/*
 * Created on 15-dic-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package stanze;

/**
 * @author
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ExtraLusso extends Camera {
String frigo="Pieno";
String condizionatore="Spento";

	/**
	 * @param x
	 */
	public ExtraLusso(int x) {
		super(x);
		setTariffa(200);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see stanze.Camera#pulisci()
	 */
	public void pulisci() {
		// TODO Auto-generated method stub
		setStato(PULITA);
		frigo="Pieno";
		condizionatore="Spento";

	}

	/* (non-Javadoc)
	 * @see stanze.Camera#optional()
	 */
	public String optional() {
		// TODO Auto-generated method stub
		return "Condizionatore, Frigo, Televisore, Terrazzo, Idromassaggio";
	}

	/* (non-Javadoc)
	 * @see stanze.Camera#categoria()
	 */
	public String categoria() {
		// TODO Auto-generated method stub
		return "Extralusso";
	}

	public void occupa()
	{
		super.occupa();
		frigo="Vuoto";
		condizionatore="Acceso";
	}
}
