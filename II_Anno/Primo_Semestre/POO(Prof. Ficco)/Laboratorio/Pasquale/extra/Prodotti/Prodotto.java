public class Prodotto {
    public int id;
    public String nome;
    public float prezzo;
    public int quantitaDisponibile;

    public Prodotto(int id, String nome, float prezzo, int quantitaDisponibile) {
        this.id = id;
        this.nome = nome;
        this.prezzo = prezzo;
        this.quantitaDisponibile = quantitaDisponibile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public int getQuantitaDisponibile() {
        return quantitaDisponibile;
    }

    public void setQuantitaDisponibile(int quantitaDisponibile) {
        this.quantitaDisponibile = quantitaDisponibile;
    }

    @Override
    public String toString() {
        return String.format("Prodotto {id: %d nome: %s prezzo: %f quant_disp: %d}", id, nome, prezzo, quantitaDisponibile);
    }
}
