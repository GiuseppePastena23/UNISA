package game.scripts;

public class Cavaliere extends Personaggio {
    private final static int DEFAULTENERGIACAVALIERE = 100;
    private final static int DEFAULTATTACKPOWERCAVALIERE = 50;

    public Cavaliere(int startingPosX, int startingPosY) {
        super("Cavaliere", DEFAULTENERGIACAVALIERE, startingPosX, startingPosY);
    }

    public Cavaliere(Posizione posizione) {
        super("Cavaliere", DEFAULTENERGIACAVALIERE, posizione);
    }


    @Override
    public Posizione getPosizione(Personaggio pers) {
        return posizione;
    }


    @Override
    public void colpisci(Personaggio pers) {
        if (posizione.isEquals(pers.posizione))
            pers.subisciDanno(DEFAULTATTACKPOWERCAVALIERE);
        else
            System.out.println("Attacco di " + tipo + id + "fallito");
    }

}
