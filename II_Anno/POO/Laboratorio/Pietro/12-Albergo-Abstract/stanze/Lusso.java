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
public class Lusso extends Camera {

	/**
	 * @param x
	 */
	public Lusso(int x) {
		super(x);
		setTariffa(100);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see stanze.Camera#pulisci()
	 */
	public void pulisci() {
		// TODO Auto-generated method stub
    setStato(PULITA);
	}

	/* (non-Javadoc)
	 * @see stanze.Camera#optional()
	 */
	public String optional() {
		// TODO Auto-generated method stub
		return "Frigo, Tele";
	}

	/* (non-Javadoc)
	 * @see stanze.Camera#categoria()
	 */
	public String categoria() {
		// TODO Auto-generated method stub
		return "Lusso";
	}

}
