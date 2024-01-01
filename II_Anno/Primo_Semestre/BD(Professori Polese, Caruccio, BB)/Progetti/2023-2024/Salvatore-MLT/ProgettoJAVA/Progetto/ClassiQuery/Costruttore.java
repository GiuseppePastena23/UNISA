package Progetto.ClassiQuery;

public class Costruttore {

    private String ragioneSociale;
    private String nome;
    private String sedeFabbrica;

    public Costruttore(String ragioneSociale, String nome, String sedeFabbrica) {
        this.ragioneSociale = ragioneSociale;
        this.nome = nome;
        this.sedeFabbrica = sedeFabbrica;
    }

    public String getRagioneSociale() {
        return ragioneSociale;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSedeFabbrica() {
        return sedeFabbrica;
    }

    public void setSedeFabbrica(String sedeFabbrica) {
        this.sedeFabbrica = sedeFabbrica;
    }

    @Override
    public String toString() {
        return "Costruttore{" +
                "ragioneSociale='" + ragioneSociale + '\'' +
                ", nome='" + nome + '\'' +
                ", sedeFabbrica='" + sedeFabbrica + '\'' +
                '}';
    }
}