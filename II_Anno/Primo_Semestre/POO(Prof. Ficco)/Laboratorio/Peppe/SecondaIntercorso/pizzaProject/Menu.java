import java.util.ArrayList;
import java.util.HashMap;

public class Menu{
    
    HashMap<String, Integer> pizze;

    public Menu(){
        pizze = new HashMap<>();
    }

    public void addProdotto(Pizza pizza){
        pizze.put(pizza.getNome(), pizza.getPrezzo());
    }

    public void removeProdotto(Pizza p){
        pizze.remove(p.getNome(), p.getPrezzo());
    }

    public boolean searchProdotto(String p){
        return pizze.containsKey(p);
    }

    @Override
    public String toString() {
        return "Menu [pizze=" + pizze + "]";
    }
}

    

    
