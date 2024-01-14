public class Ente{
    protected String nome;
    protected String indirizzo;
    protected String descrizione;

    public Ente(String nome, String indirizzo, String descrizione){
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.descrizione = descrizione;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}