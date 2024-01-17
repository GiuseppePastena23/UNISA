
import java.util.*;
import java.lang.*;

public class Ufficio {
    private String nome;
    private int piano;
    private ArrayList<Lavoratore> listaimpiegati;

    public Ufficio(String nome, int piano) {
        this.nome = nome;
        this.piano = piano;
        listaimpiegati = new ArrayList<Lavoratore>();
    }

    public void addLavoratore(Lavoratore l) throws DipinpiuUfficiException {
    try {
        if (listaimpiegati.contains(l)) throw new DuplicateDipendenteException("si!");
        else listaimpiegati.add(l);
    } catch(DuplicateDipendenteException e){e.printStackTrace();}

    }
        public void removeLavoratore(Lavoratore l){
        listaimpiegati.remove(l);
        }

    public ArrayList<Lavoratore> getListaimpiegati() {
        return listaimpiegati;
    }

    public String getNome() {
        return nome;
    }
}
