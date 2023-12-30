package game;

public class Mago extends Player {
  private int magicLevel;

  public Mago() {
    super(DEFAULT_HP, DEFAULT_ATT, DEFAULT_DEF);
    this.magicLevel = 50;
  }

  @Override
  public boolean attacco(Player other) {
    if (this.isAlive() && other.isAlive() && this.getAttPoint() >= other.getDefPoint()) {
      int damage = this.getAttPoint() + this.magicLevel;
      other.setHp(other.getHp() - damage);
      if (other.getHp() <= 0) {
        this.addFrag();
      }
      return true;
    } else {
      int damage = other.getDefPoint() - this.getAttPoint();
      this.setHp(this.getHp() - damage);
      if (this.getHp() <= 0) {
        other.addFrag();
      }
      return false;
    }
  }

  @Override
  public void potenziamento() {
    if (this.isAlive() && this.getFrags() > 10) {
      this.magicLevel += 50;
      this.setAttPoint(this.getAttPoint() * 2);
      this.setDefPoint(this.getDefPoint() * 4);
      this.setFrags(0);
    }
  }

  @Override
  public void attaccoAereo(Player other) throws IllegalActionException {
    throw new IllegalActionException("Mago cannot perform aerial attack");
  }

  @Override
  public boolean fusione(Player two) throws IllegalActionException {
    throw new IllegalActionException("Mago cannot perform fusion");
  }
}

