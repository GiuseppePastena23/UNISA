package Progetto.ClassiQuery;

public class Squadra 
{

    private String nome;
    private int punteggioFinale;
    private String nomeVeicolo;

    public Squadra(String nome, int punteggioFinale, String nomeVeicolo) 
    {
        this.nome = nome;
        this.punteggioFinale = punteggioFinale;
        this.nomeVeicolo = nomeVeicolo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPunteggioFinale() {
        return punteggioFinale;
    }

    public void setPunteggioFinale(int punteggioFinale) {
        this.punteggioFinale = punteggioFinale;
    }

    public String getNomeVeicolo() {
        return nomeVeicolo;
    }

    public void setNomeVeicolo(String nomeVeicolo) {
        this.nomeVeicolo = nomeVeicolo;
    }

    @Override
    public String toString() {
        return "Squadra{" +
                "nome='" + nome + '\'' +
                ", punteggioFinale=" + punteggioFinale +
                ", nomeVeicolo='" + nomeVeicolo + '\'' +
                '}';
    }
}
