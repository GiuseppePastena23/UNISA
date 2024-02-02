package test;

import core.*;
import gui.GUI;

public class Test {
    public static void main(String[] args) {
        VeicoliManager veicoli = new VeicoliManager();
        veicoli.add(new Autobus(TipoVeicolo.TRENO, 100, 31));
        veicoli.add(new Autobus(TipoVeicolo.TRENO, 104, 5));
        veicoli.add(new Treno(TipoVeicolo.TRENO, 500000, 0));
        veicoli.add(new Treno(TipoVeicolo.TRENO, 540000, 120));
        new GUI(veicoli);
    }
}
