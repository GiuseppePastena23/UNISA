package core;

public class CorsoTriennale extends Corso {
    private int oreLab;

    public CorsoTriennale(String nome, String docente, int oreFrontali, int oreLab) {
        super(nome, docente, oreFrontali);
        this.oreLab = oreLab;
    }

    public int dammiNumeroCFU() {
        int somma = 0;
        somma += oreFrontali / 8;
        somma += oreLab / 10;
        return somma;
    }

    @Override
    public int oreTotali() {
        return oreFrontali + oreLab;
    }

    @Override
    public int calcolaCosto() {
        return super.calcolaCosto() + (oreLab * 35);
    }
}
