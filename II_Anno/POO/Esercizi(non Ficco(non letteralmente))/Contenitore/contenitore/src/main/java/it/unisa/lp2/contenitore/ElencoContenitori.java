package it.unisa.lp2.contenitore;

import java.util.ArrayList;

public class ElencoContenitori {
    ArrayList<Contenitore> contenitori;

    public ElencoContenitori() {
        this.contenitori = new ArrayList<Contenitore>();
    }

    public void addContenitore(Contenitore contenitore) {
        this.contenitori.add(contenitore);
    }

    
}
