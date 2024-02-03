import java.util.HashMap;
import java.util.Map;

public class Carrello {
    private Map<Prodotto, Integer> cart;

    public Carrello() {
        cart = new HashMap<Prodotto, Integer>();
    }

    public boolean aggiungiProdotto(Prodotto p) {
        int quantita = cart.getOrDefault(p, 1) + 1;
        cart.put(p, quantita);
        return true;
    }

    public boolean aggiungiProdotto(Prodotto p, int quantita) {
        if (quantita < 0) return false;

        int q = cart.getOrDefault(p, 0) + quantita;
        cart.put(p, q);
        return true;
    }

    public boolean rimuoviProdotto(Prodotto p) {
        if (cart.containsKey(p)) {
            cart.remove(p);
            return true;
        }
        return false;
    }

    public boolean rimuoviProdotto(String nomeProdotto) {
        if (cart.containsKey())
    }


}
