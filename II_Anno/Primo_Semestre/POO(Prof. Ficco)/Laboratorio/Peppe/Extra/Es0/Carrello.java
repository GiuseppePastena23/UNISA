package negozio;
import java.util.HashMap;

public class Carrello{
    protected HashMap<Prodotto, Integer> prodotti;
    
    public Carrello(){
        prodotti = new HashMap<Prodotto, Integer>();
    }
    
    public void addProdotto(Prodotto p)
    {
        if(prodotti.containsKey(p))
        {
            // prodotto già presente nel carrello
            int q = prodotti.get(p);
            prodotti.put(p, q+1);
        }
        else
        {
            // prodotto non presente nel carrello
            prodotti.put(p, 1);
        }
    }

    public void removeProdotto(Prodotto p)
    {
        if(prodotti.containsKey(p))
        {
            // prodotto già presente nel carrello
            int q = prodotti.get(p);
            if(q > 1)
            {
                prodotti.put(p, q-1);
            }
            else
            {
                prodotti.remove(p);
            }
        }
        else
        {
            // prodotto non presente nel carrello
            System.out.println("Prodotto non presente nel carrello");
        }
    }

    public void printCarrello()
    {
        System.out.println("Carrello:");
        for(Prodotto p : prodotti.keySet())
        {
            System.out.println(p + " x" + prodotti.get(p));
        }
    }
}