package gestioneterreno;
public class terreno
{
    private String codice;
    private double estensione;
    private int percentualeedificabile;
    private double renditamq;
    
    public terreno(String codice, double estensione, int percentualeedificabile, double renditamq)
    {
	this.codice=codice;
	this.estensione=estensione;
	this.percentualeedificabile=percentualeedificabile;
	this.renditamq=renditamq;
    }

    public String getCodice()
    {
        return codice;
    }

    public double getEstensione()
    {
        return estensione;
    }

    public int getPercentualeedificabile()
    {
        return percentualeedificabile;
    }

    public double getRenditamq()
    {
        return renditamq;
    }

    public void setCodice(String codice)
    {
        this.codice=codice;
    }

    public void setEstensione(int estensione)
    {
        this.estensione=estensione;
    }

    public void setPercentualeedificabile(int percentualeedificabile)
    {
        this.percentualeedificabile=percentualeedificabile;
    }

    public void setRenditamq(double renditamq)
    {
        this.renditamq=renditamq;
    }

    public double rendita()
    {
	return this.renditamq*this.estensione;
    }

    public double edificabile()
    {
	return this.estensione*this.percentualeedificabile/100;
    }

    @Override
    public String toString()
    {
	return "Terreno (codice: " + codice + " - estensione: " + estensione + " - percentuale edificabile: " + percentualeedificabile + " - renditamq: " + renditamq + ")";
    }
}