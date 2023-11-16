package game.scripts;

public class Orco extends Personaggio {

    private final static int DEFAULTENERGIAORCO = 200;
    private final static int DEFAULTATTACKPOWERORCO = 100;

    public Orco(int startingPosX, int startingPosY) {
        super("Orco", DEFAULTENERGIAORCO, startingPosX, startingPosY);
    }

    public Orco(Posizione posizione) {
        super("Orco", DEFAULTENERGIAORCO, posizione);
    }

    @Override
    public Posizione getPosizione(Personaggio pers) {
        return posizione;
    }

    @Override
    public void colpisci(Personaggio pers) {
        if (posizione.isEquals(pers.posizione))
            pers.subisciDanno(DEFAULTATTACKPOWERORCO);
        else
            System.out.println("Attacco di " + tipo + id + " fallito");
    }
}
