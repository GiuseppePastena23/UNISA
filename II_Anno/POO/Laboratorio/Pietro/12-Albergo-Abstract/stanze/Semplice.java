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
public class Semplice extends Camera {

	/**
	 * @param x
	 */
	public Semplice(int x) {
		super(x);
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
		return "no optional";
	}

	/* (non-Javadoc)
	 * @see stanze.Camera#categoria()
	 */
	public String categoria() {
		// TODO Auto-generated method stub
		return "Semplice";
	}

	/* (non-Javadoc)
	 * @see stanze.Camera#getClienti()
	 */


}
