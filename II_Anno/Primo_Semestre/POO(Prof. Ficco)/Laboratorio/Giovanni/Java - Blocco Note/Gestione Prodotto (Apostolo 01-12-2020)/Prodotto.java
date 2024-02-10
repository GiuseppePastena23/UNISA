package gestioneprodotto;
public class prodotto 
{
    private int codi, vend;
    private float prez;
    private String desc;

    public prodotto(int cod, float pre, int ven, String des)
    {
        this.codi=cod;
	this.prez=pre;
	this.vend=ven;
        this.desc=des;
    }

    public String getDesc() 
    {
       	return desc;
    }

    public int getCodi() 
    {
	return codi;
    }

    public float getPrez() 
    {
	return prez;
    }

    public int getVend() 
    {
	return vend;
    }

    public void setDesc(String des)
    {
	this.desc=des;
    }

    public void setVend(int ven)
    {
	this.vend=ven;
    }

    public void setPrez(int pre)
    {
	this.prez=pre;
    }

    public void setCodi(int cod)
    {
	this.codi=cod;
    }

    @Override
    public String toString()
    {
	return "prodotto(" + "codice " + codi + ", prezzo " + prez + ", prezzi venduti " + vend + ", descrizione " + desc + ")";
    }
	
    public void Sconto(int sco)
    {
	this.prez = this.prez - (this.prez/100*sco);
    }
	
    public float Guadagno()
    {
	return this.vend*this.prez;
    }
    
    public void Aggiungi(int agg)
    {
        this.vend=this.vend+agg;
    }       
}