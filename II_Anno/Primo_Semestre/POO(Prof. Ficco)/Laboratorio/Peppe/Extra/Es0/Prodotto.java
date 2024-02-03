package negozio;
public class Prodotto
{
    protected int id;
    protected String name;
    protected double price; 
    protected int quantity;

    // costruttore

    public Prodotto(int id, String name, double price, int quantity)
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }


    @Override
    public String toString()
    {
        return "Prodotto [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
    }
}