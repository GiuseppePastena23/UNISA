public class MostroDiAcqua extends Mostro{

    protected int temperatura;

    public MostroDiAcqua(int hp, int energy, int temperatura){
        super(hp, energy);
        this.temperatura = temperatura;
    }

    public void attacca(Mostro m){
        if(m instanceof MostroDiFuoco && this.getHp() > 0 && this.getEnergy() > 0){
            if(m instanceof MostroDiPietra && this.getHp() == 0 ) {
            this.setEnergy(m.getEnergy() - (temperatura/2));
            m.difendi();
            }
        }   

    }

    public int getTemperatura() {
        return temperatura;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;

        if (getClass() != o.getClass()) return false;

        MostroDiAcqua i = (MostroDiAcqua) o;
        return getHp() == i.getHp() && i.getEnergy() == getEnergy() && i.getTemperatura() == getTemperatura();
    }


    @Override
    public String toString(){
        return "Mostro[Tipo: Acqua" + "HP: " + this.hp + " Energia: " + this.energy + " Temperatura: " + this.temperatura + "]\n";
    }
}

