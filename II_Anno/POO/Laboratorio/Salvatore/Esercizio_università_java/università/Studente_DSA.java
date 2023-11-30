package università;

import java.util.ArrayList;

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
}