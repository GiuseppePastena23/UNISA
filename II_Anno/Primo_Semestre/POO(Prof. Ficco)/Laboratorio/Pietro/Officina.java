import java.util.ArrayList;

public class Officina {
	private ArrayList <SchedaAuto> listaSchede;
	private int schedeTotali;
	//Costruttore
	public Officina() {
		listaSchede = new ArrayList <SchedaAuto> ();
		schedeTotali = 0;
	}
	//Aggiunta e rimozione schede
	public void aggiungiScheda(SchedaAuto s) {
		listaSchede.add(s);
		schedeTotali++;
	}
	public void rimuoviScheda(SchedaAuto s) {
		listaSchede.remove(s);
	}
	//Stampe del numero dei veicoli
	public void veicoliAttuali() {
		System.out.println("Sono attualmente presenti in officina " + listaSchede.size() + " veicoli");
	}
	public void veicoliTotali() {
		System.out.println("Hanno attraversato l'officina " + schedeTotali + " veicoli");
	}
}