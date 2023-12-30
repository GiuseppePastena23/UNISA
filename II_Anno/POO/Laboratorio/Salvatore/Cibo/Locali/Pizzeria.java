package Locali;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;

public class Pizzeria 
{
    public class Pizza
    {
        
        private String Nome;
        private int Prezzo;

        Pizza(String Nome, int Prezzo)
        {
            this.Nome = Nome;
            this.Prezzo = Prezzo;
        }

        public String getNome(){return this.Nome;}
        public int getPrezzo(){return this.Prezzo;}

        public void setNome(String Nome){this.Nome = Nome;}
        public void setPrezzo(int Prezzo){this.Prezzo = Prezzo;}
    }

    private static List<Pizza> MenuPizza = new ArrayList<>();
    
    //aggiungi una pizza
    public void addPizza(Pizza pizza)
    {
        for(int i = 0; i < MenuPizza.size(); i++) //controllo duplicati
        {
            if(MenuPizza.get(i).equals(pizza))
            {
                return;
            }
        }
        //else
        MenuPizza.add(pizza);
    }

    //rimuovi una pizza specifica
    public void removePizza(Pizza pizza)
    {
        for(int i = 0; i < MenuPizza.size(); i++)
        {
            if(MenuPizza.get(i).equals(pizza))
            {
                MenuPizza.remove(i);
            }
        }
    }

    public static List<Pizza> getMenu()
    {
        return MenuPizza;
    }


}
