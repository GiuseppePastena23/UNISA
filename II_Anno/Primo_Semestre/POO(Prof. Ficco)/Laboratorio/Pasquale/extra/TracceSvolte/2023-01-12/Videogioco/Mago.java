package personaggi;

public class Mago extends Player implements ComandiBase, ComandiAvanzati {
    protected static final int DEFAULT_MAGIC = 50;
    protected int magic;

    public Mago() {
        super();
        magic = DEFAULT_MAGIC;
    }

    @Override
    public boolean fusione(Player two) throws IllegalAccessException {
        throw new IllegalAccessException("Un mago non puo' fondersi");
    }

    @Override
    public boolean attaccoAereo(Player other) throws IllegalAccessException {
        throw new IllegalAccessException("Un mago non puo' effettuare un attacco aereo");
    }

    @Override
    public void potenziamento() {

    }
}
