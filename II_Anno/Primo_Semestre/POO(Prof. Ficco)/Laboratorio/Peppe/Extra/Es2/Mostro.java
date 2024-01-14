public abstract class Mostro implements ComandiMostro{
    protected int hp;
    protected int energy;
    

    protected Mostro(int hp, int energy){
        this.hp = hp;
        this.energy = energy;
    }

    public void setHp(int hp){
        this.hp = hp;
        if(this.hp < 0)
        {
            this.hp = 0;
        }
    }

    public int getHp(){
        return hp;
    }   

    public void setEnergy(int energy){
        this.energy = energy;
        if(this.energy < 0)
        {
            this.energy = 0;
        }
    }

    public int getEnergy(){
        return energy;
    }

    public void difendi()
    {
        this.setHp(getHp() - 1);
    }

    
}