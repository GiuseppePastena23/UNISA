import java.util.ArrayList;
import java.util.List;

public class Categoria {
    public String nome;
    List<Prodotto> prodotti;

    public Categoria(String nome) {
        this.nome = nome;
        prodotti = new ArrayList<Prodotto>();
    }

    public void add(Prodotto p) {
        prodotti.add(p);
    }
}
