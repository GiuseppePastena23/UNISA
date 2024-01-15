public class Paninoteca extends Locale {
    private int nPanini;
    private int nBirre;

    public Paninoteca(String name, String indirizzo, int postiDisponibili, int nPanini, int nBirre) {
        super(name, indirizzo, postiDisponibili);
        this.nPanini = nPanini;
        this.nBirre = nBirre;
    }

    // Getters and Setters for nPanini
    public int getNPanini() {
        return nPanini;
    }

    public void setNPanini(int nPanini) {
        this.nPanini = nPanini;
    }

    // Getters and Setters for nBirre
    public int getNBirre() {
        return nBirre;
    }

    public void setNBirre(int nBirre) {
        this.nBirre = nBirre;
    }

    public String toString() {
        return "Paninoteca [name=" + getName() + ", indirizzo=" + getIndirizzo() + ", postiDisponibili=" + getPostiDisponibili()
                + ", nPanini=" + nPanini + ", nBirre=" + nBirre + "]";
    }
}
