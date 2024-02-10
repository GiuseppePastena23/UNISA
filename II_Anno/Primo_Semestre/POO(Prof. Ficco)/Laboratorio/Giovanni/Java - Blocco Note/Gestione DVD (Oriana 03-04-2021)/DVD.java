package GestioneDVD;
import java.util.ArrayList;
public class DVD 
{
    private String tito;
    private String regi;
    private int prod;
    ArrayList <Attore> att = new ArrayList <>();

    public DVD(String tito, String regi, int prod) 
    {
        this.tito = tito;
        this.regi = regi;
        this.prod = prod;
    }

    public String getTito() {
        return tito;
    }

    public void setTito(String tito) {
        this.tito = tito;
    }

    public String getRegi() {
        return regi;
    }

    public void setRegi(String regi) {
        this.regi = regi;
    }

    public int getProd() {
        return prod;
    }

    public void setProd(int prod) {
        this.prod = prod;
    }

    public ArrayList<Attore> getAtt() {
        return att;
    }

    public void setAtt(ArrayList<Attore> att) {
        this.att = att;
    }

    @Override
    public String toString() {
        return "DVD{" + "tito=" + tito + ", regi=" + regi + ", prod=" + prod + ", att=" + att + '}';
    }
    
    public String equals(DVD d)
    {
        if(d.tito.equals(this.tito) && d.prod == this.prod)
            return "I dvd sono uguali";
        else
            return "I dvd sono uguali";        
    }
    
    public void aggiungi(Attore a)
    {
        this.att.add(a);
    }
    
    public String attore(String nomecogn)
    {
        Attore conc;
        String con;
        int cont=0;
        for(int i=0;i<this.att.size();i++)
        {
            conc = att.get(i);
            con = conc.getNome() + " " + conc.getCogn();
            if(nomecogn.equals(con))
                cont++;
        }
        return "Ci stanno " +cont+ " attori"; 
    }
    
    public ArrayList<Attore> attori(String nazione)
    {
        ArrayList <Attore> a = new ArrayList <> ();
        Attore conc;
        String con;
        for(int i=0;i<this.att.size();i++)
        {
            conc = att.get(i);
            con = conc.getNazi();
            if(nazione.equals(con))
                a.add(att.get(i));
        }
        return a;
    }
    
    public int film(String nomecogn)
    {
        Attore conc;
        String con;
        for(int i=0;i<this.att.size();i++)
        {
            conc = att.get(i);
            con = conc.getNome() + " " + conc.getCogn();
            if(nomecogn.equals(con))
                return i;
        }
        return -1;
    }
}