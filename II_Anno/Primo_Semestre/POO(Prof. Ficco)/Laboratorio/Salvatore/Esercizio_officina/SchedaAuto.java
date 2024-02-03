package dependency

public class SchedaAuto
{
	private enum StatoVeicolo{riparando, riparato, consegnato};
	private String DataArrivo;
	private Auto auto;
	private static int NumeroProgressivoScheda = 0;
	
	StatoVeicolo statoVeicolo = riparando;
    
    public SchedaAuto(String DataArrivo, String Targa, String Modello)
    {
    	++NumeroProgressivoScheda;
    	this.DataArrivo = DataArrivo;
    	this.auto = new Auto(Targa, Modello);
    }
    
    public String getDataArrivo(){return DataArrivo;}
    public StatoVeicolo getstatoVeicolo(){return statoVeicolo;}
    public getNumeroProgressivoScheda(){return NumeroProgressivoScheda;}
    
    @Override 
    public String ToString()
    {
    	return(Targa, Modello, DataArrivo, NumeroProgressivoScheda)
    }
	
	private class Auto
	{
		private String Targa;
		private String Modello;
		
		public Auto(String Targa, String Modello)
		{
			this.Targa = Targa;
			this.Modello = Modello;
		}
		
		public String getTarga(){return Targa;}
		public String getModello(){return Modello;}
		
		public void setTarga(String Targa){this.Targa = Targa;}
		public void setModello(String Modello){this.Modello = Modello;}
	}
}
