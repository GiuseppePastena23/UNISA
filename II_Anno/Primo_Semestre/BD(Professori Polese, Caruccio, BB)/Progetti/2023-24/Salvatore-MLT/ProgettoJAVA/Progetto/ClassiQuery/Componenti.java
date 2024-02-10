package Progetto.ClassiQuery;

import java.sql.Date;

public class Componenti 
{
    public enum TipoComponente
    {
        cambio,
        telaio,
        motore;
    }

    private String id;
    private TipoComponente tipo;
    private Double costo;
    private Date dataInstallazione;
    private String nomeScuderia;
    private String nomeVettura;
    private String nomeCostruttore;
    private String materiale;
    private Integer peso;
    private Integer nMarce;
    private Integer cilindrata;
    private String tipoMotore;
    private Integer numeroCilindri;

    public Componenti(){};
    public Componenti(String id, TipoComponente tipo, double costo, Date dataInstallazione, String nomeScuderia, String nomeVettura, String nomeCostruttore, String materiale, Integer peso, Integer nMarce, Integer cilindrata, String tipoMotore, Integer numeroCilindri) {
        this.id = id;
        this.tipo = tipo;
        this.costo = costo;
        this.dataInstallazione = dataInstallazione;
        this.nomeScuderia = nomeScuderia;
        this.nomeVettura = nomeVettura;
        this.nomeCostruttore = nomeCostruttore;

        if(tipo.equals(TipoComponente.cambio))
        {
            this.nMarce = nMarce;
        }
        if(tipo.equals(TipoComponente.telaio))
        {
            this.materiale = materiale;
            this.peso = peso;
        }
        
        if(tipo.equals(TipoComponente.motore))
        {
            this.cilindrata = cilindrata;
            this.tipoMotore = tipoMotore;
            this.numeroCilindri = numeroCilindri;
        }
    }

    public static Componenti newCambio(String id, TipoComponente tipo, double costo, Date dataInstallazione, String nomeScuderia, String nomeVettura, String nomeCostruttore, int nMarce)
    {   
        Componenti cambio = new Componenti(id, tipo, costo, dataInstallazione, nomeScuderia, nomeVettura, nomeCostruttore, null, null, nMarce, null, null, null);
        return cambio;
    }

    public static Componenti newTelaio(String id, TipoComponente tipo, double costo, Date dataInstallazione, String nomeScuderia, String nomeVettura, String nomeCostruttore, String materiale, int peso)
    {   
        Componenti telaio = new Componenti(id, tipo, costo, dataInstallazione, nomeScuderia, nomeVettura, nomeCostruttore, materiale, peso, null, null, null, null);
        return telaio;
    }

    public static Componenti newMotore(String id, TipoComponente tipo, double costo, Date dataInstallazione, String nomeScuderia, String nomeVettura, String nomeCostruttore, int cilindrata, String tipoMotore, int numeroCilindri)
    {   
        Componenti motore = new Componenti(id, tipo, costo, dataInstallazione, nomeScuderia, nomeVettura, nomeCostruttore, null, null, null, cilindrata, tipoMotore, numeroCilindri);
        return motore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TipoComponente getTipoComponente() {
        return tipo;
    }

    public void setTipoComponente(TipoComponente tipo) {
        this.tipo = tipo;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Date getDataInstallazione() {
        return dataInstallazione;
    }

    public void setDataInstallazione(Date dataInstallazione) {
        this.dataInstallazione = dataInstallazione;
    }

    public String getNomeScuderia() {
        return nomeScuderia;
    }

    public void setNomeScuderia(String nomeScuderia) {
        this.nomeScuderia = nomeScuderia;
    }

    public String getNomeVettura() {
        return nomeVettura;
    }

    public void setNomeVettura(String nomeVettura) {
        this.nomeVettura = nomeVettura;
    }

    public String getNomeCostruttore() {
        return nomeCostruttore;
    }

    public void setNomeCostruttore(String nomeCostruttore) {
        this.nomeCostruttore = nomeCostruttore;
    }

    public String getMateriale() {
        return materiale;
    }

    public void setMateriale(String materiale) {
        this.materiale = materiale;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getnMarce() {
        return nMarce;
    }

    public void setnMarce(Integer nMarce) {
        this.nMarce = nMarce;
    }

    public Integer getCilindrata() {
        return cilindrata;
    }

    public void setCilindrata(Integer cilindrata) {
        this.cilindrata = cilindrata;
    }

    public String getTipoMotore() {
        return tipoMotore;
    }

    public void setTipoMotore(String tipoMotore) {
        this.tipoMotore = tipoMotore;
    }

    public Integer getNumeroCilindri()
    {
        return numeroCilindri;
    }

    public void setNumeroCilindri(int numerocilindri)
    {
        this.numeroCilindri = numerocilindri;
    }

    @Override
    public String toString() 
    {
    return "Componenti{" +
        "id='" + id + '\'' +
        ", tipo=" + tipo +
        ", costo=" + costo +
        ", dataInstallazione=" + dataInstallazione +
        ", nomeScuderia='" + nomeScuderia + '\'' +
        ", nomeVettura='" + nomeVettura + '\'' +
        ", nomeCostruttore='" + nomeCostruttore + '\'' +
        ", materiale='" + materiale + '\'' +
        ", peso=" + peso +
        ", nMarce=" + nMarce +
        ", cilindrata=" + cilindrata +
        ", tipoMotore='" + tipoMotore + '\'' +
        ", numeroCilindri=" + numeroCilindri +
        '}';
    }

}