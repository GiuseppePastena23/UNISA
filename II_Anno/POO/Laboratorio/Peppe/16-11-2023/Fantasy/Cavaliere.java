package Fantasy;
public abstract class Cavaliere extends Personaggio{
    public static int identificatore = 0;
    public Cavaliere(String id, int energy, Posizione startPos){
        super(id, "id", energy, startPos);
        identificatore++;
    }
}