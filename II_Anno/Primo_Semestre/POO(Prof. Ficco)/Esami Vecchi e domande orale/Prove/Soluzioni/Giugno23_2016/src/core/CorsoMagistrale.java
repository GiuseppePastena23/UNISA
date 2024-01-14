package core;

import java.util.List;

public class CorsoMagistrale extends Corso {
    private List<Indirizzi> indirizzi;

    public CorsoMagistrale(String nome, String docente, int oreFrontali, List<Indirizzi> indirizzi) {
        super(nome, docente, oreFrontali);
        this.indirizzi = indirizzi;
    }

    public List<Indirizzi> dammiListaIndirizziStudio() {
        return indirizzi;
    }

    @Override
    public int dammiNumeroCFU() {
        return oreFrontali / 8;
    }
}
