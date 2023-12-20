package negozio;
import java.util.ArrayList;




public class Negozio {
    
    protected ArrayList<Categoria> categorie;
    protected ArrayList<Utente> utenti;
    
    public Negozio() {
        categorie = new ArrayList<>();
        utenti = new ArrayList<>();
    }

    public void addCategoria(Categoria categoria) {
        if (!categorie.contains(categoria)) {
            categorie.add(categoria);
        }
    }

    public void newUser(Utente utente)
    {
        utenti.add(utente);
    }
}