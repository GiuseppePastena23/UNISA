import java.util.Objects;

import javax.management.ObjectName;

public class MostroDiFuoco extends Mostro{

    protected int potenza;

    public MostroDiFuoco(int hp, int energy, int potenza){
        super(hp, energy);
        this.potenza = potenza;
    }

    public void attacca(Mostro m){
        if(m instanceof MostroDiAcqua && this.getHp() > 0 && this.getEnergy() > 0){
            this.setEnergy(m.getEnergy() - potenza);
            m.difendi();
        }
    }

    public int getPotenza()
    {
        return potenza;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;

        if (getClass() != o.getClass()) return false;

        MostroDiFuoco i = (MostroDiFuoco) o;
        return getHp() == i.getHp() && i.getEnergy() == getEnergy() && i.getPotenza() == getPotenza();
    }

    @Override
    public String toString(){
        return "Mostro[Tipo: Fuoco" + "HP: " + this.hp + " Energia: " + this.energy + " Potenza: " + this.potenza + "]\n";
    }

    
}