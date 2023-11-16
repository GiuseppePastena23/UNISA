package Fantasy;
public class Cavaliere extends Personaggio{
    protected static int id = 0;
    public Cavaliere(int energy, Posizione startPos){
        super(++id, "Cavaliere", energy, startPos);
    }
    
    public Posizione posizione(){
        return this.pos;
    }

    public boolean colpisci(Personaggio pers){
        if(this.pos.x == pers.pos.x && this.pos.y == pers.pos.y && energy > 0){
            this.energy--;
            return true;
        }
        else{
            return false;
        }
    }

}