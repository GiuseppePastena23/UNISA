import java.lang.Thread;

public class esempioThread extends Thread {
	private int from;
	private int to;
	public esempioThread (int from, int to) {
		this.from = from;
		this.to = to;
	}
	public void run () {
		for (int i = from; i <= to; i++)
			System.out.print(i+"\t");
	}
	
	public static void main (String args[]) {
		esempioThread p1 = new esempioThread (1,10);
		esempioThread p2 = new esempioThread (11,20);
		
		//Ordine sparso, o comunque imprevedibile
		//p1.start();
		//p2.start();
		
		//inserire un try/catch per usare join consente di imporre una sequenza
		p1.start();
		try {
			p1.join();
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		p2.start();
		try {
			p2.join();
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		System.out.println("Fine");
	}
}

/*
COSTRUTTORI:
- Thread (): crea un nuovo oggetto Thread.
- Thread (String name): crea un nuovo oggetto Thread con nome name.
- Thread (Runnable target): crea un nuovo oggetto Thread a partire dall’oggetto target.
- Thread (Runnable target, String name): crea un nuovo oggetto Thread con nome name a partire dall’oggetto target.

METODI PRINCIPALI:
- String getName(): restituisce il nome di questo Thread.
- void join() throws InterruptedException: attende fino a quando questo Thread non termina l’esecuzione del proprio metodo run.
- void join(long millis) throws InterruptedException: attende, per un tempo massimo di millis millisecondi,
	fino a quando questo Thread non termina l’esecuzione del proprio metodo run.
- void run(): specifica le operazioni svolte dal Thread. Deve essere ridefinito dalla sottoclasse, altrimenti non effettua alcuna operazione.
	Se il Thread è stato costruito a partire da un oggetto Runnable, allora verrà invocato il metodo run di tale oggetto.
- static void sleep(long millis) throws InterruptedException: determina l’interruzione dell’esecuzione del Thread corrente per un tempo di millis millisecondi.
- void start(): fa partire l’esecuzione del Thread. Viene invocato il metodo run di questo Thread.
- static void yield(): determina l’interruzione temporanea del Thread corrente, e consente ad altri Thread di essere eseguiti.
- static Thread currentThread(): restituisce un riferimento all’oggetto Thread attualmente in esecuzione.
- void setPriority(int newPriority): cambia la priorità di questo Thread.
- int getPriority(): restituisce la priorità di questo Thread.

COSTANTI:
static final int MAX_PRIORITY: la massima priorità (pari a 10) che un Thread può avere.
static final int MIN_PRIORITY: la minima priorità (pari ad 1) che un Thread può avere.
static final int NORM_PRIORITY: la priorità (pari a 5) che viene assegnata di default ad un Thread.
*/