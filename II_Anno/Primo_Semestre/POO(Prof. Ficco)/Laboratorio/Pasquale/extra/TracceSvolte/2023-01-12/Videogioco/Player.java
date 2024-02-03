package personaggi;

public abstract class Player implements ComandiBase, ComandiAvanzati {

    protected static final int DEFAULT_HP = 100;
    protected static final int DEFAULT_ATTACKSTAT = 50;
    protected static final int DEFAULT_DEFENCESTAT = 500;

    protected int hp;
    protected int attackStat;
    protected int defenceStat;
    protected int kill = 0;


    protected Player() {
        this.hp = DEFAULT_HP;
        this.attackStat = DEFAULT_ATTACKSTAT;
        this.defenceStat = DEFAULT_DEFENCESTAT;
    }

    protected Player(int hp, int attackStat, int defenceStat) {
        this.hp = hp;
        this.attackStat = attackStat;
        this.defenceStat = defenceStat;
    }


    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttackStat() {
        return attackStat;
    }

    public void setAttackStat(int attackStat) {
        this.attackStat = attackStat;
    }

    public int getDefenceStat() {
        return defenceStat;
    }

    public void setDefenceStat(int defenceStat) {
        this.defenceStat = defenceStat;
    }

    public int getKillCounter() {
        return kill;
    }

    public void setKill(int kill) {
        this.kill = kill;
    }

    protected void getDamage(int damage) {
        hp -= damage;
    }

    protected boolean isAlive() {
        return hp > 0;
    }


}
