package personaggi;

public class Lottatore extends Player implements ComandiBase, ComandiAvanzati {

    public Lottatore() {
        super(DEFAULT_HP * 2, DEFAULT_ATTACKSTAT * 4, DEFAULT_DEFENCESTAT);
    }

    @Override
    public boolean attacco(Player other) {
        if (this.isAlive() && other.isAlive() && this.getAttackStat() > other.getDefenceStat()) {
            other.getDamage(this.getAttackStat() * 2);
            if (!other.isAlive()) {
                this.kill++;
            }
            return true;
        }
        return false;
    }

    @Override
    public void potenziamento() {
        if (this.isAlive() && this.getKillCounter() > 5) {
            this.setDefenceStat(getDefenceStat() * 2);
            this.setKill(0);
        }
    }


    @Override
    public boolean attaccoAereo(Player other) throws IllegalAccessException {
        throw new IllegalAccessException("Un lottatore non puo' effettuare un attacco aereo");
    }

    @Override
    public boolean fusione(Player two) throws IllegalAccessException {
        if (two instanceof Lottatore) {
            throw new IllegalAccessException("Player two non e' un Lottatore");
        }
        else if (!this.isAlive() || !two.isAlive()) {
            throw new IllegalAccessException("Uno dei due Lottatori e' un morto");
        }

        this.setHp(this.getHp() + two.getHp());
        this.setAttackStat(this.getAttackStat() + two.getAttackStat());
        this.setDefenceStat(two.getDefenceStat());
        this.setKill(0);
        two.setHp(0);
        two = null;
        return true;
    }
}
