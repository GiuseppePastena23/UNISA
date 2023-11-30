package università;

import java.util.ArrayList;

public class Studente
{
    private String Nome;
    private String Cognome;
    private String Datnas;
    private String Codfis;
    private List<Esame> Esami_superati = new ArrayList<>();

    //costruttore
    public studente(String Nome, String Cognome, String Datnas, String Codfis)
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

    public Esame getEsami_superati(){return Esami_superati;}
    public Esame getEsame_superato(int pos)
    {
        if(pos >= 0 && pos < Esami_superati.size())
        {
            return Esami_superati.get(pos);
        }
        else{java.out.println("Errore indice");}
    }

    //setter
    public void setNome(String Nome){this.Nome = Nome;}
    public void setCognome(String Cognome){this.Cognome = Cognome;}
    public void setDatnas(String Datnas){this.Datnas = Datnas;}
    public void setCodfis(String Codfis){this.Codfis = Codfis;}

    //aggiungi un esame superato
    public void set_Esami_superati(Esame esame_superato){Esami_superati.add(esame_superato);}
    public void setEsame_superato(Esame esame_superato, int pos)
    {
        if(pos >= 0 && pos < Esami_superati.size())
        {
            Esami_superati.set(pos, esame_superato);
        }
        else{java.out.println("Errore indice");}
    }
}