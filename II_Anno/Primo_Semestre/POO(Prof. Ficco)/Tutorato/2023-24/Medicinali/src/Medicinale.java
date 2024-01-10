import java.util.GregorianCalendar;

public class Medicinale {
    private String nome;
    private String azienda;
    private GregorianCalendar dataScadenza;
    private int unitaDisp;

    public Medicinale(String nome, String azienda, GregorianCalendar dataScadenza, int unitaDisp) {
        this.nome = nome;
        this.azienda = azienda;
        this.dataScadenza = dataScadenza;
        this.unitaDisp = unitaDisp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAzienda() {
        return azienda;
    }

    public void setAzienda(String azienda) {
        this.azienda = azienda;
    }

    public GregorianCalendar getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(GregorianCalendar dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public int getUnitaDisp() {
        return unitaDisp;
    }

    public void setUnitaDisp(int unitaDisp) {
        this.unitaDisp = unitaDisp;
    }

    @Override
    public String toString() {
        return "Medicinale{" +
                "nome='" + nome + '\'' +
                ", azienda='" + azienda + '\'' +
                ", dataScadenza=" + dataScadenza +
                ", unitaDisp=" + unitaDisp +
                '}';
    }
}
