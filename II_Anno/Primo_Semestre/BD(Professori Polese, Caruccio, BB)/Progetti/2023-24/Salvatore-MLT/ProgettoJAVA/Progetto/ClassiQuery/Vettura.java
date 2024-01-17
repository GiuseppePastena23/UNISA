package Progetto.ClassiQuery;

public class Vettura 
{

    private String id;
    private String nomeScuderia;
    private int nGara;
    private String modello;

    public Vettura(String id, String nomeScuderia, int nGara, String modello) {
        this.id = id;
        this.nomeScuderia = nomeScuderia;
        this.nGara = nGara;
        this.modello = modello;
    }

    public String getId() 
    {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeScuderia() {
        return nomeScuderia;
    }

    public void setNomeScuderia(String nomeScuderia) {
        this.nomeScuderia = nomeScuderia;
    }

    public int getNGara() {
        return nGara;
    }

    public void setNGara(int nGara) {
        this.nGara = nGara;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    @Override
    public String toString() {
        return "Vettura{" +
                "id='" + id + '\'' +
                ", nomeScuderia='" + nomeScuderia + '\'' +
                ", nGara=" + nGara +
                ", modello='" + modello + '\'' +
                '}';
    }
}