package es2;

import java.util.ArrayList;
import java.util.List;

public class Progetto {
    private List<String> idProgetto = new ArrayList<>();
    private List<String> descrizione = new ArrayList<>();
    private List<Integer> budget = new ArrayList<>();
    private final Cliente cliente;

    public Progetto(String descrizione, int budget, Cliente cliente) {
        idProgetto.add(Util.genRandomAlphaNumID());
        this.descrizione.add(descrizione);
        this.budget.add(budget);
        this.cliente = cliente;
    }

    public String getIdProgetto() {
        return idProgetto.getLast();
    }

    public String getDescrizione() {
        return descrizione.getLast();
    }

    public int getBudget() {
        return budget.getLast();
    }

}
