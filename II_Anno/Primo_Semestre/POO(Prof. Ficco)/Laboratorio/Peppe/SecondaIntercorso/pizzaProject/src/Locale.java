public abstract class Locale {

    private String name;
    private String indirizzo;
    private int postiDisponibili;

    protected Locale(String name, String indirizzo, int postiDisponibili) {
        this.name = name;
        this.indirizzo = indirizzo;
        this.postiDisponibili = postiDisponibili;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public int getPostiDisponibili() {
        return postiDisponibili;
    }

    public void setPostiDisponibili(int postiDisponibili) {
        this.postiDisponibili = postiDisponibili;
    }

    @Override
    public String toString() {
        return 
                "Nome= '" + name + '\'' +
                ", Indirizzo= '" + indirizzo + '\'' +
                ", Posti Disponibili= " + postiDisponibili + " ";
    }
}