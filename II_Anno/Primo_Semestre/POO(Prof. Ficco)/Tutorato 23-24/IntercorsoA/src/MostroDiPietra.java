public class MostroDiPietra extends Mostro {
    private int peso;

    public MostroDiPietra(String name, int energy, int hp, int peso) {
        super(name, energy, hp);
        this.peso = peso;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public void attack(Mostro enemy) {
        if (this.isAlive() && enemy.isAlive() &&  enemy instanceof MostroDiFuoco) {
            if (energy - (peso / 3) >= 0) {
                energy -= peso / 3;
                enemy.defense();
            }
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MostroDiPietra that = (MostroDiPietra) o;

        return peso == that.peso;
    }

    @Override
    public String toString() {
        return "MostroDiPietra{" +
                "peso=" + peso +
                ", name='" + name + '\'' +
                ", energy=" + energy +
                ", hp=" + hp +
                '}';
    }

}
