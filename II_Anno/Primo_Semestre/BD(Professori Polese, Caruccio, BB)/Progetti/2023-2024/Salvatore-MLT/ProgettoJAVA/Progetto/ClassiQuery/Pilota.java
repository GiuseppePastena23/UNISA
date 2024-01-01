package Progetto.ClassiQuery;

import java.time.LocalDate;

public class Pilota 
{
    private String nome;
    private String cognome;
    private String ssid;
    private LocalDate datnas;
    private String nazionalita;
    private String nomesquadra;

    public Pilota(String nome, String cognome, String ssid, LocalDate datnas, String nazionalita, String nomesquadra)
    {
        this.nome = nome;
        this.cognome = cognome;
        this.ssid = ssid;
        this.datnas = datnas;
        this.nazionalita = nazionalita;
        this.nomesquadra = nomesquadra;
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
    
    public LocalDate getDatnas() {
        return datnas;
    }
    
    public void setDatnas(LocalDate datnas) {
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
            '}'
        );
    }

}
