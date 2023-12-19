package negozio;
import java.util.ArrayList;

public class Categoria{
    protected String name;
    protected ArrayList<Prodotto> prodotti;

    public Categoria(String name){
        this.name = name;
        prodotti = new ArrayList<Prodotto>();
    }

    public void addProdotto(Prodotto p){
        prodotti.add(p);
    }
}