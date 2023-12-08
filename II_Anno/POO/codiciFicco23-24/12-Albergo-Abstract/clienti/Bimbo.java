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
public class Bimbo extends Cliente {
Cliente padre;
Cliente madre;
	/**
	 * @param n
	 * @param c
	 */
	public Bimbo(String n, String c, Cliente m, Cliente p) {
		super(n, c);
		madre=m;
		padre=p;

		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		// TODO Auto-generated method stub
		return "Nome:"+nome+" Cognome:"+cognome+"\n figlio di: "+padre.toString()+madre.toString();
	}

}
