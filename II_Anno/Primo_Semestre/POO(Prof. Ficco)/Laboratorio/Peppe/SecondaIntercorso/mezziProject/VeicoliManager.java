package core.mezzi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class VeicoliManager {

    private List<Veicolo> veicoli;
    
    public VeicoliManager(){
        veicoli = new ArrayList<>();
    }

    public void addVeicolo(Veicolo v){
        veicoli.add(v);
    }

    public List<Veicolo> treniInRitardo(int num){
        return veicoli.stream().filter(t -> (
                t instanceof Treno && ((Treno)t).getMinRitardo() >= num)
            ).collect(Collectors.toList());
    }

    public List<Veicolo> autobusConNPosti(int num){
        return veicoli.stream().filter(t -> 
            t instanceof Autobus && ((Autobus)t).getPosti() >= num
        ).collect(Collectors.toList());
    }
}
