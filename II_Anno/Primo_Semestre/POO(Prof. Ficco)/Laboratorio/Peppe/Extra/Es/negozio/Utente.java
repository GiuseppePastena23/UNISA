package negozio;
public class Utente{
    protected String name;
    protected Carrello carrello;

    public Utente(String name)
    {
        this.name = name;
        carrello = new Carrello();
    }

    public void addProdottoToCarrello(Prodotto p)
    {
        carrello.addProdotto(p);
    }
}