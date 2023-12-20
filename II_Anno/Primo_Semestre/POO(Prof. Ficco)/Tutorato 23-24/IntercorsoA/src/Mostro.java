public abstract class Mostro {
    protected final String name;
    protected int energy, hp;

    public Mostro(String name, int energy, int hp) {
        this.name = name;
        this.energy = energy;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public abstract void attack(Mostro enemy);

    public void defense() {
        hp--;
    }

    public boolean isAlive() {
        return hp >= 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mostro mostro = (Mostro) o;

        if (energy != mostro.energy) return false;
        if (hp != mostro.hp) return false;
        if (!name.equals(mostro.name)) return false;
        return true;
    }


    @Override
    public String toString() {
        return "Mostro{" +
                "name='" + name + '\'' +
                ", energy=" + energy +
                ", hp=" + hp +
                '}';
    }
}
