package core;

public abstract class Veicolo implements TransActions {
    public static int lastID;

    protected final int id;
    protected TipoVeicolo tipoVeicolo;
    protected int kmPercorsi;

    public Veicolo(TipoVeicolo tipoVeicolo, int kmPercorsi) {
        id = ++lastID;
        this.tipoVeicolo = tipoVeicolo;
        this.kmPercorsi  = kmPercorsi;
    }

    protected void stampa(String msg) {
        System.out.println(toString());
    }

    public boolean checkTicket(Ticket t) {
        if (t.isStato()) {
            t.setStato(false);
            return true;
        }
        return false;
    }

    public Ticket buyTicket(int money) throws NotEnoughMoneyException {
        if (money >= PREZZOFISSO) {
            return new Ticket(PREZZOFISSO);
        } else {
            throw new NotEnoughMoneyException();
        }
    }

    @Override
    public String toString() {
        return "id: " + id + " tipoVeicolo: " + tipoVeicolo;
    }
}
