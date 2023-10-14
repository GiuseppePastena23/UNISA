package gestione_fatture;
public class fatture
{
    private int numero;
    private double importo;
    private int deg;
    private int dem;
    private int dpg;
    private int dpm;

    public fatture(int numero, double importo, int deg, int dem, int dpg, int dpm)
    {
	this.numero=numero;
	this.importo=importo;
	this.deg=deg;
	this.dem=dem;
	this.dpg=dpg;
	this.dpm=dpm;
    }

    public double ammontare(int gg, int mm)
    {
	if(gg==deg && mm==dem)
	    return importo;
	else
	    return 0;
    }

    public void numeroGiorni(int gg, int mm, int gmm)
    {
	System.out.println("Al pagamento mancano:");
        if(mm==this.dpm)
            System.out.println((this.dpg-gg)+" Giorni");
        else
            if(mm<this.dpm)
                System.out.println((gmm-gg+this.dpg)+" Giorni");
    }

    public double getImporto() 
    {
        return importo;
    }

    
    
    @Override
    public String toString() 
    {
        return "fatture{" + "numero=" + numero + ", importo=" + importo + ", deg=" + deg + ", dem=" + dem + ", dpg=" + dpg + ", dpm=" + dpm + '}';
    }  
}