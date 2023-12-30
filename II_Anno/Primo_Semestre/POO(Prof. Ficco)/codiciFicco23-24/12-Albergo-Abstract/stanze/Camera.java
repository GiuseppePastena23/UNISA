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
import clienti.*;
import java.util.Vector;

public abstract class Camera {
	public final int LIBERA=1;
	public final int SPORCA=2;
	public final int OCCUPATA=7;
	public final int PULITA=4;

	private  int stato=LIBERA;
	private int tariffa=60;
	protected Vector c; //Lista clienti
	final int posti;

	public Camera(int x){
		posti=x;
		c=new Vector();
	}

	public int getStato(){return stato;}
	public void setStato(int s){stato=s;}
	public int getTarffa(){return tariffa;}
	public void setTariffa(int t){tariffa=t;}

	public final void addCliente(Cliente cliente)
	{
		c.addElement(cliente);
	}

	public abstract void pulisci();
	public abstract String optional();
	public abstract String categoria();

	public Vector getClienti(){return c;};
	public void occupa(){stato=OCCUPATA;}
	public void libera(){stato=LIBERA+SPORCA;}

}
