package GestioneDVD;
public class Attore implements Comparable
{
    private String nome;
    private String cogn;
    private String nazi;
    private int nasc;

    public Attore (String nome, String cogn, String nazi, int nasc) 
    {
        this.nome = nome;
        this.cogn = cogn;
        this.nazi = nazi;
        this.nasc = nasc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCogn() {
        return cogn;
    }

    public void setCogn(String cogn) {
        this.cogn = cogn;
    }

    public String getNazi() {
        return nazi;
    }

    public void setNazi(String nazi) {
        this.nazi = nazi;
    }

    public int getNasc() {
        return nasc;
    }

    public void setNasc(int nasc) {
        this.nasc = nasc;
    }

    @Override
    public String toString() {
        return "Attore{" + "nome=" + nome + ", cogn=" + cogn + ", nazi=" + nazi + ", nasc=" + nasc + '}';
    }
    
    public String equals(Attore a)
    {
        if(a.nome.equals(this.nome) && a.cogn.equals(this.cogn) && a.nasc == this.nasc && a.nazi.equals(this.nazi))
            return "Gli attori sono uguali";
        else
            return "Gli attori non sono uguali";        
    }
    
    @Override
    public String compareTo(Attore a)
    {
        if(a.cogn.compareTo(this.cogn)>0)
            return "Il primo precede il secondo";
        else if(a.cogn.compareTo(this.cogn)==0)
            {
            if(a.nome.compareTo(this.nome)>0)
                return "Il primo precede il secondo";
            }
        else if(a.cogn.compareTo(this.cogn)== 0 && a.nome.compareTo(this.nome)== 0)
        {
            if(a.nasc < this.nasc)
                return "Il primo precede il secondo";
        }
        return "Il secondo precede il primo";
    }
}