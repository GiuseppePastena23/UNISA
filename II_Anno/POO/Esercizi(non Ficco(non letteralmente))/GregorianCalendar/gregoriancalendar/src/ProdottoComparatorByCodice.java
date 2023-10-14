import java.util.Comparator;

public class ProdottoComparatorByCodice implements Comparator<Prodotto> {

    @Override
    public int compare(Prodotto x, Prodotto y) {
        return x.getCodice().compareTo(y.getCodice());
  }
    
}
