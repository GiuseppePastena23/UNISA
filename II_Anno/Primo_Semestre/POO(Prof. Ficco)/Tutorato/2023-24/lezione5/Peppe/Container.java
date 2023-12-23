import java.util.ArrayList;
import java.util.List;

public class Container {
    
    protected ArrayList<Prodotto> prodotti;
    protected double pesoMax;

    public Container(double pesoMax)
    {
        this.pesoMax = pesoMax;
        prodotti = new ArrayList<>();
    }

    public List<Prodotto> getProdotti(double pesoMin, double pesoMax)
    {   
        ArrayList<Prodotto> res = new ArrayList<>();
        if(prodotti.isEmpty()){
            return res;
        }
        
        double pWeight = 0;
        for(Prodotto p : prodotti){
            pWeight = p.getWeight();
            if(pWeight >= pesoMin && pWeight <= pesoMax){
                res.add(p);
            }
        }
        return res;
        
    }

    public void addProdotto(Prodotto x)
    {
        if(!prodotti.contains(x) && (x.getWeight() + this.getPesoTotale()) <= pesoMax){
            prodotti.add(x);
        }
    }

    public Prodotto removeProdotto(Prodotto x){
        if(!prodotti.remove(x))
        {
            return null;
        }
        
        return x;
    }

    public double getPesoTotale()
    {   
        double pesoTotale = 0;
        for(Prodotto p : prodotti){
            pesoTotale += p.getWeight();
        }
        return pesoTotale;
    }
}
