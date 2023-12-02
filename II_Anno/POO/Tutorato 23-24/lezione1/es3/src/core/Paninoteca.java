package core;

public class Paninoteca extends MyLocale {
    public int panini;
    public int birre;

    public Paninoteca(String nome, String indirizzo, int postiDisponibili, int panini, int birre) {
        super(nome, indirizzo, postiDisponibili);
        this.panini = panini;
        this.birre = birre;
    }

    public int getPanini() {
        return panini;
    }

    public void setPanini(int panini) {
        this.panini = panini;
    }

    public int getBirre() {
        return birre;
    }

    public void setBirre(int birre) {
        this.birre = birre;
    }
}
