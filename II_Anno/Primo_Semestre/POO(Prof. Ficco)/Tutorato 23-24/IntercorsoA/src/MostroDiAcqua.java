public class MostroDiAcqua extends Mostro {
    private int temperatura;

    public MostroDiAcqua(String name, int energy, int hp, int temperatura) {
        super(name, energy, hp);
        this.temperatura = temperatura;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public void attack(Mostro enemy) {
        if (this.isAlive() && enemy.isAlive() && enemy instanceof MostroDiPietra) {
            if (energy - (temperatura / 2) >= 0) {
                energy -= temperatura / 2;
                enemy.defense();
            }
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MostroDiAcqua that = (MostroDiAcqua) o;

        return temperatura == that.temperatura;
    }

    @Override
    public String toString() {
        return "MostroDiAcqua{" +
                "temperatura=" + temperatura +
                ", name='" + name + '\'' +
                ", energy=" + energy +
                ", hp=" + hp +
                '}';
    }
}
