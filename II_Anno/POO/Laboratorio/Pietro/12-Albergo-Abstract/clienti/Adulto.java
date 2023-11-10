/*
 * Created on 15-dic-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package clienti;

/**
 * @author
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
import javax.swing.JOptionPane;

public class Adulto extends Cliente {
  String ci;
	/**
	 * @param n
	 * @param c
	 */
	public Adulto(String n, String c) {
		super(n, c);
		ci=JOptionPane.showInputDialog("Inserire CI:");

		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		// TODO Auto-generated method stub
		return "Nome:"+nome+" Cognome:"+cognome+" CI:"+ci;
	}

}
