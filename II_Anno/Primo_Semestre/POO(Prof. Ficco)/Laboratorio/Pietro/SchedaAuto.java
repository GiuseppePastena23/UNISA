public class SchedaAuto {
	private String targa;
	private String modello;
	private String status;
	//private enum status {rotto, riparato, consegnato};
	private static int numScheda = 1;
	//Costruttore
	public SchedaAuto (String targa, String modello, String status) {
		this.targa = targa;
		this.modello = modello;
		this.status = status;
		numScheda++;
	}
	//Metodi get/set
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	//Metodo toString
	/*@Override
	public String toString() {
		
	}*/
}