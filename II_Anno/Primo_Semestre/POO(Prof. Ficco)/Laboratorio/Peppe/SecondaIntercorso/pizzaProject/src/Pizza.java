public class Pizza {
    
    private String nome;
    private int prezzo;
    
    public Pizza(String nome, int prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getPrezzo() {
        return prezzo;
    }
    
    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }
    
    @Override
    public String toString() {
        return "Pizza nome=" + nome + " prezzo=" + prezzo;
    }
}