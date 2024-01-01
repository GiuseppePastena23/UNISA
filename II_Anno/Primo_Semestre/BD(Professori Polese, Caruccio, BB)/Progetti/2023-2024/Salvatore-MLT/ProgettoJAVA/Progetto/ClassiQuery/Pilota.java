package Progetto.ClassiQuery;

import java.sql.Date;

public class Pilota 
{
    private String nome;
    private String cognome;
    private String ssid;
    private Date datnas;
    private String nazionalita;
    private String nomesquadra;
    private Date PrimaLicenza;
    private int NLicenze;
    private int NFinanziamenti;
    private double SommaFinanziamenti;

    public Pilota(String nome, String cognome, String ssid, Date datnas, String nazionalita, String nomesquadra, Date primaLicenza, int nLicenze, int nFinanziamenti, double SommaFinanziamenti)
    {
        this.nome = nome;
        this.cognome = cognome;
        this.ssid = ssid;
        this.datnas = datnas;
        this.nazionalita = nazionalita;
        this.nomesquadra = nomesquadra;
        PrimaLicenza = primaLicenza;
        NLicenze = nLicenze;
        NFinanziamenti = nFinanziamenti;
    }

    public Pilota(String nome, String cognome, String ssid, Date datnas, String nazionalita, Date primaLicenza)
    {
        this.nome = nome;
        this.cognome = cognome;
        this.ssid = ssid;
        this.datnas = datnas;
        this.nazionalita = nazionalita;
        PrimaLicenza = primaLicenza;
    }

    public Pilota(String nome, String cognome, String ssid, Date datnas, String nazionalita, Date primaLicenza, int nFinanziamenti, double SommaFinanziamenti)
    {
        this.nome = nome;
        this.cognome = cognome;
        this.ssid = ssid;
        this.datnas = datnas;
        this.nazionalita = nazionalita;
        PrimaLicenza = primaLicenza;
        NFinanziamenti = nFinanziamenti;
    }

    public Pilota(String nome, String cognome, String ssid, Date datnas, String nazionalita, int nLicenze)
    {
        this.nome = nome;
        this.cognome = cognome;
        this.ssid = ssid;
        this.datnas = datnas;
        this.nazionalita = nazionalita;
        NLicenze = nLicenze;
    }
    
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCognome() {
        return cognome;
    }
    
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    
    public String getSsid() {
        return ssid;
    }
    
    public void setSsid(String ssid) {
        this.ssid = ssid;
    }
    
    public Date getDatnas() {
        return datnas;
    }
    
    public void setDatnas(Date datnas) {
        this.datnas = datnas;
    }
    
    public String getNazionalita() {
        return nazionalita;
    }
    
    public void setNazionalita(String nazionalita) {
        this.nazionalita = nazionalita;
    }
    
    public String getNomesquadra() {
        return nomesquadra;
    }
    
    public void setNomesquadra(String nomesquadra) {
        this.nomesquadra = nomesquadra;
    }

    public Date getPrimaLicenza()
    {
        return PrimaLicenza;
    }

    public void setPrimaLicenza(Date licenza)
    {
        PrimaLicenza = licenza;
    }

    public int getNLicenze()
    {
        return NLicenze;
    }

    public void setNLicenze(int nLicenze)
    {
        NLicenze = nLicenze;
    }

    public int getNFinanziamenti()
    {
        return NFinanziamenti;
    }

    public void setNFinanziamenti(int Nfinanziamenti)
    {
        NFinanziamenti = Nfinanziamenti;
    }

    public double getSommaFinanziamenti() {
        return SommaFinanziamenti;
    }

    public void setSommaFinanziamenti(double sommaFinanziamenti) {
        SommaFinanziamenti = sommaFinanziamenti;
    }

    @Override
    public String toString() 
    {
        return 
        (
            "Pilota{" +
            "nome='" + nome + '\'' +
            ", cognome='" + cognome + '\'' +
            ", ssid='" + ssid + '\'' +
            ", datnas=" + datnas +
            ", nazionalita='" + nazionalita + '\'' +
            ", nomesquadra='" + nomesquadra + '\'' +
            ", Prima licenza='" + PrimaLicenza + '\'' +
            ", NLicenze='" + NLicenze + '\'' +
            ", NFinaziamenti='" + NFinanziamenti + '\'' +
            '}'
        );
    }

}
