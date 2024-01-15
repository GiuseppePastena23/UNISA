import java.util.*;
import java.io.*;

public class LocaliManager {

    List<Locale> locali;
    
    public LocaliManager(){
        locali = new ArrayList<>();
    }
    
    public void addLocale(Locale locale) {
        locali.add(locale);
    }

    

    public void printPizzerieByPizza(String pizza){
        locali.stream().filter(l -> (l instanceof Pizzeria) &&  ((Pizzeria)l).getMenu().searchProdotto(pizza)).forEach(p -> System.out.println(p.toString()));
    }

    public void salvaNoPosti(String nome){
        try(PrintWriter obj = (new PrintWriter(nome))){
            locali.stream().filter(l -> l.getPostiDisponibili() <= 0).forEach(l -> obj.write(l.toString()));
        } catch (IOException e) {
            // Handle the IOException here
            e.printStackTrace();
        }
    }
    

}
