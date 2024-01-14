package core;

public class Ticket {
    private int prezzo;
    private boolean stato;

    public Ticket(int prezzo) {
        this.prezzo = prezzo;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public boolean isStato() {
        return stato;
    }

    public void setStato(boolean stato) {
        this.stato = stato;
    }
}
