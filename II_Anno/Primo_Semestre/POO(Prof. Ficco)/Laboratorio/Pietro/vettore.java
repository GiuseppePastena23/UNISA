/** CLASSE VETTORE DI ESEMPIO */

// COMMENT

public class Vettore{
	private int a[];
	private int dim;

	/** Costruttore di defaulf */
	public Vettore() {
		//this(5);
		a = new int[5];
		dim = 0;
	}
	/** Inizializzazione 	*/
	public Vettore(int n) {
		a = new int[n];
		dim = 0;
	}
	/** Restituisce l'elemento di posizione i	*/
	public int leggi(int i) {
		return a[i];
	}
	/** Inserisce elemento A[i] */
	public void ins(int val, int i){
		a[i] = val;
		if(dim < i + 1) 
			dim = i + 1;
	}

	public int getDim(){
		return dim;
	}

	public int getMaxDim(){
		return a.length;
	}

	public int somma(){
		int s = 0;
		for(int i = 0; i < dim; i++)
			s = s + a[i];
		return s;
	}

	public float media(){
		return (((float) somma()) / dim);
	}

	public int max(){
		int m;
		if(dim > 0)
			m = a[0];
		else 
			return 0;
		for(int i = 0; i < dim; i++)
			if(a[i] > m) 
				m =a [i];
		return m;
	}

	public int min(){
		int m;
		if(dim > 0)
			m = a[0];
		else
			return 0;
		for(int i = 0; i < dim; i++)
		  if(a[i] < m)
			  m = a[i];
		return m;
	}

	public void ordina() {
		bubblesort(a);
	}

	private void bubblesort(int v[]){
		int temp;
		for(int i = 0; i < dim - 1; i++)
			for(int j = 0; j < dim - i; j++)
				if(v[j] > v[j+1]){
					temp = v[j];
					v[j] = v[j+1];
					v[j+1] = temp;
				}
	}

	public void stampa(){
		stampa(a);
	}

	private void copia(int v[]){
		for(int i = 0; i < dim; i++)
			v[i] = a[i];
	}

	private void stampa(int v[]){
		for(int i = 0; i < dim; i++)
			System.out.println("V[" + i + "]=" + v[i]);
	}

	public void stampaOrdinata(){
		int v[] = new int[a.length];
		copia(v);
		bubblesort(v);
		stampa(v);
	}

	public boolean confronta (Vettore v){
		return confronta(v.a, v.dim);
	}

	private boolean confronta(int v[], int n){
		if(dim!=n)
			return false;
		int i = 0;
		while((a[i] == v[i]) && (i < n))
			i++;
		if(i==n)
			return true;
		else
			return false;
	}


	public void resize(int n){
		int v[];
		if(n > dim){
			v = new int[n];
			copia(v);
		    a = v;
		}
	}

	public void dIns(int val, int i){
		if(i>=a.length){
			resize(i+1);
			a[i]=val;
			dim=i+1;
		}
	}
}