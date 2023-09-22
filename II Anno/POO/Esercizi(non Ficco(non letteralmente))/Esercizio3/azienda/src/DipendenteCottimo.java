import java.util.Set;

public class DipendenteCottimo extends DipendenteFisso {

    private int oreDiLavoro;
    private double xStraordinari = 1.5;

    public DipendenteCottimo(String nome, String cognome, Double pagaOraria) {
        super(nome,cognome,pagaOraria);
    }

    public double PagaSettimanale() {
        if (this.oreDiLavoro > super.getMaxOre()) {
            return (super.getMaxOre() * super.getPagaOraria()) + 
                ((this.oreDiLavoro - super.getMaxOre()) * this.getPagaOraria() * this.xStraordinari);
        } else {
            return this.oreDiLavoro * this.getPagaOraria();
        }
    }

    public void setOreDiLavoro(int oreDiLavoro) {
        this.oreDiLavoro = oreDiLavoro;
    }

    public int getOreDiLavoro() {
        return this.oreDiLavoro;
    }

}
