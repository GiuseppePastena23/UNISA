public class Pizzeria extends Locale{
    private Menu pizzeMenu;

    public Pizzeria(String name, String indirizzo, int postiDisponibili, Menu menu){
        super(name, indirizzo, postiDisponibili);
        this.pizzeMenu = menu;
    }

    public Menu getMenu() {
        return pizzeMenu;
    }

    
    


}
