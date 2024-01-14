package core;

public class CorsoDottorato extends Corso {
    private Lingue lingua;

    public CorsoDottorato(String nome, String docente, int oreFrontali, Lingue lingua) {
        super(nome, docente, oreFrontali);
        this.lingua = lingua;
    }

    @Override
    public int dammiNumeroCFU() {
        return oreFrontali / 4;
    }

    @Override
    public int calcolaCosto() {
        return super.calcolaCosto() * ((lingua == Lingue.INGLESE) ? 2 : 1);
    }

}
