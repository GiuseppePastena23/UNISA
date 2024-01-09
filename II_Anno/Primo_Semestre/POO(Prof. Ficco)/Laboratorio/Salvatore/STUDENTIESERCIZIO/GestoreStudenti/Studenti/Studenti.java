package GestoreStudenti.Studenti;

public class Studenti 
{

    public enum Categoria
    {
        IN_CORSO,
        FUORI_CORSO
    }

    private String Nome;
    private String Cognome;
    private int Eta;
    private Categoria categoria;

    public Studenti(String nome, String cognome, int eta, Categoria categoria) {
        this.Nome = nome;
        this.Cognome = cognome;
        this.Eta = eta;
        this.categoria = categoria;
    }

    // Getters
    public String getNome() {
        return Nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public int getEta() {
        return Eta;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    // Setters
    public void setNome(String nome) {
        this.Nome = nome;
    }

    public void setCognome(String cognome) {
        this.Cognome = cognome;
    }

    public void setEta(int eta) {
        this.Eta = eta;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    // toString method
    @Override
    public String toString() {
        return "Studenti{" +
                "Nome='" + Nome + '\'' +
                ", Cognome='" + Cognome + '\'' +
                ", Eta=" + Eta +
                ", categoria=" + categoria +
                '}';
    }

}
