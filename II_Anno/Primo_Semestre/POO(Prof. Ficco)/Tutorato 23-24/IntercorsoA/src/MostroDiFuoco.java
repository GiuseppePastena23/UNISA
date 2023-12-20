public class MostroDiFuoco extends Mostro {
    private int power;

    public MostroDiFuoco(String name, int energy, int hp, int power) {
        super(name, energy, hp);
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public void attack(Mostro enemy) {
        if (this.isAlive() && enemy.isAlive() &&  enemy instanceof MostroDiFuoco) {
            if (energy - power >= 0) {
                energy -= power;
                enemy.defense();
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MostroDiFuoco that = (MostroDiFuoco) o;

        return power == that.power;
    }

    @Override
    public String toString() {
        return "MostroDiFuoco{" +
                "power=" + power +
                ", name='" + name + '\'' +
                ", energy=" + energy +
                ", hp=" + hp +
                '}';
    }
}
