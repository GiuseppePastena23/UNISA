package università;

public class Studente_DSA extends Studente
{   
    private String DSA;
    public Studente_DSA(String Nome, String Cognome, String Datnas, String Codfis, String DSA)
    {
        super(Nome, Cognome, Datnas, Codfis);
        this.DSA = DSA;
    }

    public String getDSA(){return DSA;}
    public void setDSA(String DSA){this.DSA = DSA;}

    @Override
    public String toString()
    {
        return 
        (
            "Studente:\n" +
            "Nome= " + getNome() + "\n" +
            "Cognome= " + getCognome() + "\n" +
            "Datnas= " + getDatnas() + "\n" +
            "Codfis= " + getCodfis() + "\n" +
            "Dsa= " + getDSA() + "\n"
        );
    }
}