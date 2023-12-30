
public class Libro {    
    private String titolo;
    private String autore;
    private String editore;
    private int numCopie;

	/**
	 * @param titolo
	 * @param autore
     * @param editore
	 * @param numCopie
	 */
    public Libro(String titolo, String autore, String editore, int numCopie) {
		this.titolo = titolo;
		this.autore = autore;
		this.editore = editore;
		this.numCopie = numCopie;
	}

    /**
     * @param titolo the titolo to set
     */
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    /**
     * @return the titolo
     */
    public String getTitolo() {
        return titolo;
    }

    /**
     * @param autore the autore to set
     */
    public void setAutore(String autore) {
        this.autore = autore;
    }
    /**
     * @return the autore
     */
    public String getAutore() {
        return autore;
    }

    /**
     * @param editore the editore to set
     */
    public void setEditore(String editore) {
        this.editore = editore;
    }
    /**
     * @return the editore
     */
    public String getEditore() {
        return editore;
    }

    /**
     * @param numCopie the numCopie to set
     */
    public void setNumCopie(int numCopie) {
        this.numCopie = numCopie;
    }
    /**
     * @return the numCopie
     */
    public int getNumCopie() {
        return numCopie;
    }

    @Override
    public String toString() {
        return this.titolo + " - " + this.autore + " " + this.editore;
    }

    
}
