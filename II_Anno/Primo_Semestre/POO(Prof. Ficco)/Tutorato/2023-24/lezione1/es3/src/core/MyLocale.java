package core;

public abstract class MyLocale {
    public final String nome;
    public final String indirizzo;
    public int postiDisponibili;

    public MyLocale(String nome, String indirizzo, int postiDisponibili) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.postiDisponibili = postiDisponibili;
    }

    public String getNome() {
        return nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public int getPostiDisponibili() {
        return postiDisponibili;
    }

    public void setPostiDisponibili(int postiDisponibili) {
        this.postiDisponibili = postiDisponibili;
    }

    @Override
    public String toString() {
        return "core.MyLocale{" +
                "nome='" + nome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", postiDisponibili=" + postiDisponibili +
                '}';
    }
}
