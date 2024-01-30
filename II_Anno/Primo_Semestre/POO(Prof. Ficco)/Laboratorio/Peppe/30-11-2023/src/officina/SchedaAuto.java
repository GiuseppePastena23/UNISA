package officina;

public class SchedaAuto{

	private String targa;
	private String modello;
	private static int id;
	protected enum statoVeicolo{
		Riparazione,
		Riparato,
		Consegnato;
	}
	private statoVeicolo stato;
	private String dataArrivo;

	public SchedaAuto(String targa, String modello, String dataArrivo)
	{
		this.targa = targa;
		this.modello = modello;
		this.dataArrivo = dataArrivo;
		this.stato = statoVeicolo.Riparazione;
		id++;
	}

	public SchedaAuto(int id, String targa, String modello, String dataArrivo, statoVeicolo stato)
	{
		this.targa = targa;
		this.modello = modello;
		this.dataArrivo = dataArrivo;
		this.stato = stato
		this.id = id;
	}

	public statoVeicolo getStato(){
		return this.stato;
	}

	public String getTarga(){
		return this.targa;
	}

	public String getModello(){
		return this.modello;
	}

	public String getDataArrivo(){
		return this.dataArrivo;	
	}

	public int getId()
	{
		return this.id;
	}
	
	@Override
	public String toString(){
		return "Scheda Auto n." + this.id + " Targa: " + this.targa + " Modello: " + this.modello + " Data Arrivo: " + this.dataArrivo + " Stato Veicolo: " + this.stato;
	}
}
