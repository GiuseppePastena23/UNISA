public class MostroDiPietra extends Mostro{

    protected int peso;

    public MostroDiPietra(int hp, int energy, int peso){
        super(hp, energy);
        this.peso = peso;
    }

    public void attacca(Mostro m){
        if(m instanceof MostroDiFuoco && this.getHp() > 0 && this.getEnergy() > 0){
            this.setEnergy(m.getEnergy() - (peso/3));
            m.difendi();
        }
    }

    public int getPeso() {
        return peso;
    }
    

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;

        if (getClass() != o.getClass()) return false;

        MostroDiPietra i = (MostroDiPietra) o;
        return getHp() == i.getHp() && i.getEnergy() == getEnergy() && i.getPeso() == getPeso();
    }

    @Override
    public String toString(){
        return "Mostro[Tipo: Pietra" + "HP: " + this.hp + " Energia: " + this.energy + " Peso: " + this.peso + "]\n";
    }
}