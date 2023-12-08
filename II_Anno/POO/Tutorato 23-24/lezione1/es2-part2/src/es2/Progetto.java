package es2;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Progetto {
    private List<String> idProgetto = new ArrayList<>();
    private List<String> descrizione = new ArrayList<>();
    private List<Integer> budget = new ArrayList<>();
    private final Cliente cliente;
    private GregorianCalendar dataInizio;
    private GregorianCalendar dataFine;

    public Progetto(String descrizione, int budget, Cliente cliente, GregorianCalendar dataInizio) {
        idProgetto.add(Util.genRandomAlphaNumID());
        this.descrizione.add(descrizione);
        this.budget.add(budget);
        this.cliente = cliente;
        this.dataInizio = dataInizio;
    }

    public Progetto(String descrizione, int budget, Cliente cliente, GregorianCalendar dataInizio, GregorianCalendar dataFine) {
        this(descrizione, budget, cliente, dataInizio);
        this.dataFine = dataFine;
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

    public GregorianCalendar getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(GregorianCalendar dataInizio) {
        this.dataInizio = dataInizio;
    }

    public GregorianCalendar getDataFine() {
        return dataFine;
    }

    public void setDataFine(GregorianCalendar dataFine) {
        this.dataFine = dataFine;
    }
}
