import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Supermercato {
    List<Prodotto> prodotti;
    Comparator<Prodotto> comparator;
    
    public Supermercato() {
        comparator = new ProdottoComparatorByCodice();
        prodotti = new ArrayList<Prodotto>() {
            public boolean add(Prodotto mt) {
                super.add(mt);
                Collections.sort(prodotti, comparator);
                return true;
            }
        };
    }

    public void aggiungiProdotto(Prodotto prodotto) {
        prodotti.add(prodotto);
    }

    public String daiTipoProdotto(int i) {
        return this.prodotti.get(i).toString();
    }

    public Prodotto getMinimo() {
        Prodotto min = null;
        for (Prodotto prodotto : prodotti) {
            if (min == null || prodotto.getPrezzo() < min.getPrezzo()) {
                min = prodotto;
            }
        }
        return min;
    }

    public Prodotto getMassimo() {
        Prodotto max = null;
        for (Prodotto prodotto : prodotti) {
            if (max == null || prodotto.getPrezzo() > max.getPrezzo()) {
                max = prodotto;
            }
        }
        return max;
    }

    ArrayList<Prodotto> cerca(String marca) {
        ArrayList<Prodotto> marcati = new ArrayList<Prodotto>();
        prodotti.forEach(p -> {
            if (p.getMarca() == marca) marcati.add(p);
        });
        return marcati;
    }

}
