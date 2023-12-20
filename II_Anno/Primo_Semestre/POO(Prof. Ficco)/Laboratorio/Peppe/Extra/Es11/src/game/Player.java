package game;

public abstract class Player implements ComandiAvanzati, ComandiBase{

    protected static final int DEFAULT_HP = 100;
    protected static final int DEFAULT_ATT = 10;
    protected static final int DEFAULT_DEF = 5;

    protected int hp;
    protected int attPoint;
    protected int defPoint;
    protected int frags = 0;

    protected Player(){
        this.hp = DEFAULT_HP;
        this.attPoint = DEFAULT_ATT;
        this.defPoint = DEFAULT_DEF;
    }

    protected Player(int hp, int attPoint, int defPoint){
        this.hp = hp;
        this.attPoint = attPoint;
        this.defPoint = defPoint;
    }

    public int getHp(){
        return hp;
    }

    public void setHp(int value){
        this.hp = value;
    }

    // crea funzioni get e set
    public int getAttPoint(){
        return attPoint;
    }

    public void setAttPoint(int value){
        this.attPoint = value;
    }

    public int getDefPoint(){
        return defPoint;
    }

    public void setDefPoint(int value){
        this.defPoint = value;
    }

    public int getFrags(){
        return frags;
    }

    public void setFrags(int value){
        this.frags = value;
    }

    public void addFrag(){
        this.frags++;
    }

    public boolean isAlive(){
        return this.hp > 0;
    }
}
