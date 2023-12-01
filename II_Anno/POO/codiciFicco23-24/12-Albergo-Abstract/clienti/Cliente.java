/*
 * Created on 15-dic-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package clienti;

/**
 * @author  *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public abstract class Cliente {
	String nome;
	String cognome;

	Cliente(String n, String c){
	    nome=n;
	    cognome=c;
	}

	public abstract String toString();
}
