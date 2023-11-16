package Fantasy;
public class Orco extends Personaggio{
    public static int identificatore = 0;
    public Orco(String id, int energy, Posizione startPos){
        super(id, "id", energy, startPos);
        identificatore++;
    }
}