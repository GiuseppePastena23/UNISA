package universita;

import java.util.ArrayList;
import java.util.List;

public class Studente
{
    private String Nome;
    private String Cognome;
    private String Datnas;
    private String Codfis;
    private List<Esame> Esami_superati = new ArrayList<>();

    //costruttore
    public Studente(String Nome, String Cognome, String Datnas, String Codfis)
    {
        this.Nome = Nome;
        this.Cognome = Cognome;
        this.Datnas = Datnas;
        this.Codfis = Codfis;
    }

    //getter
    public String getNome(){return Nome;}
    public String getCognome(){return Cognome;}
    public String getDatnas(){return Datnas;}
    public String getCodfis(){return Codfis;}

    public List<Esame> getEsamiSuperati(){return Esami_superati;}
    public Esame getEsameSuperatoPos(int pos)
    {
        if(pos >= 0 && pos < Esami_superati.size())
        {
            return Esami_superati.get(pos);
        }
        else
        {
            System.out.println("Errore indice");
            return null;
        }
    }

    //setter
    public void setNome(String Nome){this.Nome = Nome;}
    public void setCognome(String Cognome){this.Cognome = Cognome;}
    public void setDatnas(String Datnas){this.Datnas = Datnas;}
    public void setCodfis(String Codfis){this.Codfis = Codfis;}

    //aggiungi un esame superato
    public void setEsameSuperato(Esame esame_superato)
    {
        Esami_superati.add(esame_superato);
    }

    //aggiungi esame superato in pos definita
    public void setEsameSuperatoPOS(Esame esame_superato, int pos)
    {
        if(pos >= 0 && pos < Esami_superati.size())
        {
            Esami_superati.set(pos, esame_superato);
        }
        else{System.out.println("Errore indice");}
    }

    @Override
    public String toString()
    {
        return 
        (
            "Studente:\n" +
            "Nome= " + getNome() + "\n" +
            "Cognome= " + getCognome() + "\n" +
            "Datnas='" + getDatnas() + "\n" +
            "Codfis='" + getCodfis() + "\n"
        );
    }
}