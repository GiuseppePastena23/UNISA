public class DipendenteFisso extends Dipendente {

    public DipendenteFisso(String nome, String cognome, Double pagaOraria) {
        super(nome,cognome,pagaOraria);
    }

    public double PagaSettimanale() {
        return super.getMaxOre() * super.getPagaOraria();
    }
}
