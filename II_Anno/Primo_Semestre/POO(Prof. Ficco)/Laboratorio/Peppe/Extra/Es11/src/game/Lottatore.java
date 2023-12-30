package game;
public class Lottatore extends Player{
    public Lottatore()
    {
        super(DEFAULT_HP * 2, DEFAULT_ATT * 4, DEFAULT_DEF);
    }

    public boolean attacco(Player other) {
          if((this.getHp() > 0) && (other.getHp() > 0) && this.getAttPoint() > other.getDefPoint()){
            other.setHp(other.getHp() - (this.getAttPoint() * 2));
            if(other.getHp() <= 0){
              this.addFrag();
            }
            return true;
          }
          else
          {
            return false;
          }
    }

    public void potenziamento(){
        if(this.isAlive() && this.getFrags() > 5){
          this.setDefPoint(getDefPoint() * 2);
          this.setFrags(0);
        }
    }

    public void attaccoAereo(Player other) throws IllegalActionException
    {
        throw new IllegalActionException("Lottatore non può effetturare attacco aereo");
    }

    public boolean fusione(Player two) throws IllegalActionException
    {
        
        if(this.isAlive() && two.isAlive() && two instanceof Lottatore)
        {
          this.setHp(this.getHp() + two.getHp());
          this.setAttPoint(this.getAttPoint() + two.getAttPoint());
          this.setDefPoint(two.getDefPoint());
          this.setFrags(0);

          two = null;
          return true;          
        }
        else {
          return false;
        }
    
  }
}

